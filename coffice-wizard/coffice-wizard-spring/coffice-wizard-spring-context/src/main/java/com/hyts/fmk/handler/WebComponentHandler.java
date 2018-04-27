package com.hyts.fmk.handler;

import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.http.HttpServlet;

/**
 * project-name:hyts-framework
 * package-name:com.hyts.fmk.handler
 * author:Libo/Alex
 * create-date:2017-11-21 14:16
 * copyright:libo-hyts-github
 * email:libo2dev@aliyun.com
 * description:此类主要用于:WebComponentHandler服务组件类，主要用于处理
 *             组件：Servlet以及Filter、linstener组件。
 */
public abstract class WebComponentHandler {

    /**
     * author:Alex/Libo
     * create-date:2017/11/21
     * create-time:14:19
     * method-name:registerServlet
     * param:servletName：servlet名称-servletName,servletclass类名称全称-servletClassPath,映射路径结构-mapping,onStart-启动顺序
     * return:
     * description: 注册web组件-servlet容器映射组件
     */
    //public abstract void registerServlet(String servletName,String servletClassPath,String mapping,Integer onStart);

    /**
     * author:Alex/Libo
     * create-date:2017/11/21
     * create-time:14:22
     * method-name:registerServlet
     * param: servlet名称-servletName,servletclass-servletClassPath,映射路径结构-mapping
     * return:
     * description: 注册web组件-servlet组件
     */
    public abstract void registerServlet(String servletName, Class<? extends HttpServlet> servletClass, String mapping,Integer onStart);


    /**
     * author:Alex/Libo
     * create-date:2017/11/21
     * create-time:14:19
     * method-name:registerFilter
     * param: filter名称-filterName,filterClass-filter过滤器类,映射路径结构-mapping
     * return:
     * description:注册web组件-Filter组件
     */
    public abstract void registerFilter(String filterName, Class<? extends Filter> filterClass, String mapping,Map<String,String> initInfo);

    /**
     * author:Alex/Libo
     * create-date:2017/11/21
     * create-time:14:19
     * method-name:registerListener
     * param:listener监听器类全局操作类
     * return:
     * description:注册web组件-listener组件
     */
    public abstract <T>void registerListener(Class<T> listener);

}

