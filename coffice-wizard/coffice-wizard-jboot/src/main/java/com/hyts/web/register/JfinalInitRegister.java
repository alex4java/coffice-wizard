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
package com.hyts.web.register;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.hyts.fmk.base.InitRegister;
import com.hyts.fmk.handler.impl.DefaultWebComponentHandler;
import com.hyts.jfmvc.web.listener.BootstrapListener;
import com.jfinal.core.JFinalFilter;


/**  
 * @Title JfinalInitRegister.java  
 * @Package com.hyts.web.register  
 * @Description Jfinal框架兼容的注册器服务 
 * @author LiBo/Alex  
 * @date 2017年11月27日  
 * @version V1.0  
 */
public class JfinalInitRegister implements InitRegister {

	final Logger logger = Logger.getLogger(JfinalInitRegister.class);

	/* (非 Javadoc)  
	 * <p>Title: doRegister</p>  
	 * <p>Description: </p>    
	 * @see com.hyts.fmk.base.InitRegister#doRegister()  
	 */  
	@Override
	public void doRegister() {
		logger.info("启动服务注册方式-Jfinal环境");
		DefaultWebComponentHandler handler = DefaultWebComponentHandler.getInstance();
        Map<String,String> paramMap = new HashMap<String,String>();
        paramMap.put("configClass","com.hyts.jfmvc.boot.JfmvcBootstrap");
        handler.registerFilter("jfmvc", JFinalFilter.class,"/*",paramMap);
        handler.registerListener(BootstrapListener.class);
	}

}
