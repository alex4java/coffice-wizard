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
 * @ClassName: StringUtils
 * @Description: 字符串操作工具类,针对于字符串进行基本操作
 * @author: LiBo/Alex Lee
 * @date: 2017年9月22日 下午3:15:18
 * @email: alexlibochn@china-pui.com.cn/alex.link@foxmail.com
 */
public class StringUtils {

		/**
		 * @Title: isEmpty
		 * @Description: 判断是否为空!
		 * @param param
		 * @return
		 * @return: boolean
		 */
		public static boolean isEmpty(String param) {
			return (param == null || param.length() == 0 || "null".equals(param));
		}
		
		
		/**
		 * @Title: isNotEmpty
		 * @Description: 判断是否为空!
		 * @param param
		 * @return
		 * @return: boolean
		 */
		public static boolean isNotEmpty(String param) {
			return isEmpty(param);
		}
}
