package com.hyts.web.build;

import com.hyts.fmk.base.BaseWebModel;
import com.hyts.fmk.config.ModelTypeEnum;
import com.hyts.fmk.handler.impl.DefaultWebComponentHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * project-name:hyts-framework
 * package-name:com.hyts.web.build
 * author:Libo/Alex
 * create-date:2017-11-16 14:30
 * copyright:libo-hyts-github
 * email:libo2dev@aliyun.com
 */
@Order(4)
public class ServletConfigure implements WebApplicationInitializer {

	private static final Logger logger = LoggerFactory.getLogger(ServletConfigure.class);

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
    	
    	if(DefaultWebComponentHandler.getBaseModelList() == null || DefaultWebComponentHandler.getBaseModelList().size() == 0)
    	{
    		logger.info("系统没有发现配置启动服务");
    		return ;
    	}
        DefaultWebComponentHandler.getBaseModelList().forEach((BaseWebModel param) ->{
            if(param.getModelType() == ModelTypeEnum.SERVLET)
            {
                ServletRegistration.Dynamic  dynamic = servletContext.addServlet(param.getModelName(), param.getModelClazz());
                if(param.getServletOnload() != null)
                {
                    dynamic.setLoadOnStartup(param.getServletOnload());
                }
                dynamic.addMapping(param.getMapping());
            }
        });
    }

}
