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
package com.hyts.jfmvc.bind.error;

/**  
 * @Title GuiceBindException.java  
 * @Package com.hyts.bind.error  
 * @Description Guice框架绑定操作出现错误的异常类型
 * @author LiBo/Alex  
 * @date 2017年10月25日  
 * @version V1.0  
 */
public class GuiceBindException extends RuntimeException {

	/**  
	 * 创建一个新的实例-构造器 GuiceBindException.    
	 */ 
	public GuiceBindException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**  
	 * 创建一个新的实例-构造器 GuiceBindException.  
	 * @param arg0  
	 */ 
	public GuiceBindException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**  
	 * 创建一个新的实例-构造器 GuiceBindException.  
	 * @param arg0  
	 */ 
	public GuiceBindException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
}
