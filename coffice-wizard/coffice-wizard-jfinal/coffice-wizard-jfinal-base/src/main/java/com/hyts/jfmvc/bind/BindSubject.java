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


import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Scopes;

/**  
 * @Title BindSubjectHandler.java  
 * @Package com.hyts.jfmvc.bind  
 * @Description Guice绑定所有信息的处理器，归Guice容器管理的对象，
 * 				一般用于系统全局使用的操作服务 
 * @author LiBo/Alex  
 * @date 2017年10月27日  
 * @version V1.0  
 */
public final class BindSubject extends AbstractModule{
	
	/**  
	 * @Fields field:field:{todo}操作系统拦截器归Guice容器管理对象  
	 */ 
	protected static BindControllerInterceptor controllerInterceptor;
	
	/**  
	 * @Fields field:field:{todo}操作系统拦截器归Guice容器管理对象  
	 */ 
	protected static BindServiceInterceptor serviceIntercepor;
	

	/* (非 Javadoc)  
	 * <p>Title: configure</p>  
	 * <p>Description: 绑定配置全局固定默认的拦截器</p>    
	 * @see com.google.inject.AbstractModule#configure()  
	 */  
	@Override
	protected void configure() {
		Binder binder = binder();
        binder.bind(BindControllerInterceptor.class).in(Scopes.SINGLETON);
        binder.bind(BindServiceInterceptor.class).in(Scopes.SINGLETON);
	}


	/**  
	 * @return controllerInterceptor  
	 */
	public static BindControllerInterceptor getControllerInterceptor() {
		return controllerInterceptor;
	}


	/**  
	 * @return serviceIntercepor  
	 */
	public static BindServiceInterceptor getServiceIntercepor() {
		return serviceIntercepor;
	}
	
}
