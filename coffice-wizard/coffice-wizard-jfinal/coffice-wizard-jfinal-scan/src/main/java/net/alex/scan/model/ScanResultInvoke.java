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
 
package net.alex.scan.model;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.alex.scan.config.Config;
import net.alex.scan.tool.ScanUtils;
import net.alex.scan.tool.StringUtils;

/**
 * @ClassName: ScanResultset
 * @Description: 扫描结果集合+扫描对应数据统计
 * @author: 李博/Alex
 * @date: 2017-2-27 下午6:05:36
 * @email:  alexlibochn@china-pui.com.cn
 */
public final class ScanResultInvoke implements Serializable{

	String[] methodArray = {"toString","hashCode","annotationType","equals"};

	/**
	 * @fieldName: methods
	 * @fieldType: Method[]
	 * @Description: 方法集合
	 */
	private Method[] methods;
	
	/**
	 * @fieldName: fields
	 * @fieldType: Field[]
	 * @Description: 字段值集合
	 */
	private Field[] fields;

	/**
	 * @fieldName: classSet
	 * @fieldType: List<Class<?>>
	 * @Description: 类集合
	 */
	private Class<?> classEntity;
	
	/**
	 * @fieldName: annotation
	 * @fieldType: List<Annotation>
	 * @Description: 获取注解集合
	 */
	private List<Annotation> annotation;
	

	public Method[] getMethods() {
		return methods;
	}

	public void setMethods(Method[] methods) {
		this.methods = methods;
	}

	public Field[] getFields() {
		return fields;
	}

	public void setFields(Field[] fields) {
		this.fields = fields;
	}

	public Class<?> getClassEntity() {
		return classEntity;
	}

	public void setClassEntity(Class<?> classEntity) {
		this.classEntity = classEntity;
	}

	@Override
	public String toString() {
		return "ScanResultInvoke [methods=" + Arrays.toString(methods)
				+ ", fields=" + Arrays.toString(fields) + ", classEntity="
				+ classEntity + "]";
	}
	
	/**
	 * @Title: getAnnotationData
	 * @Description: 获取注解数据信息
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @return: Map<String,Object>
	 * @throws InvocationTargetException 
	 */
	public Map<String,Object> getAnnotationData() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		//
		if(annotation == null || annotation.size() == 0)
		{
			return null;
		}
		Map<String,Object> annotationData = new HashMap<String,Object>(annotation.size());
		
		for(Annotation anno:annotation){
			Method[] methods = anno.annotationType().getMethods();
			for(Method method2:methods)
			{
				if(!method2.isAccessible())
				{
					method2.setAccessible(true);
				}
				if(!ScanUtils.isContains(methodArray, method2.getName()))
				{
					annotationData.put(method2.getName(),method2.invoke(anno, null));
				}
			}
		}
		return annotationData;
	}

	public List<Annotation> getAnnotation() {
		return annotation;
	}

	public void setAnnotation(List<Annotation> annotation) {
		this.annotation = annotation;
	}
	
	
}
