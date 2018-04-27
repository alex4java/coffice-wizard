package com.hyts.web.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.IOException;

/**
 * project-name:hyts-framework
 * package-name:com.hyts.web.component
 * author:Libo/Alex
 * create-date:2017-11-21 13:32
 * copyright:libo-hyts-github
 * email:libo2dev@aliyun.com
 * description:此类主要用于:用于代替ServletMVC-spring.xml的MVC架构基础配置文件
 */

@Configuration
@EnableWebMvc
@ComponentScan("com")
public class MvcComponent extends WebMvcConfigurerAdapter {

    //视图触发管理
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    //文件上传服务组件
    @Bean(name="multipartResolver")
    protected CommonsMultipartResolver MultipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        try {
            multipartResolver.setUploadTempDir(new FileSystemResource("/tmp"));//可不设置
        } catch (IOException e) {
            e.printStackTrace();
        }
        multipartResolver.setMaxUploadSize(2097152);//2M
        multipartResolver.setMaxInMemorySize(0);
        multipartResolver.setDefaultEncoding("UTF-8");
        return multipartResolver;
    }

    //静态资源的处理
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}
