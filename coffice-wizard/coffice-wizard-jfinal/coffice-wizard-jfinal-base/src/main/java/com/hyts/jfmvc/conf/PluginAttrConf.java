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
package com.hyts.jfmvc.conf;

/**  
 * @Title PluginAttrConf.java  
 * @Package com.hyts.jfmvc.conf  
 * @Description 插件服务属性操作配置  
 * @author LiBo/Alex  
 * @date 2017年11月6日  
 * @version V1.0  
 */
public enum PluginAttrConf {

	/**
	 * c3p0数据源配置文件
	 */
	C3P0("c3p0.properties"),

	/**
	 * drud数据源配置文件
	 */
	DRUD("drud.properties"),

	/**
	 * redis数据源配置文件
	 */
	REDIS("redis.properties"),

	/**
	 * ehcache数据源配置文件
	 */
	EHCACHE("ehcache.properties");

	private String value;

	PluginAttrConf(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
