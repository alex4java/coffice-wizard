package com.hyts.web.component;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * project-name:hyts-framework
 * package-name:com.hyts.web.component
 * author:Libo/Alex
 * create-date:2017-11-21 13:47
 * copyright:libo-hyts-github
 * email:libo2dev@aliyun.com
 * description:此类主要用于:Spring服务框架上下为文服务组件：代替ApplicationContext.xml文件服务
 */
@Configuration
/*@ComponentScan(
        basePackages={"com"}
       ,excludeFilters={@ComponentScan.Filter(type= FilterType.ANNOTATION, value=EnableWebMvc.class)
})*/
public class ContextComponent {

}
