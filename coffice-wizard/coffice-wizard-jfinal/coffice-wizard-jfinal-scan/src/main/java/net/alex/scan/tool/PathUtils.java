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

import net.alex.scan.error.ScanException;

/**
 * @ClassName: LoadPathUtil
 * @Description: 系统加载文件路径工具类
 * @author: 李博/Alex
 * @date: 2017-2-28 下午2:06:27
 * @email:  alexlibochn@china-pui.com.cn
 */
public final class PathUtils {

	/**
	 * @Title: getClassRunnerPath
	 * @Description: 获取class 运行操作路径
	 * @param classPath
	 * @return
	 * @return: String
	 * @throws ScanException 
	 */
	public static String getClassRunnerPath(String classPath) throws ScanException{
		
		classPath = StringUtils.isNull(classPath)?".":classPath;
		URL url = PathUtils.class.getClassLoader().getResource(classPath);
		if(url == null)
			throw new ScanException("不存在该路径:"+classPath);
		String str = url.getPath();
		if(StringUtils.isNull(str))
		{
			str = Thread.currentThread().getContextClassLoader().getResource(classPath).getPath();
		}
		return str;
	}

	/**
	 * @Title: getClassLoaderPath
	 * @Description: 获取classLoader运行路径：<br>
	 * 				 1.workspace/projectName
	 * 				 2.tomcat/jetty/jboss's path/bin
	 * @param classPath
	 * @return
	 * @return: String
	 * @throws IOException 
	 */
	public static String getClassLoaderPath() throws IOException{
		
		String str = System.getProperty("user.dir");
		
		if(StringUtils.isNull(str))
		{
			str = new File(".").getCanonicalPath();
			if(StringUtils.isNull(str))
			{
				return new File("").getAbsolutePath();
			}
			return str;
		}
		else
		{
			return str;
		}
	}
	
	public static void main(String[] args) {
		
		//System.out.println(PropUtils.getPropertiesValue("123"));
		try {
			System.out.println(getClassLoaderPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(PathUtils.class.getClassLoader().getResource("net/alex/scan/error"));
	}
	
}
