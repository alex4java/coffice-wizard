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
import java.io.FileFilter;


/**
 * @ClassName: BaseFileFilter
 * @Description: 基础文件过滤器
 * @author: 李博/Alex
 * @date: 2017-2-28 下午4:35:30
 * @email:  alexlibochn@china-pui.com.cn
 */
public class BaseFileFilter implements FileFilter {

	/* (non Javadoc)
	 * @Title: accept
	 * @Description: TODO
	 * @param pathname
	 * @return
	 * @see java.io.FileFilter#accept(java.io.File)
	 */
	@Override
	public boolean accept(File pathname) {
		
		return false;
	}

}
