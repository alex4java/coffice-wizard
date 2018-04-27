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
package com.hyts.jfmvc.scan.handler;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;

import net.alex.scan.model.ScanResultInvoke;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.hyts.jfmvc.boot.JfmvcResourceBuilder;
import com.hyts.jfmvc.core.JfmvcHandler;
import com.hyts.jfmvc.core.JfmvcModel;
import com.hyts.jfmvc.core.JfmvcRoute;
import com.hyts.jfmvc.scan.adapter.ScannerAdapter;
import com.hyts.jfmvc.scan.annotation.Controller;
import com.hyts.jfmvc.scan.annotation.Entity;
import com.hyts.jfmvc.scan.annotation.Repository;
import com.hyts.jfmvc.scan.annotation.RequestMapping;
import com.hyts.jfmvc.scan.annotation.Resource;
import com.hyts.jfmvc.scan.annotation.Service;



/**  
 * @Title JfmvcScanHandler.java  
 * @Package com.hyts.jfmvc.scan.handler  
 * @Description Jfmvc框架扫描处理机制构建服务信息：处理器  
 * @author LiBo/Alex  
 * @date 2017年10月27日  
 * @version V1.0  
 */
public class JfmvcScanHandler {
	
		 
		 private static final Logger logger = Logger.getLogger(JfmvcScanHandler.class);
		 
		 private static JfmvcScanHandler handlerObject;
		 
		/**
		 * @throws InvocationTargetException 
		 * @throws IllegalAccessException 
		 * @throws IllegalArgumentException   
		 * @Title: handlerAnnotationByModel  
		 * @Description: 处理进行分离不同注解所在的集合，方便使用和操作-Model  
		 * @param @return    参数  
		 * @return     返回类型  
		 * @throws  
		 */ 
		public void handlerAnnotationByModel(ScanResultInvoke param) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
			 if(param != null)
			 {
				 JfmvcModel model = new JfmvcModel(StringUtils.defaultIfEmpty(String.valueOf(param.getAnnotationData().get("tableName")),param.getClassEntity().getSimpleName()),String.valueOf(param.getAnnotationData().get("primaryKey")),param.getClassEntity());
				 for(Annotation annotation:param.getAnnotation())
				 {
					 if(annotation.annotationType().isAssignableFrom(Entity.class))
					 {
						 logger.info("[hyts-jfmvc-scan] --- [扫描模型] --- 已经构建模型处理器对象映射明细:"+model);
						 JfmvcHandler.getGlobalInstance().getJfmvcModels().add(model);
					 }
				 }
			 }
			 return ;
		}
	
		/**
		 * @Title: handlerAnnotationByRoute
		 * @Description: 处理进行分离不同注解所在的集合，方便使用和操作-Route
		 * @param param
		 * @return
		 * @throws IllegalArgumentException
		 * @throws IllegalAccessException
		 * @throws InvocationTargetException
		 * @return: void
		 */
		public void handlerAnnotationByRoute(ScanResultInvoke param) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
			
			if(param != null)
			 {
				 JfmvcRoute model = new JfmvcRoute(String.valueOf(param.getAnnotationData().get("value")),(Class<? extends com.jfinal.core.Controller>) param.getClassEntity()); 
				 
				 for(Annotation annotation:param.getAnnotation())
				 {
					 if(annotation.annotationType().isAssignableFrom(Controller.class))
					 {
						 logger.info("[hyts-jfmvc-scan] --- [扫描路由] --- 已经构建请求转发处理器对象映射明细:"+model);
						 JfmvcHandler.getGlobalInstance().getJfmvcRoutes().add(model);
					 }
				 }
			 }
			 return ;
		}

		/**  
		 * @Title: handlerAnnotationByResource  
		 * @Description: 处理进行分离不同注解所在的集合，方便使用和操作-Resource  
		 * @param @param param
		 * @param @throws IllegalArgumentException
		 * @param @throws IllegalAccessException
		 * @param @throws InvocationTargetException    参数  
		 * @return void    返回类型  
		 * @throws  
		 */ 
		public void handlerAnnotationByResource(ScanResultInvoke param) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
			//利用Scanner扫描适配器的扫描功能扫描类的所有字段
			JfmvcResourceBuilder.addMapperList(param.getClassEntity().getName(),ScannerAdapter.scanField(param.getClassEntity(),Resource.class));
			logger.info("[hyts-jfmvc-scan] --- [扫描资源] --- 注入依赖关系的控制器Controller："+param.getClassEntity().getName());
		}
		
		/**  
		 * @Title: handlerAnnotationByService  
		 * @Description: 理进行分离不同注解所在的集合，方便使用和操作-Service 
		 * @param @param param
		 * @param @throws IllegalArgumentException
		 * @param @throws IllegalAccessException
		 * @param @throws InvocationTargetException    参数  
		 * @return void    返回类型  
		 * @throws  
		 */ 
		public void handlerAnnotationByService(ScanResultInvoke param) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
			
			if(param != null)
			 {
				 for(Annotation annotation:param.getAnnotation())
				 {
					 if(annotation.annotationType().isAssignableFrom(Service.class))
					 {
						 logger.info("[hyts-jfmvc-scan] --- [扫描接口DI] --- 已经构建依赖注入服务映射明细 -- 映射注入Guice对象:"+param.getClassEntity());
						 JfmvcHandler.getGlobalInstance().getServiceList().add(param.getClassEntity());
					 }
				 }
			 }
			 return ;
		}
		
		/**  
		 * @Title: handlerAnnotationByRepository  
		 * @Description: 理进行分离不同注解所在的集合，方便使用和操作-Repository   
		 * @param @param param
		 * @param @throws IllegalArgumentException
		 * @param @throws IllegalAccessException
		 * @param @throws InvocationTargetException    参数  
		 * @return void    返回类型  
		 * @throws  
		 */ 
		public void handlerAnnotationByRepository(ScanResultInvoke param) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
			
			if(param != null)
			 {
				 for(Annotation annotation:param.getAnnotation())
				 {
					 if(annotation.annotationType().isAssignableFrom(Repository.class))
					 {
						 logger.info("[hyts-jfmvc-scan] --- [扫描接口DI] --- 已经构建依赖注入服务映射明细 -- 映射注入Guice对象:"+param.getClassEntity());
						 JfmvcHandler.getGlobalInstance().getServiceList().add(param.getClassEntity());
					 }
				 }
			 }
			 return ;
		}
		
		
		/**  
		 * @Title: handlerAnnotationByRequestMapping  
		 * @Description: 执行解析RequestMapping服务对象注解映射绑定操作  
		 * @param @param param
		 * @param @throws IllegalArgumentException
		 * @param @throws IllegalAccessException
		 * @param @throws InvocationTargetException    参数  
		 * @return void    返回类型  
		 * @throws  
		 */ 
		@Deprecated
		private void handlerAnnotationByRequestMapping(ScanResultInvoke param) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
			 if(param != null)
			 {
				 JfmvcRoute model = new JfmvcRoute(String.valueOf(param.getAnnotationData().get("value")),(Class<? extends com.jfinal.core.Controller>) param.getClassEntity()); 
				 
				 for(Annotation annotation:param.getAnnotation())
				 {
					 if(annotation.annotationType().isAssignableFrom(RequestMapping.class))
					 {
						 logger.info("已经构建请求转发处理器对象映射明细:"+model);
						 JfmvcHandler.getGlobalInstance().getJfmvcRoutes().add(model);
					 }
				 }
			 }
			 return ;
		}
		
		/**  
		 * 创建一个新的实例-构造器 JfmvcScanHandler.    
		 */ 
		private JfmvcScanHandler() {
			super();
		}
		
		
		/**  
		 * @Title: getInstance  
		 * @Description: 获取单例对象 
		 * @param @return    参数  
		 * @return JfmvcScanHandler    返回类型  
		 * @throws  
		 */ 
		public static JfmvcScanHandler getInstance()
		{
			if(handlerObject == null)
			{
				handlerObject = new JfmvcScanHandler();
			}
			return handlerObject;
		}
}
