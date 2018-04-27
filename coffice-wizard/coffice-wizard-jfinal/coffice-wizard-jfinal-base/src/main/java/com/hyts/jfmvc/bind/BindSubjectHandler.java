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

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Scopes;
import com.hyts.jfmvc.conf.GuiceAttrConf;

/**  
 * @Title BindSubjectHandler.java  
 * @Package com.hyts.jfmvc.bind  
 * @Description 绑定对象操作句柄服务处理器  
 * @author LiBo/Alex  
 * @date 2017年10月27日  
 * @version V1.0  
 */
public final class BindSubjectHandler{

	/**  
	 * @Fields field:field:{系统综合全局对象绑定对象}  
	 */ 
	private static BindSubject subject;
	
	/**  
	 * @Fields field:field:{Guice框架依赖注入方法的实现操作} 
	 */ 
	private static Injector injector;
	
	/**  
	 * @Fields field:field:{框架级别注解器}  
	 */ 
	private static Injector fmkInjector;

	/**  
	 * @Title: buildBindSubject  
	 * @Description: 构建绑定对象
	 * @param     参数  ：无
	 * @return void    返回类型 ：空  
	 * @throws  
	 */ 
	private static void buildBindSubject()
	{
		if(subject == null)
		{
			subject = new BindSubject();
		}
		injector = Guice.createInjector(GuiceAttrConf.DEFAULT_GUICE_BIND_SUBJECT_STAGE,subject);
	}
	
	/**  
	 * @Title: initBindSubject  
	 * @Description: 初始化  
	 * @param @param binder    参数：Binder对象（Guice框架自带）  
	 * @return void    返回类型  
	 * @throws  
	 */ 
	public static void initBindSubject()
	{
		//提前构建BindSubject核心对象
		buildBindSubject();
		BindSubject.controllerInterceptor =  injector.getInstance(BindControllerInterceptor.class);
		BindSubject.serviceIntercepor =  injector.getInstance(BindServiceInterceptor.class);
		//利用Guice生命周期创建拦截器对象
	}

	/**  
	 * @return injector  
	 */
	protected static Injector getInjector() {
		return injector;
	}

	/**  
	 * @return fmkInjector  
	 */
	public static Injector getFmkInjector() {
		return fmkInjector;
	}

	/**  
	 * @param paramtheparamthe{bare_field_name} to set  
	 */
	public static void setFmkInjector(Injector fmkInjector) {
		BindSubjectHandler.fmkInjector = fmkInjector;
	}
	
}
