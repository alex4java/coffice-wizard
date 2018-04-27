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
 
package net.alex.scan.adapter;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Objects;
import java.util.Optional;

import com.hyts.jfmvc.scan.annotation.AutoScanComponent;

import net.alex.scan.annotation.ExcludePackages;
import net.alex.scan.annotation.FilterExtNames;
import net.alex.scan.annotation.IncludeAnnotations;
import net.alex.scan.annotation.IncludePackages;
import net.alex.scan.config.AnnotationConfig;
import net.alex.scan.config.Config;
import net.alex.scan.error.ScanException;
import net.alex.scan.tool.PathUtils;
import net.alex.scan.tool.ScanUtils;
import net.alex.scan.tool.StringUtils;

/**
 * @ClassName: ScanAdapter
 * @Description: 文件扫描适配器
 * 				  用于扫描适配所有相关注册的适配注解类
 * 				  用于管理注册后的不同需求的注解类
 * 				 适配外部进行修改内部操作的方法
 * @author: 李博/Alex
 * @date: 2017-2-28 上午9:29:56
 * @email:  alexlibochn@china-pui.com.cn
 */
public class ScanAdapter {
	
	/**
	 * @fieldName: methodArray
	 * @fieldType: String[]
	 * @Description: TODO
	 */
	private	static final String[] methodArray = {"toString","hashCode","annotationType","equals"};
 
	
	/**
	 * @Title: setScanPropertiesPath
	 * @Description: 设置系统总体加载文件Properties文件路径
	 * @param classPath
	 * @return
	 * @return: boolean
	 * @throws ScanException 
	 */
	public static void setScanPropertiesPath(String classPath) throws ScanException{
		//判断是否空或者文件不存在
		if(StringUtils.isNotNull(classPath) && 
				new File(PathUtils.getClassRunnerPath(classPath)).exists()){
			Config.DEFAULT_SCANNER_PATH = classPath;
		}
		else{
			//System.err.println("手动外界设置Scanner配置文件失败!进行原始默认设置classpath根目录下的scan.properties文件!");
			throw new ScanException("加载Scanner配置文件失败!请检查文件是否存在!");
			//return false;
		}
	}
	
	/**
	 * @Title: runWithAnnotation
	 * @Description: 操作服务，运行操作注解:class类型注解服务<br>
	 * 				   获取注解操作，annotation服务注解类<br>
	 * 				   注解类的优先级告诉配置文件服务操作<br>
	 * @param clazz
	 * @return
	 * @return: boolean
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws ScanException 
	 */
	public static boolean runWithAnnotation(Class clazz) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		//clazz服务不可为空
		if(clazz != null)
		{
			//校验所有相关服务启动
			IncludePackages includePackages = (IncludePackages) clazz.getAnnotation(IncludePackages.class);
			System.out.println(includePackages.packagePaths()[0]);
			String defaultClassScannerPackage = clazz.getPackage().getName();
			if(includePackages == null) {
				AnnotationConfig.INCLUDE_PACKAGE_NAMES = defaultClassScannerPackage;
			}else {
				if(includePackages.annotationType().getDeclaredMethods() != null
					||	includePackages.annotationType().getDeclaredMethods().length != 0){
					
					Method[] methods = includePackages.annotationType().getMethods();
					for(Method method2:methods)
					{
						if(!method2.isAccessible())
						{
							method2.setAccessible(true);
						}
						if(!ScanUtils.isContains(methodArray, method2.getName()))
						{
							Object obj = method2.invoke(includePackages, null);
							if(obj instanceof String[])
							{
								if(obj != null)
								{
									String[] objArray = (String[])obj;
									try {
										AnnotationConfig.INCLUDE_PACKAGE_NAMES = StringUtils.join(objArray, ",");
									} catch (ScanException e) {
										e.printStackTrace();
									}
								}
							}
							else if(obj instanceof String)
							{
								if(obj != null)
								{
									String objArray = obj.toString();
									AnnotationConfig.INCLUDE_PACKAGE_NAMES = objArray;
								}
							}
						}
					}
				}
			}
			/**
			 * @author libo
			 * @date 2018-04-15
			 * @description 修改注解扫描兼容AutoScanAnnotation注解
			 */
			Annotation includeAnnotation = Objects.isNull(clazz.getAnnotation(IncludeAnnotations.class))?clazz.getAnnotation(AutoScanComponent.class).annotationType().getAnnotation(IncludeAnnotations.class):clazz.getAnnotation(IncludeAnnotations.class);
			if(includeAnnotation != null) {
				if(includeAnnotation.annotationType().getDeclaredMethods() != null
						||	includeAnnotation.annotationType().getDeclaredMethods().length != 0){
						Method[] methods = includeAnnotation.annotationType().getMethods();
						for(Method method2:methods)
						{
							if(!method2.isAccessible())
							{
								method2.setAccessible(true);
							}
							if(!ScanUtils.isContains(methodArray, method2.getName()))
							{
								Object obj = method2.invoke(includeAnnotation, null);
								if(obj instanceof String[])
								{
									if(obj != null)
									{
										String[] objArray = (String[])obj;
										try {
											AnnotationConfig.ANNOTATION_CLASS_NAMES = StringUtils.join(objArray, ",");
										} catch (ScanException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										
									}
								}
								else if(obj instanceof String)
								{
									if(obj != null)
									{
										String objArray = obj.toString();
										AnnotationConfig.ANNOTATION_CLASS_NAMES = objArray;
									}
								}
							}
						}
					}
			}
			Annotation excludePackages = clazz.getAnnotation(ExcludePackages.class);
			if(excludePackages != null)
			{
				if(excludePackages.annotationType().getDeclaredMethods() != null
						||	excludePackages.annotationType().getDeclaredMethods().length != 0){
						
						Method[] methods = excludePackages.annotationType().getMethods();
						for(Method method2:methods)
						{
							if(!method2.isAccessible())
							{
								method2.setAccessible(true);
							}
							if(!ScanUtils.isContains(methodArray, method2.getName()))
							{
								Object obj = method2.invoke(excludePackages, null);
								if(obj instanceof String[])
								{
									if(obj != null)
									{
										String[] objArray = (String[])obj;
										try {
											AnnotationConfig.EXCLUDE_PACKAGE_NAMES = StringUtils.join(objArray, ",");
										} catch (ScanException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										
									}
								}
								else if(obj instanceof String)
								{
									if(obj != null)
									{
										String objArray = obj.toString();
										AnnotationConfig.EXCLUDE_PACKAGE_NAMES = objArray;
									}
								}
							}
						}
					}
				//throw new NullPointerException("传入的class类:"+clazz.getName()+"必须含有注解：IncludeAnnotations才可以进行扫描");
			}
			Annotation filterExtNames = clazz.getAnnotation(FilterExtNames.class);
			if(filterExtNames != null)
			{
				if(filterExtNames.annotationType().getDeclaredMethods() != null
						||	excludePackages.annotationType().getDeclaredMethods().length != 0){
						
						Method[] methods = filterExtNames.annotationType().getMethods();
						for(Method method2:methods)
						{
							if(!method2.isAccessible())
							{
								method2.setAccessible(true);
							}
							if(!ScanUtils.isContains(methodArray, method2.getName()))
							{
								Object obj = method2.invoke(filterExtNames, null);
								if(obj instanceof String[])
								{
									if(obj != null)
									{
										String[] objArray = (String[])obj;
										try {
											AnnotationConfig.SCANNER_EXT_NAMES = StringUtils.join(objArray, ",");
										} catch (ScanException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										
									}
								}
								else if(obj instanceof String)
								{
									if(obj != null)
									{
										String objArray = obj.toString();
										AnnotationConfig.SCANNER_EXT_NAMES = objArray;
									}
								}
							}
						}
					}
			}
		}
		return true;
	}
}
