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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.alex.scan.error.ScanException;

/**
 * @ClassName: StringUtils
 * @Description: TODO
 * @author: 李博/Alex
 * @date: 2017-2-28 下午2:58:27
 * @email:  alexlibochn@china-pui.com.cn
 */
public final class StringUtils {

	
	/********************************字符串工具类判断是否为空*************************************************/
	
	/**
	 * @Title: isNull
	 * @Description: 是否为空
	 * @param str
	 * @return
	 * @return: boolean
	 */
	public static boolean isNull(String str){
		return (str == null || str.trim().length() == 0);
	}
	
	/**
	 * @Title: isNotNull
	 * @Description: 是否不为空
	 * @param str
	 * @return
	 * @return: boolean
	 */
	public static boolean isNotNull(String str){
		return !(str == null || str.trim().length() == 0);
	}
	
	/********************************字符串替换操作*************************************************/

	/**
	 * @Title: replace
	 * @Description: 替换字符串
	 * @param replaceStr
	 * @param replaceToken
	 * @return
	 * @return: String
	 * @throws ScanException 
	 */
	public static String replace(String replaceStr,String oldToken,String replaceToken) throws ScanException{
		if(StringUtils.isNull(replaceStr) || StringUtils.isNull(oldToken)  || StringUtils.isNull(replaceToken))
			throw new ScanException("传入的替换字符串为空!");
		
		Matcher matcher = Pattern.compile(oldToken).matcher(replaceStr);
		return matcher.replaceAll(replaceToken);
	}
	
	/**
	 * @Title: join
	 * @Description: 拼接字符串
	 * @param str
	 * @param token
	 * @return
	 * @throws ScanException
	 * @return: String
	 */
	public static String join(String[] str, String token) throws ScanException{
		if(str == null || str.length == 0 || StringUtils.isNull(token))
			throw new ScanException("传入的字符串数组以及参数为空!");
		StringBuilder sbv = new StringBuilder();
		for(String element: str){
			sbv.append(element).append(token);
		}
		return sbv.toString().substring(0,sbv.toString().length()-1);
	}
	
	
	/**
	 * @Title: defaultValue
	 * @Description: 默认值赋值操作:进行赋值默认值操作
	 * @param str
	 * @param defaultValue
	 * @return
	 * @return: String
	 */
	public static String defaultValue(String str,String defaultValue)
	{
		return StringUtils.isNull(str)?defaultValue:str;
			
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(join(new String[]{"net","alex"},"."));
		} catch (ScanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
