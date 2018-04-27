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
package com.hyts.jfmvc.boot;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.LinkedMap;
import org.apache.log4j.Logger;

import com.hyts.jfmvc.conf.PluginAttrConf;
import com.hyts.jfmvc.core.JfmvcHandler;
import com.hyts.jfmvc.core.JfmvcModel;
import com.jfinal.plugin.IPlugin;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.IDataSourceProvider;

/**  
 * @Title JfmvcModelBuilder.java  
 * @Package com.hyts.jfmvc.boot  
 * @Description 处理模型映射构造器服务
 * @author LiBo/Alex  
 * @date 2017年10月31日  
 * @version V1.0  
 */
public final class JfmvcModelBuilder {

	/**  
	 * @Fields field:field:{日志输出器}
	 */ 
	private static Logger logger = Logger.getLogger(JfmvcRouteBuilder.class);

	/**  
	 * @Fields field:field:{插件构建集合} 
	 */ 
	static Map<PluginAttrConf,IPlugin> plugins = new LinkedMap<PluginAttrConf,IPlugin>();
	
	/**  
	 * @paramparamtheparamthe{设置对象插件服务} to set
	 */
	public static ActiveRecordPlugin addPlugin(PluginAttrConf conf,IDataSourceProvider plugin)
	{
		if(plugin == null)
		{
			logger.error("构建插件失败!"+plugin.toString(),new NullPointerException());
			return null;
		}
		return new ActiveRecordPlugin(plugin);
	}
	
	/**  
	 * @Title: addModel  
	 * @Description: 构建增添model模型对象 
	 * @param @return    参数  
	 * @return boolean    返回类型  
	 * @throws  
	 */ 
	public static boolean addModel(JfmvcModel model)
	{
		if(model == null)
		{
			logger.error("构建模型映射失败!"+model.toString(),new NullPointerException());
			return false;
		}
		return JfmvcHandler.getGlobalInstance().getJfmvcModels().add(model);	
	}

	/**  
	 * 返回结果插件集合服务
	 * @return plugins  
	 */
	public static Map<PluginAttrConf,IPlugin> getPlugins() {
		return plugins;
	}
	
}
