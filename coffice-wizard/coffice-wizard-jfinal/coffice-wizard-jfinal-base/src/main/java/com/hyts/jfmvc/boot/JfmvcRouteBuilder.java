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
package com.hyts.jfmvc.boot;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.hyts.jfmvc.core.JfmvcHandler;
import com.hyts.jfmvc.core.JfmvcRoute;
import com.jfinal.config.Routes;

/**  
 * @Title JfmvcRouteBuilder.java  
 * @Package com.hyts.jfmvc.boot  
 * @Description MVC架构映射操作服务构建器
 * @author LiBo/Alex  
 * @date 2017年10月31日  
 * @version V1.0  
 */
final class JfmvcRouteBuilder {
	
	 /**  
	  * @Fields field:field:{日志输出器}  
	  */ 
	 private static Logger logger = Logger.getLogger(JfmvcRouteBuilder.class);
	
	 /**  
	 * @Title: deal  
	 * @Description: 处理方法  
	 * @param @param routes    参数  ：JFINAL框架路由集合
	 * @return void    返回类型   不返回任何参数
	 * @throws  
	 */ 
	public static void deal(Routes routes)
	 {
		JfmvcHandler.getGlobalInstance().getJfmvcRoutes().forEach(e-> 
		{
			if(StringUtils.isBlank(e.getChildPath()))
			{
				String path = deal4Path(e.getModulePath());
				routes.add(path, e.getModelClassPath());
				logger.info("[hyts-jfmvc-base] --- [路由构建] --- 构建执行Controller映射："+path+" -----> "+e.getModelClassPath());
			}
			else
			{
				String path1 = deal4Path(e.getModulePath());
				String path2 = deal4Path(e.getChildPath());
				routes.add(path1, e.getModelClassPath(),path2);
				logger.info("[hyts-jfmvc-base] --- [路由构建] --- 构建执行Controller映射："+path1+path2+" -----> "+e.getModelClassPath());
			}
		}
		);
	 }
	
	 /**  
	 * @Title: deal4Path  
	 * @Description: 校验容错配置的路径问题 
	 * @param @param path
	 * @param @return    参数  
	 * @return String    返回类型  
	 * @throws  
	 */ 
	private static String deal4Path(String path)
	 {
		return path.startsWith("/")?path:"/"+path;
	 }
	 
}
