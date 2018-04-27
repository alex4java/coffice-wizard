/* 
 * Copyright [2017] [Alex/LiBo(libo2dev.aliyun.com/alex.link@foxmail.com)]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 
package com.hyts.jfmvc.conf;

/**
 * @ClassName: JfinalAttrConf
 * @Description: Jfinal框架参数操作静态默认配置类
 * @author: LiBo/Alex Lee
 * @date: 2017年9月22日 下午3:05:45
 * @email: alexlibochn@china-pui.com.cn/alex.link@foxmail.com
 */
public interface JfinalAttrConf {
	
		/**
		 * @fieldName: JFINAL_CONFIG_PROPERTIES
		 * @fieldType: String
		 * @Description: JFinal 框架 的 配置属性操作文件：默认为classPath 项目根目录下面
		 */
		public static final String JFINAL_CONFIG_PROPERTIES = "jfmvc.properties";
	
		/**
		 * @fieldName: JFINAL_CONFIG_DEVMODEL
		 * @fieldType: boolean
		 * @Description: JFinal 框架 的 配置属性操作文件:开发模式是否启用
		 */
		public static final boolean JFINAL_CONFIG_DEVMODEL = true;
		
		/**
		 * @fieldName: JFINAL_FREEMARKER_DELAY_TIME
		 * @fieldType: Integer
		 * @Description: JFinal 框架的配置属性：Freemarker模板引擎的延迟时间
		 */
		public static final Integer JFINAL_FREEMARKER_DELAY_TIME = 3600;
		
		/**
		 * @fieldName: JFINAL_DEFAULT_DOWNLOAD_PATH
		 * @fieldType: String
		 * @Description: 默认下载路径
		 */
		public static final String JFINAL_DEFAULT_DOWNLOAD_PATH = "download";
		
		/**
		 * @fieldName: JFINAL_DEFAULT_UPLOAD_PATH
		 * @fieldType: String
		 * @Description: 默认上传路径
		 */
		public static final String JFINAL_DEFAULT_UPLOAD_PATH = "upload";
		
		/**  
		 * @Fields field:field:{参数分隔符操作获取信息}  
		 */ 
		public static final String JFINAL_DEFAULT_SEP_TOKEN = "&";

		/**  
		 * @Fields field:field:{Freemarker框架的配置文件默认路径}  
		 */ 
		public static final String JFINAL_DEFAULT_FREEMARKER_PATH = "freemarker.properties";
		
		/**  
		 * @Fields field:field:{Freemarker框架的配置文件视图路径}  
		 */ 
		public static final String JFINAL_DEFAULT_FREEMARKER_VIEW_PATH = "";
		
		/**  
		 * @Fields field:field:{Freemarker框架的配置文件基础路径} 
		 */ 
		public static final String JFINAL_DEFAULT_FREEMARKER_BASE_PATH = "";

		/**  
		 * @Fields field:field:{Freemarker框架的扩展名}  
		 */ 
		public static final String JFINAL_DEFAULT_FREEMARKER_SUBFIX_NAME = ".html";

}
