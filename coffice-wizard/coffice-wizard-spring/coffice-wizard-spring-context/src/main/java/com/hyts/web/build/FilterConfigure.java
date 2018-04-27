package com.hyts.web.build;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;

import com.hyts.fmk.config.ModelTypeEnum;
import com.hyts.fmk.handler.impl.DefaultWebComponentHandler;

/**
 * project-name:hyts-framework
 * package-name:com.hyts.web.build
 * author:Libo/Alex
 * create-date:2017-11-16 14:31
 * copyright:libo-hyts-github
 * email:libo2dev@aliyun.com
 */
@Order(3)
public class FilterConfigure implements WebApplicationInitializer {

	private static final Logger logger = Logger.getLogger(FilterConfigure.class);
	
    /**
     * author:Alex/Libo
     * create-date:2017/11/16
     * create-time:15:15
     * method-name: 启动注入Filter工具实现操作类
     * param:
     * return:
     * description:
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
    	if(DefaultWebComponentHandler.getBaseModelList() == null || DefaultWebComponentHandler.getBaseModelList().size() == 0)
    	{
    		logger.info("系统没有发现配置启动服务");
    		return ;
    	}
        DefaultWebComponentHandler.getBaseModelList().forEach(param->{
            if(param.getModelType() == ModelTypeEnum.FILTER)
            {
                FilterRegistration.Dynamic dynamic = servletContext.addFilter(param.getModelName(), param.getModelClazz());
                dynamic.addMappingForUrlPatterns(null, false, param.getMapping());
                if(param.getInitParamAndValue() != null && !param.getInitParamAndValue().isEmpty())
                {
                	dynamic.setInitParameters(param.getInitParamAndValue());
                }
            }
        });
    }
}
