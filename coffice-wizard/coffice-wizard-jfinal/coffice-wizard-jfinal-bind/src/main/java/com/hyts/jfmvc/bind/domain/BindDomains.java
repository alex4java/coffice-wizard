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
package com.hyts.jfmvc.bind.domain;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**  
 * @Title BindDomains.java  
 * @Package com.hyts.bind.domain  
 * @Description bind绑定对象信息集合 
 * @author LiBo/Alex  
 * @date 2017年10月25日  
 * @version V1.0  
 */
public class BindDomains {
	
	/**  
	 * @Fields field:field:{todo}绑定域对象集合信息  
	 */ 
	private List<BindDomain> bindDomains;

	/**  
	 * 创建一个新的实例-构造器 BindDomains.  
	 * @param bindDomains  
	 */ 
	public BindDomains(List<BindDomain> bindDomains) {
		super();
		this.bindDomains = bindDomains;
	}
	
	/**  
	 * 创建一个新的实例-构造器 BindDomains.    
	 */ 
	public BindDomains() {
		super();
		this.bindDomains = new LinkedList<BindDomain>();
	}

	/**  
	 * @return bindDomains  
	 */
	public List<BindDomain> getBindDomains() {
		return bindDomains;
	}
	
	/**  
	 * @Title: addBindSubject  
	 * @Description: 构建服务绑定对象快捷方法  
	 * @param @param interfaceClass
	 * @param @param implementClass
	 * @param @return
	 * @param @throws ClassNotFoundException    参数  
	 * @return boolean    返回类型  
	 * @throws  
	 */ 
	public boolean addBindSubject(String interfaceClass,String implementClass)
	{
		if(StringUtils.isNotEmpty(interfaceClass) && StringUtils.isNotEmpty(implementClass))
		{
			try {
				this.bindDomains.add(new BindDomain(Class.forName(interfaceClass),Class.forName(implementClass)));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
		return false;
	}
	
	
	public boolean addBindSubject(Class interfaceClass,Class implementClass)
	{
		if(interfaceClass != null && implementClass != null)
		{
			try {
				this.bindDomains.add(new BindDomain(interfaceClass,implementClass));
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
		return false;
	}
	
	/**  
	 * @Title: addBindSubject  
	 * @Description: 构建服务绑定对象快捷方法
	 * @param @param domain
	 * @param @return    参数  
	 * @return boolean    返回类型  
	 * @throws  
	 */ 
	public boolean addBindSubject(BindDomain domain)
	{
		if(domain != null)
		{
			this.bindDomains.add(domain);
			return true;
		}
		return false;
	}
}
