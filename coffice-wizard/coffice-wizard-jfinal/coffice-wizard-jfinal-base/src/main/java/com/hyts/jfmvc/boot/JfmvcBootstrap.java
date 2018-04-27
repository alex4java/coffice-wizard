/*
 * Copyright (c) 2017, Li Bo/Alex Lee All rights reserved.
 * 
 * https://github.com/alex4java
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 
package com.hyts.jfmvc.boot;


import com.hyts.jfmvc.bean.DevInfoBean;
import com.hyts.jfmvc.bind.BindControllerInterceptor;
import com.hyts.jfmvc.bind.BindServiceInterceptor;
import com.hyts.jfmvc.bind.BindSubject;
import com.hyts.jfmvc.bind.BindSubjectHandler;
import com.hyts.jfmvc.conf.JfinalAttrConf;
import com.hyts.jfmvc.core.JfmvcHandler;
import com.hyts.jfmvc.plugins.c3p0.C3p0PluginBuilder;
import com.hyts.jfmvc.util.ConstantUtils;
import com.hyts.jfmvc.util.StringUtils;
import com.jfinal.config.*;
import com.jfinal.core.Const;
import com.jfinal.core.JFinal;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.json.FastJsonFactory;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.render.FreeMarkerRender;
import com.jfinal.render.ViewType;

import org.apache.log4j.Logger;

import java.util.Objects;
import java.util.Properties;

/**
 * @ClassName: JfmvcBootstrap
 * @Description: Jfinal 框架启动服务的基本参数以及总体发布参数类<br>
 * 				   因为Jfmvc是基于Jfinal框架作为Http输出以及<br>
 * 				   页面或者Stream流交互的端点、故此需要针对于此方面进行<br>
 * 				   拆分，Jfinal服务用于设计启动服务、以及提供API请求服务<br>
 * @author: LiBo/Alex Lee
 * @date: 2017年9月21日 下午5:43:54
 * @email: alexlibochn@china-pui.com.cn/alex.link@foxmail.com
 */
public class JfmvcBootstrap extends JFinalConfig{

	/**
	 * @fieldName: logger
	 * @fieldType: Logger
	 * @Description: 日志输出器：摒弃Jfinal框架多余的log操作
	 */
	private static final Logger logger = Logger.getLogger(JfmvcBootstrap.class);
	
	/* 
	 * @Title: configConstant
	 * @Description: 设定服务系统环境参数
	 * @param arg0
	 * @see com.jfinal.config.JFinalConfig#configConstant(com.jfinal.config.Constants)
	 */
	@Override
	public void configConstant(Constants env) {
		logger.info("[hyts-jfmvc-base] --- [运行环境] --- 开始设置和启动系统服务环境......");
		//初始化框架环境
		initEnrionment(env);
		//初始化框架信息
		initDevInfo();
		//初始化绑定所有拦截器便于扩展和管理调研
		logger.info("[hyts-jfmvc-base] --- [Guice容器] --- 开始创建系统服务Guice对象容器绑定操作,构建BindSubject对象");
		BindSubjectHandler.initBindSubject();
		logger.info("[hyts-jfmvc-base] --- [Guice容器] --- BindSubject构建完成，可以用：BindSubject.get**Interceptor()获取系统拦截器");
	}

	/*
	 * @Title: configHandler
	 * @Description: 配置jfmvc框架系统操作句柄服务
	 * @param arg0
	 * @see com.jfinal.config.JFinalConfig#configHandler(com.jfinal.config.Handlers)
	 */
	@Override
	public void configHandler(Handlers arg0) {
		//添加项目contextPath,以便在页面直接获取该值 ${base?if_exists}
		String path = this.getProperty("jfmvc.freemarker_context_path", JfinalAttrConf.JFINAL_DEFAULT_FREEMARKER_VIEW_PATH);
		arg0.add(new ContextPathHandler(path));
		logger.info("[hyts-jfmvc-base] --- [处理器] --- freemarker框架系统视图基础路径:"+path);
	}

	/* 
	 * @Title: configInterceptor
	 * @Description: 构建绑定系统相对于的拦截器
	 * @param arg0
	 * @see com.jfinal.config.JFinalConfig#configInterceptor(com.jfinal.config.Interceptors)
	 */
	@Override
	public void configInterceptor(Interceptors interceptorStack) {
		logger.info("[hyts-jfmvc-base] --- [拦截器] --- 开始构建和绑定系统相对于的拦截器到拦截器栈中......");
		interceptorStack.addGlobalActionInterceptor(BindSubject.getControllerInterceptor());
		logger.info("[hyts-jfmvc-base] --- [拦截器] ---  构建Guice容器对象:"+BindControllerInterceptor.class.getName());
		interceptorStack.addGlobalServiceInterceptor(BindSubject.getServiceIntercepor());
		logger.info("[hyts-jfmvc-base] --- [拦截器] ---  构建Guice容器对象:"+BindServiceInterceptor.class.getName());
		logger.info("[hyts-jfmvc-base] --- [拦截器] ---  系统级别基础拦截器绑定结束,如果要绑定其他扩展型");	
	}

	/* (non Javadoc)
	 * @Title: configPlugin
	 * @Description: 构建组件服务
	 * @param arg0
	 * @see com.jfinal.config.JFinalConfig#configPlugin(com.jfinal.config.Plugins)
	 */
	@Override
	public void configPlugin(Plugins plugins) {
		logger.info("------------------------------------------------------------------");
		if (this.getPropertyToBoolean("jfmvc.datasource_connect",false)) {			
			logger.info("[hyts-jfmvc-base] --- [插件构建器] ---开始构建C3p0Plugin插件构建器......");
			//构建C3P0数据源连接池进行构造插件服务
			ActiveRecordPlugin pluginTemplate  = C3p0PluginBuilder.build(plugins);
			plugins.add(pluginTemplate);
		logger.info("[hyts-jfmvc-base] --- [插件构建器] ---结束构建C3p0Plugin插件构建器.");
		logger.info("------------------------------------------------------------------");
		logger.info("[hyts-jfmvc-base] --- [插件构建器] ---开始构建模型构建器......");
		JfmvcHandler.getGlobalInstance().getJfmvcModels().forEach(model-> {
			if(model != null){
				pluginTemplate.addMapping(model.getTableName(),model.getIdName(), (Class<? extends Model<?>>) model.getModelClass());
				logger.info("[hyts-jfmvc-base] --- [模型构建器] ---."+model);
			}
		});
		logger.info("[hyts-jfmvc-base] --- [模型构建器] ---结束构建模型构建器.");
		logger.info("------------------------------------------------------------------");
	  }
	}

	/* (non Javadoc)
	 * @Title: configRoute
	 * @Description: 构造服务
	 * @param arg0
	 * @see com.jfinal.config.JFinalConfig#configRoute(com.jfinal.config.Routes)
	 */
	@Override
	public void configRoute(Routes routes) {
		logger.info("[hyts-jfmvc-base] --- [路由器] --- 开始构建和绑定系统相对于请求转发路径映射关系服务......");
		JfmvcRouteBuilder.deal(routes);
		logger.info("[hyts-jfmvc-base] --- [路由器] --- 完成请求转发路径映射关系服务。");
	}
	
	/**  
	 * @Title: main  
	 * @Description: 允许操作服务  
	 * @param @param args    参数  
	 * @return void    返回类型  
	 * @throws  
	 */ 
	public static void main(String[] args){
		
		JFinal.start("src/main/webapp",80, "/",5);
	}
	
	/**  
	 * @Title: initEnrionment  
	 * @Description: 初始化系统环境 
	 * @param @param env    参数  
	 * @return void    返回类型  
	 * @throws  
	 */ 
	private void initEnrionment(Constants env)
	{
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("-----------------------------------------------------------------------------");
		logger.info("[hyts-jfmvc-base] --- [运行环境] --- 进行初始化系统环境参数:");
		this.loadPropertyFile(JfinalAttrConf.JFINAL_CONFIG_PROPERTIES);
		String devModelStr = this.getProperty("jfmvc.devModel");
		boolean devModel = StringUtils.isEmpty(devModelStr)
				?JfinalAttrConf.JFINAL_CONFIG_DEVMODEL:Boolean.valueOf(devModelStr);
		logger.info("[hyts-jfmvc-base] --- [运行环境] --- jfmvc框架是否开启开发模式："+ConstantUtils.yesOrNo(devModel));
		env.setDevMode(devModel);
		logger.info("[hyts-jfmvc-base] --- [运行环境] --- jfmvc框架是否开启Freemarker模板："+ConstantUtils.yesOrNo(true));
		env.setViewType(ViewType.FREE_MARKER);
		int freemarker_delay_time = this.getPropertyToInt("jfmvc.freemarker_delay_time", JfinalAttrConf.JFINAL_FREEMARKER_DELAY_TIME);
		logger.info("[hyts-jfmvc-base] --- [运行环境] --- jfmvc框架是设置初始化配置freemarker的延迟周期："+freemarker_delay_time+" 毫秒");
		env.setFreeMarkerTemplateUpdateDelay(freemarker_delay_time);
		String url_spe_token = this.getProperty("jfmvc.url.para.separator", JfinalAttrConf.JFINAL_DEFAULT_SEP_TOKEN);
		env.setUrlParaSeparator(url_spe_token);
		logger.info("[hyts-jfmvc-base] --- [运行环境] --- jfmvc框架是设置初始化配置请求参数分隔符："+url_spe_token);
		String baseViewPath = this.getProperty("jfmvc.freemarker_base_path",JfinalAttrConf.JFINAL_DEFAULT_FREEMARKER_BASE_PATH);
		logger.info("[hyts-jfmvc-base] --- [运行环境] --- jfmvc框架是设置初始化配置请求静态访问页面的目录："+baseViewPath);
		String subfixName = this.getProperty("jfmvc.freemarker_subfix_name",JfinalAttrConf.JFINAL_DEFAULT_FREEMARKER_SUBFIX_NAME);
		env.setFreeMarkerViewExtension(".html");//freemarker 模板后缀名
		logger.info("[hyts-jfmvc-base] --- [运行环境] --- jfmvc框架是设置初始化配置freemarker模板后缀名："+subfixName);
		String uploadPath = this.getProperty("jfmvc.upload_path",JfinalAttrConf.JFINAL_DEFAULT_UPLOAD_PATH);
		logger.info("[hyts-jfmvc-base] --- [运行环境] --- jfmvc框架是设置上传目录路径："+uploadPath);
		env.setBaseUploadPath(uploadPath);
		String downloadPath = this.getProperty("jfmvc.download_path",JfinalAttrConf.JFINAL_DEFAULT_DOWNLOAD_PATH);
		logger.info("[hyts-jfmvc-base] --- [运行环境] --- jfmvc框架是设置下载目录路径："+downloadPath);
		env.setBaseDownloadPath(downloadPath);
		logger.info("[hyts-jfmvc-base] --- [运行环境] --- jfmvc框架是设置最大文件尺寸："+Const.DEFAULT_MAX_POST_SIZE+"KB");
		env.setMaxPostSize(Const.DEFAULT_MAX_POST_SIZE);
		logger.info("[hyts-jfmvc-base] --- [运行环境] --- jfmvc框架是设置JSON工厂类：com.jfinal.json.FastJsonFactory.FastJsonFactory");
		env.setJsonFactory(new FastJsonFactory());
		logger.info("[hyts-jfmvc-base] --- [运行环境] --- 结束设置和启动系统服务环境参数");
		logger.info("-----------------------------------------------------------------------------");
	}
	
	/**  
	 * @Title: initDevInfo  
	 * @Description: 初始化开发信息 
	 * @param :参数
	 * @return void    返回类型  
	 * @throws  
	 */ 
	private void initDevInfo()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("[hyts-jfmvc-base] --- [框架信息] --- 开始加载系统开发框架人员信息");
		logger.info("-----------------------------------------------------------------------------");
		DevInfoBean model = new DevInfoBean();
		model.setDevVersion(this.getProperty("jfmvc.version"));
		model.setDevChinaName(this.getProperty("developer_cn_name"));
		model.setDevEnglishName(this.getProperty("developer_en_name"));
		model.setDevEmail(this.getProperty("developer_email"));
		model.setDevTelephone(this.getProperty("developer_telephone"));
		model.setDevHomePage(this.getProperty("developer_homepage"));
		logger.info("[hyts-jfmvc-base] --- [框架信息] --- 开发人员信息:"+model);
		logger.info("[hyts-jfmvc-base] --- [框架信息] --- 系统版本号:"+model.getDevVersion());
		logger.info("-----------------------------------------------------------------------------");
		logger.info("[hyts-jfmvc-base] --- [框架信息] --- 结束加载系统开发框架人员信息");
		logger.info("-----------------------------------------------------------------------------");
	}

	/* (非 Javadoc)  
	 * <p>Title: afterJFinalStart</p>  
	 * <p>Description: </p>    
	 * @see com.jfinal.config.JFinalConfig#afterJFinalStart()  
	 */  
	@Override
	public void afterJFinalStart() {
		Properties p = null;
		try{
			p = loadPropertyFile(this.getProperty("jfmvc.freemarker_path",JfinalAttrConf.JFINAL_DEFAULT_FREEMARKER_VIEW_PATH));
			if(Objects.nonNull(p)) {
				logger.info("[hyts-jfmvc-base] --- [框架信息] --- 基础JFinal框架读取Freemarker配置文件"+p);
				FreeMarkerRender.setProperties(p);
			}
		}catch(Exception e){
			logger.warn("无法加载freemarker配置文件!");
		}
	}

	/* (非 Javadoc)  
	 * <p>Title: beforeJFinalStop</p>  
	 * <p>Description: </p>    
	 * @see com.jfinal.config.JFinalConfig#beforeJFinalStop()  
	 */  
	@Override
	public void beforeJFinalStop() {
		super.beforeJFinalStop();
	}

}
