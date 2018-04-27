/*
 * Copyright (c) 2017, Li Bo/Alex All rights reserved.
 * 
 * http://blog.sina.com.cn/alex4java
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
 
package net.alex.scan.tool;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import net.alex.scan.adapter.ScanAdapter;
import net.alex.scan.config.Config;
import net.alex.scan.error.ScanException;

/**
 * @ClassName: PropLoader
 * @Description: 读取Properties文件加载器<br>
 * 				   默认读取classpath根目录下面的<br>
 * 				 scan.properties文件<br>
 * 				  也可以手动指定
 * @author: 李博/Alex
 * @date: 2017-2-27 下午5:46:48
 * @email:  alexlibochn@china-pui.com.cn
 */
public final class PropUtils {

	
	private static final Properties prop = new Properties();
	

	static{
		try {
			//url路径服务
			URL url = PropUtils.class.getClassLoader().getResource(Config.DEFAULT_SCANNER_PATH);
			//url校验
			if(url != null)
			{
				prop.load(PropUtils.class.getClassLoader().getResourceAsStream(Config.DEFAULT_SCANNER_PATH));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Title: getPropertiesValue
	 * @Description: 获取对应的value值
	 * @param key
	 * @return
	 * @return: String
	 */
	public static String getPropertiesValue(String key){
		if(prop.containsKey(key) && StringUtils.isNotNull(key)){
			return prop.getProperty(key);
		}
		return null;
	}
	
	
}
