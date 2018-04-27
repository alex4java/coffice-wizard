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

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**  
 * @Title BindDomain.java  
 * @Package com.hyts.bind.domain  
 * @Description 绑定依赖注入基础操作特定域对象，进行绑定的操作基础  
 * @author LiBo/Alex  
 * @date 2017年10月25日  
 * @version V1.0  
 */

public final class BindDomain {

	/**  
	 * @Fields field:field:{todo}接口类 
	 */ 
	private Class interfaceClass;
	
	/**  
	 * @Fields field:field:{todo}接口实现类  
	 */ 
	private Class interfaceImplClass;
	
	/**  
	 * @Fields field:field:{todo}是否单利模式
	 */ 
	private boolean isSingleton;

	/**  
	 * 创建一个新的实例-构造器 BindDomain.    
	 */ 
	public BindDomain() {
		super();
	}

	/**  
	 * 创建一个新的实例-构造器 BindDomain.  
	 * @param interfaceClass
	 * @param interfaceImplClass  
	 */ 
	public BindDomain(Class interfaceClass, Class interfaceImplClass) {
		super();
		this.interfaceClass = interfaceClass;
		this.interfaceImplClass = interfaceImplClass;
		this.isSingleton = false;
	}
	
	/**  
	 * 创建一个新的实例-构造器 BindDomain.  
	 * @param interfaceClass
	 * @param interfaceImplClass
	 * @param isSingleton  
	 */ 
	public BindDomain(Class interfaceClass, Class interfaceImplClass,
			boolean isSingleton) {
		super();
		this.interfaceClass = interfaceClass;
		this.interfaceImplClass = interfaceImplClass;
		this.isSingleton = isSingleton;
	}

	/**  
	 * @return interfaceClass  
	 */
	public Class getInterfaceClass() {
		return interfaceClass;
	}

	/**  
	 * @param paramtheparamthe{bare_field_name} to set  
	 */
	public void setInterfaceClass(Class interfaceClass) {
		this.interfaceClass = interfaceClass;
	}

	/**  
	 * @return interfaceImplClass  
	 */
	public Class getInterfaceImplClass() {
		return interfaceImplClass;
	}

	/**  
	 * @param paramtheparamthe{bare_field_name} to set  
	 */
	public void setInterfaceImplClass(Class interfaceImplClass) {
		this.interfaceImplClass = interfaceImplClass;
	}

	/**  
	 * @return isSingleton  
	 */
	public boolean isSingleton() {
		return isSingleton;
	}

	/**  
	 * @param paramtheparamthe{bare_field_name} to set  
	 */
	public void setSingleton(boolean isSingleton) {
		this.isSingleton = isSingleton;
	}
}
