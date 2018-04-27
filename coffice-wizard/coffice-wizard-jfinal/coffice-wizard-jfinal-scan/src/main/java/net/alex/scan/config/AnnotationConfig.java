/*
 * Copyright (c) 2017, Li Bo/Alex Lee All rights reserved.
 * 
 * http://www.libo4dream.club/
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
 
package net.alex.scan.config;


/**
 * @ClassName: AnnotationConfig
 * @Description: 修改注解扫描配置类 可以实现覆盖配置文件操作：springboot的思路
 * @author: LiBo/Alex Lee
 * @date: 2017年10月6日 下午4:38:56
 * @email: alexlibochn@china-pui.com.cn/alex.link@foxmail.com
 */
public class AnnotationConfig {
	
	/**
	 * @fieldName: SCANNER_EXT_NAMES
	 * @fieldType: String
	 * @Description: 扫描扩展名集合
	 */
	public static String SCANNER_EXT_NAMES ;
	
	/**
	 * @fieldName: INCLUDE_PACKAGE_NAMES
	 * @fieldType: String
	 * @Description: 包含包名称信息内容集合
	 */
	public static String INCLUDE_PACKAGE_NAMES ;

	/**
	 * @fieldName: EXCLUDE_PACKAGE_NAMES
	 * @fieldType: String
	 * @Description: 过滤包名称信息内容集合
	 */
	public static String EXCLUDE_PACKAGE_NAMES ;
	
	/**
	 * @fieldName: ANNOTATION_CLASS_NAMES
	 * @fieldType: String
	 * @Description: 获取读取类名称信息
	 */
	public static String ANNOTATION_CLASS_NAMES ;

}
