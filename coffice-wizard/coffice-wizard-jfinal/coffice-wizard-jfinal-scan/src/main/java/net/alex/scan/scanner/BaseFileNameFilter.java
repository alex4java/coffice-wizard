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
 
package net.alex.scan.scanner;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

import net.alex.scan.config.Config;
import net.alex.scan.error.ScanException;
import net.alex.scan.tool.ScanUtils;
import net.alex.scan.tool.StringUtils;

/**
 * @ClassName: BaseFileNameFilter
 * @Description: 文件路径名称过滤器
 * @author: 李博/Alex
 * @date: 2017-2-28 下午4:35:52
 * @email:  alexlibochn@china-pui.com.cn
 */
public class BaseFileNameFilter implements FilenameFilter {

	/**
	 * @fieldName: extName
	 * @fieldType: String
	 * @Description: TODO
	 */
	private static final String extName = Config.SCANNER_EXT_NAME;
	
	/* (non Javadoc)
	 * @Title: accept
	 * @Description: TODO
	 * @param dir
	 * @param name
	 * @return
	 * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
	 */
	@Override
	public boolean accept(File dir, String name) {
		
		if(StringUtils.isNull(extName))
		{
			return true;
		} 
		else
			try {
				if(StringUtils.isNotNull(Config.EXCLUDE_PACKAGE_NAME) && equal(dir)){
					return false;
				}
				else
				{
					String [] extNames = extName.split(",");
					for(String extName:extNames){
						if(Arrays.asList(extName).contains(extName))
						{
							return true;
						}
					}
				}
			} catch (ScanException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		return !name.contains("$");
	}

	/**
	 * @Title: equal
	 * @Description: 是否相等
	 * @param dir
	 * @return
	 * @throws ScanException
	 * @return: boolean
	 */
	private static boolean equal(File dir) throws ScanException{
		if(dir == null)
			return true; 
		for(String path:Config.EXCLUDE_PACKAGE_NAME.split(",")){
			if(dir.equals(new File(ScanUtils.transferPackage2Path(path)))){
				return true;
			}
		}
		return false;
	}
	
	
}
