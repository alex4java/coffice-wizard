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
package com.hyts.jfmvc.bind.binder;

import java.util.Iterator;

import com.hyts.jfmvc.bind.base.BaseBinder;
import com.hyts.jfmvc.bind.domain.BindDomain;
import com.hyts.jfmvc.bind.domain.BindDomains;
import com.hyts.jfmvc.bind.handler.DefaultBindHandler;

/**  
 * @Title DefaultClassBinder.java  
 * @Package com.hyts.bind.binder  
 * @Description 默认操作级别的class类绑定操作服务类
 * @author LiBo/Alex  
 * @date 2017年10月25日  
 * @version V1.0  
 */
public class DefaultClassBinder extends BaseBinder{
	
	/**  
	 * @Fields field:field:{todo}绑定操作处理器操作组件  
	 */ 
	private DefaultBindHandler handler;
	
	/* (非 Javadoc)  
	 * <p>Title: initBinder</p>  
	 * <p>Description: </p>  
	 * @param domains
	 * @return  
	 * @see com.hyts.bind.base.BaseBinder#initBinder(com.hyts.bind.domain.BindDomains)  
	 */  
	@Override
	public boolean initBinder(BindDomains domains) {
		
		if(domains.getBindDomains() == null )
		{
			return false;
		}
		Iterator<BindDomain> iterator = domains.getBindDomains().iterator();
		//启动默认操作绑定服务
		handler = new DefaultBindHandler(this.getBind());
		while(iterator.hasNext())
		{
			BindDomain domain = iterator.next();
			handler.bindClass(domain);
		}
		return true;
	}

	
}
