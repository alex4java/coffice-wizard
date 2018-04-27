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
 
package net.alex.scan.config;

import net.alex.scan.tool.PropUtils;
import net.alex.scan.tool.StringUtils;

/**
 * @ClassName: Config
 * @Description: 基础静态配置参数
 * @author: 李博/Alex
 * @date: 2017-2-28 下午4:53:51
 * @email:  alexlibochn@china-pui.com.cn
 */
public final class Config {

	public static String DEFAULT_SCANNER_PATH = "scan.properties";
	
	public static String SCANNER_EXT_NAME = StringUtils.defaultValue(AnnotationConfig.SCANNER_EXT_NAMES,PropUtils.getPropertiesValue("extName"));
	
	public static String INCLUDE_PACKAGE_NAME = StringUtils.defaultValue(AnnotationConfig.INCLUDE_PACKAGE_NAMES,StringUtils.isNull(PropUtils.getPropertiesValue("includePackages"))?null:PropUtils.getPropertiesValue("includePackages"));

	public static String EXCLUDE_PACKAGE_NAME = StringUtils.defaultValue(AnnotationConfig.EXCLUDE_PACKAGE_NAMES,StringUtils.isNull(PropUtils.getPropertiesValue("excludePackages"))?null:PropUtils.getPropertiesValue("excludePackages"));
	
	public static final Integer SYSTEM_DEFAULT_MAX_PACKAGE_LEVEL = 5;
	
	public static String ANNOTATION_CLASS_NAMES = StringUtils.defaultValue(AnnotationConfig.ANNOTATION_CLASS_NAMES, StringUtils.isNull(PropUtils.getPropertiesValue("classAnnotationNames"))?null:PropUtils.getPropertiesValue("classAnnotationNames"));
	
}
