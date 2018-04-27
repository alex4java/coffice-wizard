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
package com.hyts.swagger.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import io.swagger.models.Contact;

/**  
 * @Title ContactBuilder.java  
 * @Package com.hyts.swagger.component  
 * @Description TODO(用一句话描述该文件做什么)  
 * @author LiBo/Alex  
 * @date 2017年11月27日  
 * @version V1.0  
 */
@Configuration
public class ContactBuilder {
	
	/**  
	 * @Fields field:field:默认值  
	 */ 
	private static final String DEFAULT_ENV_VALUE = "unknown";
	/**  
	 * @Fields field:field:环境变量 
	 */ 
	@Autowired
	private Environment env;
	
	
	/**  
	 * @Title: build  
	 * @Description: 构建联系方式  
	 * @param @return  参数  
	 * @return Contact    返回类型  
	 * @throws  
	 */ 
	@Deprecated
	public Contact buildSubject()
	{	
		Contact contact = new Contact();
		contact.setName(env.getProperty("contact.name", DEFAULT_ENV_VALUE));
		contact.setEmail(env.getProperty("contact.email", DEFAULT_ENV_VALUE));
		contact.setUrl(env.getProperty("contact.url", DEFAULT_ENV_VALUE));
		return contact;
	}
	
	/**  
	 * @Title: buildStr  
	 * @Description: 构建联系方式 
	 * @param @return  参数  
	 * @return String    返回类型  
	 * @throws  
	 */ 
	public String buildStr()
	{	
		StringBuilder sb = new StringBuilder("");
		sb.append("联系人:");
		sb.append(env.getProperty("contact.user", DEFAULT_ENV_VALUE)).append("<br>");
		sb.append("电子邮箱：");
		sb.append(env.getProperty("contact.email", DEFAULT_ENV_VALUE)).append("<br>");
		sb.append("访问主页：");
		sb.append(env.getProperty("contact.url", DEFAULT_ENV_VALUE)).append("<br>");
		sb.append("");
		return sb.toString();
	}
}
