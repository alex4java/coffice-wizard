package com.hyts.app;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * project-name:hyts-framework
 * package-name:com.hyts.web.test.servlet
 * author:Libo/Alex
 * create-date:2017-11-21 19:52
 * copyright:libo-hyts-github
 * email:libo2dev@aliyun.com
 * description:此类主要用于:
 */
public class InitServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("启动服务文件Servlet");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("启动服务文件Servlet");
    }
}
