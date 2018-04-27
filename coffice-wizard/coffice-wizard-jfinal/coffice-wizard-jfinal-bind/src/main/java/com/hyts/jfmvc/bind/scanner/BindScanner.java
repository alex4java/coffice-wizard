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
package com.hyts.jfmvc.bind.scanner;

import org.apache.log4j.Logger;

import com.hyts.jfmvc.bind.BindSubjectHandler;
import com.hyts.jfmvc.bind.domain.BindDomains;
import com.hyts.jfmvc.bind.injector.DefaultClassInjector;
import com.hyts.jfmvc.boot.JfmvcBootstrap;
import com.hyts.jfmvc.core.JfmvcHandler;

/**  
 * @Title BindScanner.java  
 * @Package com.hyts.jfmvc.bind.scanner  
 * @Description TODO(用一句话描述该文件做什么)  
 * @author LiBo/Alex  
 * @date 2017年11月1日  
 * @version V1.0  
 */
public class BindScanner {

	
	private static final Logger logger = Logger.getLogger(BindScanner.class);
	
	public static void binding()
	{
		BindDomains domains = new BindDomains();
		//进行搜索所有的Service层次的注解操作
		JfmvcHandler.getGlobalInstance().getServiceList().forEach(v->{
			Class implementClass = null;
			try {
				implementClass = Class.forName(v.getTypeName());
			} catch (Exception e) {
				e.printStackTrace();
			}
			Class[] interfaceClasses = implementClass.getInterfaces();
			for(Class interfaceClass:interfaceClasses)
			{
				domains.addBindSubject(interfaceClass, implementClass);
			}
		});
		DefaultClassInjector injector = new DefaultClassInjector(domains);
		logger.info("[hyts-jfmvc-bind] --- [扫描器] --- 初始化容器进行依赖注入开始");
		injector.knit();
		logger.info("[hyts-jfmvc-bind] --- [扫描器] --- 初始化容器进行依赖注入结束");
		BindSubjectHandler.setFmkInjector(injector.getInjector());	
	}
}
