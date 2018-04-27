package com.hyts.web.boot.spring;
import com.hyts.fmk.base.JdbcComponent;
/*import com.hyts.swagger.component.ContactBuilder;
import com.hyts.swagger.component.SwaggerConfigure;*/
import com.hyts.web.component.ContextComponent;
import com.hyts.web.component.MvcComponent;
import com.hyts.web.spring.SpringConfigure;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * project-name:hyts-framework
 * package-name:com.hyts.web.config
 * author:Libo/Alex
 * create-date:2017-11-16 14:26
 * copyright:libo-hyts-github
 * email:libo2dev@aliyun.com
 * description : 此类主要用于:加载Spring相关框架的容器服务：基础：包含着mvc等插件全局上下文
 */
public class SpringContainerIntializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * author:Alex/Libo
     * create-date:2017/11/16
     * create-time:14:37
     * method-name: getRootConfigClasses：获取RootConfig配置操作类：contextLoaderListener
     * param: 无参数
     * return: Class<?>[]
     * description: 获取RootConfig配置操作类：注入到ServletContext上下文中
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]
        		{
        				ContextComponent.class, 
        				SpringConfigure.class,
        				//ContactBuilder.class,
        				//SwaggerConfigure.class,
        				JdbcComponent.class
        		};
    }

    /**
     * author:Alex/Libo
     * create-date:2017/11/16
     * create-time:14:37
     * method-name: getServletConfigClasses：获取ServletConfig配置操作类：contextLoaderListener
     * param:无参数
     * return: Class<?>[]
     * description:获取ServletConfig配置操作类：注入到ServletContext上下文中
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("执行MVC模块转发功能");
        return new Class[]{MvcComponent.class};
    }

    /**
     * author:Alex/Libo
     * create-date:2017/11/16
     * create-time:14:37
     * method-name:getServletMappings:设置Servlet-Dispatcher服务的跟服务路径映射
     * param:无
     * return: 字符串数组
     * description: 设置映射关系：开发生成几乎不变
     */
    @Override
    protected String[] getServletMappings() {
        //请求路径映射，根路径
        return new String[]{ "/" };
    }
}
