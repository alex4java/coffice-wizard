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
package com.hyts.jfmvc.bind;

import java.lang.reflect.Field;






import java.util.List;

import org.apache.log4j.Logger;

import com.hyts.jfmvc.boot.JfmvcResourceBuilder;
import com.hyts.jfmvc.core.JfmvcHandler;
import com.jfinal.aop.Duang;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

/**  
 * @Title BindWebIntercepor.java  
 * @Package com.hyts.jfmvc.bind  
 * @Description 用于拦截和绑定系统所有相关Controller层次级别的绑定方法
 * 				用于依赖注入  
 * @author LiBo/Alex  
 * @date 2017年10月27日  
 * @version V1.0  
 */
public class BindControllerInterceptor implements Interceptor {

	/**  
	 * @Fields field:field:{日志输出器} 
	 */ 
	private static final Logger LOG = Logger.getLogger(BindControllerInterceptor.class);
	
	/* (非 Javadoc)  
	 * <p>Title: intercept</p>  
	 * <p>Description: </p>  
	 * @param inv  
	 * @see com.jfinal.aop.Interceptor#intercept(com.jfinal.aop.Invocation)  
	 */
	@Override
	public void intercept(Invocation inv) {
		Controller controller = inv.getController();
		try {
			List<Field> tempList = JfmvcResourceBuilder.getMapperList(controller.getClass().getName());
			//遍历所有集合中所有元素信息
			tempList.forEach(param->{
				boolean flag = param.isAccessible();
				if(!flag)
				{
					param.setAccessible(true);
				}
				//进行实例化对于的实例-通过反射
			    Object value = BindSubjectHandler.getFmkInjector().getInstance(param.getType());
				LOG.info("[hyts-jfmvc-base] --- [Controller-控制器-拦截器] --- 构建执行Controller映射：进行反射依赖注入：controller类："+controller.getClass().getName()+"---->"+value);
				//构建AOP-下一层级-Duang对象操控服务容器
				value = Duang.duang(value.getClass(), BindServiceInterceptor.class);
				LOG.info("[hyts-jfmvc-base] --- [Controller-控制器-拦截器] --- 构建执行Service依赖注入前提："+value.getClass()+"  --->  注入依赖关系条件.");
				try {
					param.set(controller,value);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		} catch (Exception e) {
			LOG.error("[hyts-jfmvc-base] --- [Controller-控制器-拦截器] --- BindControllerInterceptor：拦截器->调用构建依赖注入出现错误"+e.getMessage(),e);
		} 
		inv.invoke();
	}

}
