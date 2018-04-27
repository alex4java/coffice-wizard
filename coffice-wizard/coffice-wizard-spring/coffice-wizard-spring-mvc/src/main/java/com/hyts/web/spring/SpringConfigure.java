package com.hyts.web.spring;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * project-name:hyts-framework
 * package-name:com.hyts.web.spring
 * author:Libo/Alex
 * create-date:2017-11-16 15:26
 * copyright:libo-hyts-github
 * email:libo2dev@aliyun.com
 * description:此类主要用于:Spring容器组件服务
 */
@Order(5)
public class SpringConfigure implements WebApplicationInitializer {


    /**
     * author:Alex/Libo
     * create-date:2017/11/16
     * create-time:16:10
     * method-name: 启动服务方法操作
     * param:
     * return:
     * description:
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        //启动Spring框架服务基础各部分组件
        //启动基础组件使用Filter
        servletContext.addFilter("characterEncodingFilter", CharacterEncodingFilter.class);

        //启动基础组件使用Servlet（不包含DispatcherServlet）

        //启动基础组件使用Listener（不包含ContextLoaderListener）

    }
}
