/*
 * Copyright (c) 2017, Li Bo/Alex All rights reserved.
 * 
 * http://blog.sina.com.cn/alex4java
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 
package net.alex.scan.scanner;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import net.alex.scan.adapter.ScanAdapter;
import net.alex.scan.config.Config;
import net.alex.scan.error.ScanException;
import net.alex.scan.factory.ScannerFactory;
import net.alex.scan.model.ScanConfigure;
import net.alex.scan.model.ScanResultInvoke;
import net.alex.scan.tool.PathUtils;
import net.alex.scan.tool.PropUtils;
import net.alex.scan.tool.ScanUtils;
import net.alex.scan.tool.StringUtils;
import net.alex.scan.validate.FileValidation;

/**
 * @ClassName: Scanner
 * @Description: 文件扫描器
 * @author: 李博/Alex
 * @date: 2017-2-28 下午2:26:30
 * @email:  alexlibochn@china-pui.com.cn
 */
public class Scanner {
	
	/**
	 * @fieldName: resultList
	 * @fieldType: List<ScanResultInvoke>
	 * @Description: 结果集
	 */
	private List<ScanResultInvoke> resultList;

	@Deprecated
	public Scanner() {
	}
	
	
	/**
	 * @Title: scan
	 * @Description: 系统默认加载方法扫描
	 * @return
	 * @throws ScanException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @return: List<ScanResultInvoke>
	 */
	public List<ScanResultInvoke> scan() throws ScanException, IOException, ClassNotFoundException{
		return scan(Config.DEFAULT_SCANNER_PATH);
	}
	
	/**
	 * @Title: scan
	 * @Description: 扫描器
	 * @param propertiesPath
	 * @return
	 * @throws ScanException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @return: List<ScanResultInvoke>
	 */
	public List<ScanResultInvoke> scan(String propertiesPath) throws ScanException, IOException, ClassNotFoundException{
		
		//校验
		if(StringUtils.isNull(propertiesPath))
			throw new ScanException("传入的propertiesPath为空!");
		
		//ScanAdapter.setScanPropertiesPath(propertiesPath);

		if(StringUtils.isNull(Config.INCLUDE_PACKAGE_NAME))
			return null;
		
		//else if(StringUtils.isNull(PropUtils.getPropertiesValue("excludePackages")))
		
		resultList = new ArrayList<ScanResultInvoke>(FileValidation.clearRepeatPackage(Config.INCLUDE_PACKAGE_NAME.split(",")).length);
		
		/*else if(StringUtils.isNotNull(PropUtils.getPropertiesValue("excludePackages"))){
			
			resultList = new ArrayList<ScanResultInvoke>(FileValidation.clearRepeatPackage(PropUtils.getPropertiesValue("includePackages").split(",")).length);
		
		}*/
		//循环遍历操作
		for(String packagePath:FileValidation.clearRepeatPackage(Config.INCLUDE_PACKAGE_NAME.split(","))){
			String fullPath = ScanUtils.transferPackage2Path(packagePath);
			File file = new File(fullPath);
			List<String> fileList = ScanUtils.scanFiles(new ArrayList<String>(),file);
			this.loadResult(packagePath,fileList);
		}
		
		return this.resultList;
	}
	
	/*public List<ScanResultInvoke> scan(Properties properties) throws ScanException, IOException, ClassNotFoundException{
		
		if(properties == null)
			throw new ScanException("传入的Properties对象为空!");
		
		if(properties.getIncludePackages() == null || sconfigure.getIncludePackages().length == 0)
			return null;
		else if(sconfigure.getExcludePackages() == null || sconfigure.getExcludePackages().length == 0)
			resultList = new ArrayList<ScanResultInvoke>(FileValidation.clearRepeatPackage(sconfigure.getIncludePackages()).length);
		else if(sconfigure.getExcludePackages() != null || sconfigure.getExcludePackages().length != 0){
			
		}
		//循环遍历操作
		for(String packagePath:FileValidation.clearRepeatPackage(sconfigure.getIncludePackages())){
			String fullPath = ScanUtils.transferPackage2Path(packagePath);
			File file = new File(fullPath);
			List<String> fileList = ScanUtils.scanFiles(new ArrayList<String>(),file);
			this.loadResult(packagePath,fileList);
		}
		
		return this.resultList;
	}*/
	
	/**
	 * @Title: scan
	 * @Description: 扫描器
	 * @param sconfigure
	 * @return
	 * @throws ScanException
	 * @throws IOException
	 * @return: List<ScanResultInvoke>
	 * @throws ClassNotFoundException 
	 */
	public List<ScanResultInvoke> scan(final ScanConfigure sconfigure) throws ScanException, IOException, ClassNotFoundException{
		
		//校验
		if(sconfigure.getClazzAnnotationClasses() != null && sconfigure.getClazzAnnotationNames() != null){
			throw new ScanException("指定加载的注解类不允许全都赋值，只允许进行单方面指定");
		}
		
		if(sconfigure.getIncludePackages() == null || sconfigure.getIncludePackages().length == 0)
			return null;
		else if(sconfigure.getExcludePackages() == null || sconfigure.getExcludePackages().length == 0)
		{
			resultList = new ArrayList<ScanResultInvoke>(FileValidation.clearRepeatPackage(sconfigure.getIncludePackages()).length);
			Config.EXCLUDE_PACKAGE_NAME = null;
		}
		else if(sconfigure.getExcludePackages() != null || sconfigure.getExcludePackages().length != 0)
		{
			Config.EXCLUDE_PACKAGE_NAME = StringUtils.join(sconfigure.getExcludePackages(),",");
			//resultList = new ArrayList<ScanResultInvoke>(FileValidation.clearRepeatPackage(sconfigure.getIncludePackages()).length);
		}
		//List<String> allFileList = new ArrayList<>();
		//循环遍历操作
		for(String packagePath:FileValidation.clearRepeatPackage(sconfigure.getIncludePackages())){
			String fullPath = ScanUtils.transferPackage2Path(packagePath);
			File file = new File(fullPath);
			List<String> fileList = ScanUtils.scanFiles(new ArrayList<String>(),file);
			this.loadResult(packagePath,fileList,sconfigure);
		}
		return this.resultList;
	}
	
	/**
	 * @Title: loadClass
	 * @Description: 加载当前文件夹内的所有的文件
	 * 				  去除带有内部类
	 * @param filePath
	 * @return
	 * @return: List<String>
	 * @throws ClassNotFoundException 
	 * @throws ScanException 
	 */
	private List<ScanResultInvoke> loadResult(String packagePath,List<String> filePaths,ScanConfigure sconfigure) throws ClassNotFoundException, ScanException{
		//判断是否为空!
		if(filePaths != null && filePaths.size() != 0){
			for(String filePath:filePaths){
				StringBuilder classPackage = new StringBuilder();
				if(filePath.lastIndexOf(".")>0)
					continue;
				classPackage.append(StringUtils.replace(filePath.substring(0,filePath.lastIndexOf(".")), "\\\\", "\\."));
				String classPath = classPackage.toString().substring(classPackage.toString().indexOf(packagePath));
				Class<?> clazz = Class.forName(classPath);
				
				if(null != sconfigure.getClazzAnnotationClasses()){
					for(Class classe:sconfigure.getClazzAnnotationClasses()){
						List<Annotation> list = ScanUtils.getAnnotation(clazz,classe);
						if(list != null && list.size() != 0){
							ScanResultInvoke result = new ScanResultInvoke();
							result.setClassEntity(clazz);
							result.setFields(clazz.getDeclaredFields());
							result.setMethods(clazz.getDeclaredMethods());
							result.setAnnotation(list);
							this.resultList.add(result);
						}
					}
				}
				
				else if(null != sconfigure.getClazzAnnotationNames()){
					for(String name:sconfigure.getClazzAnnotationNames()){
						List<Annotation> list = ScanUtils.getAnnotation(clazz,Class.forName(name));
						if(list != null && list.size() != 0){
							ScanResultInvoke result = new ScanResultInvoke();
							result.setClassEntity(clazz);
							result.setFields(clazz.getDeclaredFields());
							result.setMethods(clazz.getDeclaredMethods());
							result.setAnnotation(list);
							this.resultList.add(result);
						}
					}
				}else{
					ScanResultInvoke result = new ScanResultInvoke();
					result.setClassEntity(clazz);
					result.setFields(clazz.getDeclaredFields());
					result.setMethods(clazz.getDeclaredMethods());
					this.resultList.add(result);
				}
			}
		}
		
		return this.resultList;
	}
	
	
	private List<ScanResultInvoke> loadResult(String packagePath,List<String> filePaths) throws ClassNotFoundException, ScanException{
		//判断是否为空!
		if(filePaths != null && filePaths.size() != 0){
			for(String filePath:filePaths){
				StringBuilder classPackage = new StringBuilder();
				if(filePath.lastIndexOf(".")<0)
					continue;
				classPackage.append(StringUtils.replace(filePath.substring(0,filePath.lastIndexOf(".")), "\\\\", "\\."));
				String classPath = classPackage.toString().substring(classPackage.toString().indexOf(packagePath));
				Class<?> clazz = Class.forName(classPath);
				if(StringUtils.isNotNull(Config.ANNOTATION_CLASS_NAMES)){
					for(String name:Config.ANNOTATION_CLASS_NAMES.split(",")){
						List<Annotation> list = ScanUtils.getAnnotation(clazz,Class.forName(name));
						if(list != null && list.size() != 0){
							ScanResultInvoke result = new ScanResultInvoke();
							result.setClassEntity(clazz);
							result.setFields(clazz.getDeclaredFields());
							result.setMethods(clazz.getDeclaredMethods());
							result.setAnnotation(list);
							this.resultList.add(result);
						}
					}
				}
				else
				{
					ScanResultInvoke result = new ScanResultInvoke();
					result.setClassEntity(clazz);
					result.setFields(clazz.getDeclaredFields());
					result.setMethods(clazz.getDeclaredMethods());
					this.resultList.add(result);
				}
				
			}
		}
		
		return this.resultList;
	}
	
}
