package com.hyts.jfmvc.plugins.c3p0;

import com.hyts.jfmvc.boot.JfmvcModelBuilder;
import com.hyts.jfmvc.conf.PluginAttrConf;
import com.jfinal.config.Plugins;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import org.apache.log4j.Logger;
import sun.applet.Main;

import java.io.File;

/**
 * @ClassName: C3p0PluginBuilder
 * @Description: C3p0插件构建器
 * @author: LiBo/Alex Lee
 * @date: 2017年9月21日 下午5:43:54
 * @email: alexlibochn@china-pui.com.cn/alex.link@foxmail.com
 */
public class C3p0PluginBuilder {


       /**
        * 增添日志输出器
        */
        private static final Logger logger = Logger.getLogger(C3p0PluginBuilder.class);

       /**
        * @Title: build
        * @Description: 构建服务C3p0插件
        * @param @return    参数
        * @return ActiveRecordPlugin    返回类型
        * @throws
        */
        public static ActiveRecordPlugin build(Plugins plugins)
        {
            //构建C3P0数据源连接池进行构造插件服务
            C3p0Plugin c3p0Plugin = new C3p0Plugin(new File(C3p0PluginBuilder.class.getClassLoader().getResource(PluginAttrConf.C3P0.getValue()).getFile()));
            plugins.add(c3p0Plugin);
            logger.info("[hyts-jfmvc-base] --- [c3p0插件] --- "+c3p0Plugin.getDataSource());
            return JfmvcModelBuilder.addPlugin(PluginAttrConf.C3P0,c3p0Plugin);
        }

}
