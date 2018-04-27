/* 
 * Copyright [2018] [Alex/libo(liboms@hotmail.com)]
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
package com.hyts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
 * @title TestController.java  
 * @package com.hyts.controller  
 * @description TODO  
 * @see TODO
 * @author libo/Alex
 * @email liboms@hotmail.com/liboware@163.com  
 * @date 2018年4月21日 
 * @version V1.0 
 */
@Controller
@RequestMapping("/test")
public class TestController {
	
	
	@RequestMapping("/testC")
	@ResponseBody
	public String testC(){
		return "131";
	}

}
