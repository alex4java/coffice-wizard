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
package com.hyts.jfmvc.bind.handler;

import com.google.inject.Binder;
import com.google.inject.Scopes;
import com.hyts.jfmvc.bind.base.BaseGuiceHandler;
import com.hyts.jfmvc.bind.domain.BindDomain;
import com.hyts.jfmvc.bind.error.GuiceBindException;

/**  
 * @Title DefaultBindHandler.java  
 * @Package com.hyts.bind.handler  
 * @Description 默认绑定句柄操作处理控制器依赖注入类组件  
 * @author LiBo/Alex  
 * @date 2017年10月25日  
 * @version V1.0  
 */
public class DefaultBindHandler extends BaseGuiceHandler<BindDomain>{

	/**  
	 * @Fields field:field:{todo}绑定操作服务 
	 */ 
	private Binder bind;
	
	/* (非 Javadoc)  
	 * <p>Title: bindClass</p>  
	 * <p>Description: </p>  
	 * @param domain  
	 * @see com.hyts.bind.base.BaseGuiceHandler#bindClass(java.lang.Object)  
	 */  
	@SuppressWarnings("unchecked")
	@Override
	public void bindClass(BindDomain domain) {
		if(domain == null)
			throw new GuiceBindException("绑定的对象参数domain为空!");
		bind.bind(domain.getInterfaceClass()).to(domain.getInterfaceImplClass()).in(domain.isSingleton()?Scopes.SINGLETON:Scopes.NO_SCOPE);
	}

	/* (非 Javadoc)  
	 * <p>Title: bindProvider</p>  
	 * <p>Description: </p>  
	 * @param domain  
	 * @see com.hyts.bind.base.BaseGuiceHandler#bindProvider(java.lang.Object)  
	 */  
	@Override
	public void bindProvider(BindDomain domain) {
		
	}

	/**  
	 * 创建一个新的实例-构造器 DefaultBindHandler.  
	 * @param bind  
	 */ 
	public DefaultBindHandler(Binder bind) {
		this.bind = bind;
	}

}
