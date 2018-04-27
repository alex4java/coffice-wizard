package com.hyts.web.build;

import com.hyts.fmk.base.BaseWebModel;
import com.hyts.fmk.config.ModelTypeEnum;
import com.hyts.fmk.handler.impl.DefaultWebComponentHandler;

import org.apache.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * project-name:hyts-framework
 * package-name:com.hyts.web.build
 * author:Libo/Alex
 * create-date:2017-11-16 14:31
 * copyright:libo-hyts-github
 * email:libo2dev@aliyun.com
 * @description: 添加监听器listener注册配置
 */
@Order(2)
public class listenerConfigure implements WebApplicationInitializer {

	/**  
	 * @Fields field:field:监听操作配置类  
	 */ 
	private static final Logger logger = Logger.getLogger(listenerConfigure.class);
    
	@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
    	
    	if(DefaultWebComponentHandler.getBaseModelList() == null || DefaultWebComponentHandler.getBaseModelList().size() == 0)
    	{
    		logger.info("系统没有发现配置启动服务");
    		return ;
    	}
        DefaultWebComponentHandler.getBaseModelList().forEach((BaseWebModel param) ->{
            if(param.getModelType() == ModelTypeEnum.LISTENER)
            {
                servletContext.addListener(param.getModelClazz());
            }
        });
    }
}
