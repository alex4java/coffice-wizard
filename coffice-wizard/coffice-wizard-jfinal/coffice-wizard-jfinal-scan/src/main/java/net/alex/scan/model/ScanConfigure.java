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

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @ClassName: ScannerConfigure
 * @Description:只需扫描读取配置文件基础信息类<br>
 * 				该对象一个服务项目只会创建一次用于读取文件包<br>
 * 				因为内部含有一个集合用于存放所有的读取和过滤包路径<br>
 * 				但如果需要多服务去读取对应的类，则需要进行更高级别的支持<br>
 * 				等待完成2.0版本进行分布式支持作为服务支撑
 * @author: 李博/Alex
 * @date: 2017-2-27 下午5:50:48
 * @email:  alexlibochn@china-pui.com.cn
 */
public final class ScanConfigure {
	
	/**
	 * @fieldName: packages
	 * @fieldType: String[]
	 * @Description: packages包名:包含的包
	 */
	private String[] includePackages;
	
	/**
	 * @fieldName: excludePackages
	 * @fieldType: String[]
	 * @Description: packages包名：不包含的包
	 */
	private String[] excludePackages;
	
	/**
	 * @fieldName: clazzAnnotationClass
	 * @fieldType: Class<?>
	 * @Description: classAnnotationClass类名
	 */
	private List<Class<? extends Annotation>> clazzAnnotationClasses;
	
	/**
	 * @fieldName: clazzAnnotationName
	 * @fieldType: String
	 * @Description: annotationClassName名称
	 */
	private String[] clazzAnnotationNames;
	

	public List<Class<? extends Annotation>> getClazzAnnotationClasses() {
		return clazzAnnotationClasses;
	}

	public void setClazzAnnotationClasses(
			List<Class<? extends Annotation>> clazzAnnotationClasses) {
		this.clazzAnnotationClasses = clazzAnnotationClasses;
	}

	public String[] getClazzAnnotationNames() {
		return clazzAnnotationNames;
	}

	public void setClazzAnnotationNames(String[] clazzAnnotationNames) {
		this.clazzAnnotationNames = clazzAnnotationNames;
	}

	public String[] getIncludePackages() {
		return includePackages;
	}

	public void setIncludePackages(String[] includePackages) {
		this.includePackages = includePackages;
	}

	public String[] getExcludePackages() {
		return excludePackages;
	}

	public void setExcludePackages(String[] excludePackages) {
		this.excludePackages = excludePackages;
	}
	
}
