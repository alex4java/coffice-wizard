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
 
package net.alex.scan.error;

/**
 * @ClassName: ScanException
 * @Description: 扫描操作异常类
 * @author: 李博/Alex
 * @date: 2017-2-27 下午6:00:47
 * @email:  alexlibochn@china-pui.com.cn
 */
public class ScanException extends Exception {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 串行化流水
	 */
	private static final long serialVersionUID = -1180753547113490156L;

	
	public ScanException(String message, Throwable cause) {
		super(message, cause);
	}

	public ScanException(String message) {
		super(message);
	}

	public ScanException(Throwable cause) {
		super(cause);
	}
	
}
