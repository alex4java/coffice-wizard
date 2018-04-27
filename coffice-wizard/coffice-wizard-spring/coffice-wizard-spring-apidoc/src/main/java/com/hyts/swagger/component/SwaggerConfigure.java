/* 
 * Copyright [2017] [Alex/LiBo(libo2dev.aliyun.com/alex.link@foxmail.com)]
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hyts.swagger.component;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**  
 * @Title SwaggerConfigure.java  
 * @Package com.hyts.swagger.component  
 * @Description Swagger服务配置操作类：注册配置服务  
 * @author LiBo/Alex  
 * @date 2017年11月27日  
 * @version V1.0  
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
@PropertySource("classpath:swagger.properties")
@Import(ContactBuilder.class)
public  class SwaggerConfigure extends ContactBuilder{
	
	/**  
	 * @Title: placeholderConfigurer  
	 * @Description: PropertiesSourcesPlaceholderConfigurer配置操作符-进行构建
	 * 				  配合PropertySource注解进行@Value(构建读取环境字段)  
	 * @param @return  参数  
	 * @return PropertySourcesPlaceholderConfigurer    返回类型  
	 * @throws  
	 */ 
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer()
	{
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Value("${api.title}")
	private String apiTitle;
	
	@Value("${api.description}")
	private String apiDescription;
	
	@Value("${api.termService}")
	private String apiTermService;
	
	@Value("${api.license}")
	private String apiLicense;
	
	@Value("${api.licenseUrl}")
	private String apiLicenseUrl;
	
	@Value("${api.version}")
	private String apiVersion;
	
	@Value("${api.scanPackage}")
	private String apiScanPackage;
	
	@Value("${api.isReleaseRule}")
	private boolean isReleaseRule = false;
	
	/**  
	 * @Title: createRestApi  
	 * @Description: 创建RestApi服务  
	 * @param @return  参数  
	 * @return Docket    返回类型  
	 * @throws  
	 */ 
	@Bean
	public Docket createRestApi()
	{
		/*
		     判断是否进行放开规则全局都处理，或者还是
		     针对于严格SpringMVC/SpringBoot方案进行扫描只有
		   RestController/Controller以及ResponseBody注解
		      修饰的才会进行如接口服务中
		*/
		Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
		if(isReleaseRule)
		{
			//如果没有设置路径，则全局路径都符合条件
			if(StringUtils.isEmpty(this.apiScanPackage))
			{
				return docket.select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
			}
			//否则进行扫描制定包的路径
			else {
				return docket.select().apis(RequestHandlerSelectors.
						basePackage(this.apiScanPackage)).paths(PathSelectors.any()).build();
			}
		}
		else
		{
			Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
				@Override
				public boolean apply(RequestHandler handler) {
					Class apiClazz = handler.declaringClass();
					return apiClazz.isAnnotationPresent(RestController.class)?true:
						   apiClazz.isAnnotationPresent(Controller.class)?
						   handler.isAnnotatedWith(ResponseBody.class):false;
				}
			};
			return docket.select().apis(predicate).build();
		}
	}
	
	/**  
	 * @Title: apiInfo  
	 * @Description:构建API基本信息  
	 * @param @return  参数  
	 * @return ApiInfo    返回类型  
	 * @throws  
	 */ 
	public ApiInfo apiInfo()
	{
		return new ApiInfoBuilder().
				title(this.apiTitle).
				contact(buildStr()).
				description(this.apiDescription).
				license(this.apiLicense).
				licenseUrl(this.apiLicenseUrl).
				termsOfServiceUrl(this.apiTermService).
				version(this.apiVersion).build();
	}
}
