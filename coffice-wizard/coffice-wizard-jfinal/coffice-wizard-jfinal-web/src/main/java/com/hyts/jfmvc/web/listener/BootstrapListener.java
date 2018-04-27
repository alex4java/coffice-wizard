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
package com.hyts.jfmvc.web.listener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.log4j.Logger;
import com.hyts.jfmvc.bind.BindSubjectHandler;
import com.hyts.jfmvc.bind.domain.BindDomains;
import com.hyts.jfmvc.bind.injector.DefaultClassInjector;
import com.hyts.jfmvc.bind.scanner.BindScanner;
import com.hyts.jfmvc.boot.JfmvcResourceBuilder;
import com.hyts.jfmvc.conf.JfinalAttrConf;
import com.hyts.jfmvc.core.JfmvcHandler;
import com.hyts.jfmvc.scan.handler.JfmvcScanHandler;
import com.hyts.jfmvc.scan.scanner.JfmvcScanner;
import com.jfinal.kit.PropKit;

/**  
 * @Title BootstrapListener.java  
 * @Package com.hyts.jfmvc.web.listener  
 * @Description 启动型加载器服务进行操作启动系统所有相关操作或服务
 * @author LiBo/Alex  
 * @date 2017年10月27日  
 * @version V1.0  
 */
public class BootstrapListener implements ServletContextListener{

	
	/**  
	 * @Fields field:field:{日志输出器}
	 */ 
	private static final Logger logger = Logger.getLogger(BootstrapListener.class);
	
	/* (非 Javadoc)  
	 * <p>Title: contextDestroyed</p>  
	 * <p>Description: </p>  
	 * @param arg0  
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)  
	 */  
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	/* (非 Javadoc)  
	 * <p>Title: contextInitialized</p>  
	 * <p>Description: </p>  
	 * @param arg0  
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)  
	 */  
	@Override
	public void contextInitialized(ServletContextEvent context) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("[hyts-jfmvc-web] --- [启动监听] --- 开始启动系统启动服务加载");
		logger.info("[hyts-jfmvc-web] --- [执行监听] --- 开始扫描系统所有注解，进行容器加载依赖注入服务");
		String classPath = PropKit.use(JfinalAttrConf.JFINAL_CONFIG_PROPERTIES, "UTF-8").get("jfmvc.scanner.class");
		logger.info("[hyts-jfmvc-web] --- [执行监听] --- 获取扫描启动类："+classPath);
		JfmvcScanner.scan(classPath);
		logger.info("[hyts-jfmvc-web] --- [执行监听] --- 扫描所有业务逻辑接口进行接口和实现类关系对绑定");
		BindScanner.binding();
		logger.info("[hyts-jfmvc-web] --- [关闭监听] --- 结束启动系统启动服务加载");
	}

}
