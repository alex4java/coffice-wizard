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

/**  
 * @Title BaseGuiceHandler.java  
 * @Package com.hyts.bind.base  
 * @Description 基础依赖注入操作Guice句柄服务处理器 
 * @author LiBo/Alex  
 * @date 2017年10月25日  
 * @version V1.0  
 */
public abstract class BaseGuiceHandler<T> {

	 /**  
	 * @Title: bindClass  
	 * @Description: 普通绑定：接口-接口实现类操作服务  
	 * @param @param domain    参数  
	 * @return void    返回类型  
	 * @throws  
	 */ 
	public abstract void bindClass(T domain);
	
	/**  
	 * @Title: bindProvider  
	 * @Description: 普通绑定：接口-接口实现类操作服务(获取Provider对象的引用对象)  
	 * @param @param domain    参数  
	 * @return void    返回类型  
	 * @throws  
	 */ 
	public abstract void bindProvider(T domain);
	
}
