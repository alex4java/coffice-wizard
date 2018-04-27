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
 
package net.alex.scan.tool;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.alex.scan.error.ScanException;
import net.alex.scan.model.ScanResultInvoke;
import net.alex.scan.scanner.BaseFileNameFilter;

/**
 * @ClassName: ScanUtils
 * @Description: 扫描独有的支持工具类
 * @author: 李博/Alex
 * @date: 2017-2-28 下午4:03:21
 * @email:  alexlibochn@china-pui.com.cn
 */
public final class ScanUtils {

	/**
	 * @Title: transferPackage2Path
	 * @Description: 把对应的包路径转为Path实际路径操作
	 * 				  方便加载实际的class文件字节码进行运行数据
	 * @param path
	 * @return
	 * @return: String
	 * @throws ScanException 
	 */
	public static String transferPackage2Path(String packagePath) throws ScanException{
		//是否为空!
		if(StringUtils.isNull(packagePath))
			throw new ScanException("传入的包路径不允许为空!");
		String path = StringUtils.replace(packagePath, "\\.", "/");
		return PathUtils.getClassRunnerPath(path);
	}
	
	/**
	 * @Title: isExistsAnnotation
	 * @Description: 判断是否存在Annotation注解类，
	 * @param clazz
	 * @param annotationClass
	 * @return
	 * @return: boolean
	 * @throws ScanException 
	 */
	//@Deprecated
	/*public static Annotation getAnnotation(Class<?> clazz,Class<? extends Annotation> annotationClass) throws ScanException{
		
		if(clazz != null || annotationClass != null){
			if(!annotationClass.isAnnotation())
			{
				throw new ScanException("传入的扫描的注解类: "+annotationClass.getName()+" 不是真正的注解类");
			}
			else
			{
				return (Annotation) clazz.getAnnotation(annotationClass);
			}
		}
		return null;
	}*/
	
	public static List<Annotation> getAnnotation(Class<?> clazz,Class<?> annotationClass) throws ScanException{
		
		List<Annotation> annotations = null;
		if(clazz != null || annotationClass != null){
			if(!annotationClass.isAnnotation())
			{
				throw new ScanException("传入的扫描的注解类: "+annotationClass.getName()+" 不是真正的注解类");
			}
			else
			{
				annotations = new ArrayList<Annotation>();
				for(Annotation annotation:clazz.getAnnotations()){
					if(annotation.annotationType().getName().equals(annotationClass.getName()))
					{
						annotations.add(annotation);
					}
				}
			}
		}
		return annotations;
	}

	/**
	 * @Title: scanFiles
	 * @Description: 递归抽取所有文件信息路径
	 * @param resultSet
	 * @param directoryPath
	 * @return
	 * @throws IOException
	 * @return: List<String>
	 */
	public static List<String> scanFiles(List<String> resultSet 
			,File directoryPath) throws IOException{
		
		if(directoryPath ==null || resultSet == null)
		{
			return null;
		}
		//directoryPath.listFiles(filter);
		for(File file:directoryPath.listFiles(new BaseFileNameFilter())){
			
			if(file.isDirectory()){
				scanFiles(resultSet,file);
			}
			else
			{
				resultSet.add(file.getCanonicalPath());
			}
		}
		return resultSet;
	}
	
	/**
	 * @Title: isContains
	 * @Description: 是否包含
	 * @param elements
	 * @param name
	 * @return
	 * @return: boolean
	 */
	public static boolean isContains(String [] elements,String name){
		
		for(String element:elements){
			if(element.equals(name))
			{
				return true;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		/*try {
			//System.out.println(new File(transferPackage2Path("net.alex.scan.exception")).getName());
			Annotation annotation = getAnnotation(Class.forName("net.alex.scan.tool.PathUtils"),Test1.class);
			System.out.println(annotation.getClass().getDeclaredFields()[1].getName());
			try {
				System.out.println(annotation.getClass().getDeclaredMethods()[0].invoke(Class.forName(Test1.class.getName()).newInstance(),null));
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | SecurityException
					| InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ScanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		n}*/
		try {
			try {
				try {
					System.out.println(getAnnotation(Class.forName("net.alex.scan.tool.PathUtils"),Class.forName("net.alex.scan.tool.Test1")));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println(new File(transferPackage2Path("net.alex.scan")).getCanonicalPath());
				//System.out.println(scanFiles(new ArrayList<String>(),new File(transferPackage2Path("net.alex.scan"))));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//new File(transferPackage2Path(""))
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
