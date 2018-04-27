package com.hyts.web.boot.initial;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;



import com.hyts.fmk.base.InitRegister;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import java.util.ServiceLoader;

/**
 * project-name:hyts-framework
 * package-name:com.hyts.web.build
 * author:Libo/Alex
 * create-date:2017-11-21 19:41
 * copyright:libo-hyts-github
 * email:libo2dev@aliyun.com
 * description:此类主要用于:
 */
@Order(1)
public class InitBootstrap implements WebApplicationInitializer{

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //进行构建系统组件注入服务
        ServiceLoader<InitRegister> loader = ServiceLoader.load(InitRegister.class);
        if(!loader.iterator().hasNext()){
        	new DefaultInitRegister().doRegister();
        }else{
        	loader.iterator().forEachRemaining(param -> {
        		param.doRegister();
        	});
        }
    }
}
