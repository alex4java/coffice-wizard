/*
 * Copyright (c) 2017, Li Bo/Alex Lee All rights reserved.
 * 
 * http://www.libo4dream.club/
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
 
package com.hyts.jfmvc.util;

/**
 * @ClassName: ConstantUtils
 * @Description: 常量信息值数据工具加载类
 * @author: LiBo/Alex Lee
 * @date: 2017年9月22日 下午3:27:45
 * @email: alexlibochn@china-pui.com.cn/alex.link@foxmail.com
 */
public class ConstantUtils {
	
	
	  /**
	 * @Title: yesOrNo
	 * @Description: 根据boolean值确定是否返回是或否
	 * @param flag
	 * @return
	 * @return: String
	 */
	public static String yesOrNo(boolean flag) {
		 return flag?"是":"否";
	}
}
