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
package com.hyts.jfmvc.bind.annotation;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**  
 * @Title Service.java  
 * @Package com.hyts.bind.annotation  
 * @Description 业务逻辑接口操作扫描服务类  
 * @author LiBo/Alex  
 * @date 2017年10月25日  
 * @version V1.0  
 */
@Target({ METHOD, CONSTRUCTOR, FIELD, ElementType.TYPE})
@Retention(RUNTIME)
@Documented
@Inherited
public @interface ServiceBack {
	
	/**  
	 * @Title: serviceClass  
	 * @Description: 值操作：用于操作在此接口的类
	 * @param @return    参数  
	 * @return String    返回类型  
	 * @throws  
	 */ 
	public String interfaceClass() default "";
	/**  
	 * @Title: value  
	 * @Description: 值操作  ：用于操作在此接口的实现类
	 * @param @return    参数  
	 * @return String    返回类型  
	 * @throws  
	 */ 
	public String implementClass() default "";
	
	/**  
	 * @Title: isSingleton  
	 * @Description: 值操作  ：实现类是否为单例模式 
	 * @param @return    参数  
	 * @return boolean    返回类型  
	 * @throws  
	 */ 
	public boolean isSingleton() default true;
}
