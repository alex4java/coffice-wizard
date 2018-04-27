package com.hyts.app;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * project-name:hyts-framework
 * package-name:com.hyts.web
 * author:Libo/Alex
 * create-date:2017-11-22 13:36
 * copyright:libo-hyts-github
 * email:libo2dev@aliyun.com
 * description:此类主要用于:
 */
public class LoadListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("启动监听器");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
