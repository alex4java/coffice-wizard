package com.hyts.app;

import javax.servlet.*;
import java.io.IOException;

/**
 * project-name:hyts-framework
 * package-name:com.hyts.web.test.filter
 * author:Libo/Alex
 * create-date:2017-11-21 19:48
 * copyright:libo-hyts-github
 * email:libo2dev@aliyun.com
 * description:此类主要用于:
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("启动初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
