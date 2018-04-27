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

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.hyts.jfmvc.bind.domain.BindDomains;

/**  
 * @Title BaseBindere.java  
 * @Package com.hyts.bind.base  
 * @Description 
 * 				<p>
 * 					基础绑定操作类，用于绑定接口以及服务，
 * 					提供系统服务统一接口绑定操作服务，
 * 					此插件暂时只用于单机本地版，稍后会提供。
 * 					扫描分模型模块操作
 * 				</p>
 * @author LiBo/Alex  
 * @date 2017年10月25日  
 * @version V1.0  
 */
public abstract class BaseBinder extends AbstractModule{
	
	/**  
	 * @Fields field:field:{todo}构建全局所有bind底层Guice对象 
	 */ 
	protected Binder bind ;
	
	/**  
	 * @Fields field:field:{todo} 私有变量定义域
	 */ 
	private BindDomains domains;
	
	/**  
	 * @param paramtheparamthe{bare_field_name} to set  
	 */
	public void setDomains(BindDomains domains) {
		this.domains = domains;
	}

	/**  
	 * @Title: initBinder  
	 * @Description: 构建绑定方法的操作构造器  
	 * @param @param domains
	 * @param @return    参数  
	 * @return boolean    返回类型  
	 * @throws  
	 */ 
	public abstract boolean initBinder(BindDomains domains);
	
	/* (非 Javadoc)  
	 * <p>Title: configure</p>  
	 * <p>Description: </p>    
	 * @see com.google.inject.AbstractModule#configure()  
	 */  
	@Override
	protected void configure() {
		if(domains != null)
			this.initBinder(domains);
	}

	/**  
	 * @return bind  
	 */
	public Binder getBind() {
		if(bind == null)
			bind = binder();
		return bind;
	}
	
}
