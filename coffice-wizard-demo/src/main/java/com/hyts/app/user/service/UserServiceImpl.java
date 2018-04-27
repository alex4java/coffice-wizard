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
package com.hyts.app.user.service;

import com.hyts.jfmvc.rpc.UserService;
import com.hyts.jfmvc.scan.annotation.Service;


/**  
 * @Title UserServiceImpl.java  
 * @Package com.hyts.app.user.service  
 * @Description TODO(用一句话描述该文件做什么)  
 * @author LiBo/Alex  
 * @date 2017年10月27日  
 * @version V1.0  
 */
@Service
public class UserServiceImpl implements UserService{

	/* (非 Javadoc)  
	 * <p>Title: test</p>  
	 * <p>Description: </p>    
	 * @see com.hyts.jfmvc.rpc.UserService#test()  
	 */  
	@Override
	public void test() {
		System.out.println("测试UserService");
	}

}
