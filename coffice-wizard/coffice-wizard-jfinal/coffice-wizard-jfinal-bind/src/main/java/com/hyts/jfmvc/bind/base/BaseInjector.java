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

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.hyts.jfmvc.bind.binder.DefaultClassBinder;
import com.hyts.jfmvc.bind.domain.BindDomains;
import com.hyts.jfmvc.bind.error.GuiceBindException;

/**  
 * @Title BaseInjector.java  
 * @Package com.hyts.bind.base  
 * @Description 
 * 				<p>
 * 					系统基础操作服务，依赖注入器
 * 					用于主要操作获取绑定所有注入操作的核心对象类
 * 				</p>
 * @author LiBo/Alex  
 * @date 2017年10月25日  
 * @version V1.0  
 */
public abstract class BaseInjector {
	
	/**  
	 * @Fields field:field:依赖注入器  
	 */ 
	private static Injector injector;
	
	/**  
	 * @Fields field:field:{todo}绑定域名称集合，系统自带默认
	 */ 
	protected static BindDomains defaultBindDomains;
	
	/**  
	 * @Fields field:field:依赖注入的所有模型对象集合
	 */ 
	private static List<AbstractModule> moduleSubjectList;
	
	/**  
	 * @Fields field:field:{todo}是否启动 
	 */ 
	private static AtomicBoolean isInit = new AtomicBoolean(false);

	/**  
	 * @return moduleSubjectList  获取所有依赖注入绑定模型对象 
	 */
	public static List<AbstractModule> getModuleSubjectList() {
		return moduleSubjectList;
	}
	
	/**  
	 * @Title: init  
	 * @Description: 构建初始化所有模型依赖注入绑定对象，默认会自动加载BaseBinder的对象中的
	 * 				  依赖注入绑定关系
	 * @param @return    参数  
	 * @return boolean    返回类型  
	 * @throws  
	 */ 
	public static boolean init()
	{
		if(isInit.get())
			throw new GuiceBindException("系统状态已经启动!");
			moduleSubjectList = new LinkedList<AbstractModule>();
		//if(getModuleSubjectList() != null && getModuleSubjectList().size() != 0)
		//{	
			//注册系统默认的操作服务
			DefaultClassBinder binder = new DefaultClassBinder();
			binder.setDomains(defaultBindDomains);
			registerInjector(binder);
			injector = Guice.createInjector(BaseBindConfig.START_BIND_LEVEL,moduleSubjectList);
			isInit = new AtomicBoolean(true);
		//}
		return false;
	}
	
	/**  
	 * @Title: registerInjector  
	 * @Description: 向架构注册用户自定义的依赖注入模型(抛出异常)
	 * @param @return   返回是否成功或者失败  
	 * @return boolean    返回类型  
	 * @throws  
	 */ 
	protected static <T> boolean registerInjector(T module)
	{
		if(module != null && module instanceof AbstractModule){
			getModuleSubjectList().add((AbstractModule) module);
			return true;
		}
		else
			throw new GuiceBindException("传入的注册依赖注入模型对象为空 或者没有实现AbstractModule接口");
	}
	
	/**  
	 * @Title: registerInjector  
	 * @Description: 向架构注册用户自定义的依赖注入模型 
	 * @param @param module
	 * @param @param ingoreError
	 * @param @return    参数  
	 * @return boolean    返回类型  
	 * @throws  
	 */ 
	public static <T> boolean registerInjector(T module,boolean ingoreError)
	{
		if(module != null && module instanceof AbstractModule){
			getModuleSubjectList().add((AbstractModule) module);
			return true;
		}
		else{
			if(ingoreError)
			{
				return false;
			}
			else
			{
				throw new GuiceBindException("传入的注册依赖注入模型对象为空 或者没有实现AbstractModule接口");
			}
		}
	}
	
	/**  
	 * @Title: getInjector  
	 * @Description: 获取Injector依赖注入的控制器 
	 * @param @return    参数  
	 * @return Injector    返回类型  
	 * @throws  
	 */ 
	public  Injector getInjector()
	{
		return injector;
	}
}
