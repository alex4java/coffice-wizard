/* 
 * Copyright [2017] [Alex/LiBo(libo2dev.aliyun.com/alex.link@foxmail.com)]
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
package com.hyts.jfmvc.bind.base;

import com.google.inject.Stage;

/**  
 * @Title BaseBindConfg.java  
 * @Package com.hyts.jfmvc.bind.base  
 * @Description 基础绑定器框架-操作配置功能，供全局服务操作配置 
 * @author LiBo/Alex  
 * @date 2017年10月26日  
 * @version V1.0  
 */
public class BaseBindConfig {
	
	/**  
	 * @Fields field:field:{todo}生产级别
	 */ 
	private static final Stage PROD_LEVEL = Stage.PRODUCTION;
	
	/**  
	 * @Fields field:field:{todo}工具级别  
	 */ 
	private static final Stage TOOL_LEVEL = Stage.PRODUCTION;

	/**  
	 * @Fields field:field:{todo}开发级别：默认 
	 */ 
	private static final Stage DEV_LEVEL = Stage.PRODUCTION;
	
	/**  
	 * @Fields field:field:{todo}系统启动级别入口  
	 */ 
	public static final Stage START_BIND_LEVEL = DEV_LEVEL;

}
