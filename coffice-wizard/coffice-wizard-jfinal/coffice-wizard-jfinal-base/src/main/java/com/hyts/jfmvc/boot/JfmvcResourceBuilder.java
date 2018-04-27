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
package com.hyts.jfmvc.boot;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;

/**  
 * @Title JfmvcServiceBuilder.java  
 * @Package com.hyts.jfmvc.boot  
 * @Description DI和IOC容器进行构造依赖注入方式的
 * @author LiBo/Alex  
 * @date 2017年11月1日  
 * @version V1.0  
 */
public class JfmvcResourceBuilder {
	
	/**  
	 * @Fields field:field:{构建DI映射服务列表}
	 */ 
	static Map<String,List<Field>> diServiceMapper;
	
	static
	{
		if(diServiceMapper == null)
		{
			diServiceMapper = MapUtils.synchronizedMap(new HashMap<String,List<Field>>());
		}
	}
	
	/**  
	 * @Title: addMapperList  
	 * @Description: 增添服务列表映射对关系集合  
	 * @param @param clazzName 类名-所要进行添加的Controller控制器
	 * @param @param mapperField   参数映射字段列表 
	 * @return void    返回类型  
	 * @throws  
	 */ 
	public static void addMapperList(String clazzName,List<Field> mapperField)
	{
		diServiceMapper.put(clazzName, mapperField);
	}
	
	/**  
	 * @Title: getMapperList  
	 * @Description: 映射所有全部的列表
	 * @param @return    参数   
	 * @return Map<String,List<Field>>    返回类型  
	 * @throws  
	 */ 
	public static  Map<String,List<Field>> getMapperList()
	{
		return diServiceMapper;
	}
	
	/**  
	 * @Title: getMapperList  
	 * @Description: 映射所有对于ClazzName名称的参数列表信息  
	 * @param @param clazzName
	 * @param @return    参数  
	 * @return Map<String,List<Field>>    返回类型  
	 * @throws  
	 */ 
	public static List<Field> getMapperList(String clazzName)
	{
		if(diServiceMapper == null || diServiceMapper.isEmpty())
		{
			return null;
		}
		return diServiceMapper.get(clazzName);
	}
	
	/**  
	 * @Title: removeMapperList  
	 * @Description: 移除映射列表信息从中央集合中  
	 * @param @param clazzName
	 * @param @return    参数  
	 * @return boolean    返回类型  
	 * @throws  
	 */ 
	public static boolean removeMapperList(String clazzName)
	{
		if(diServiceMapper == null || diServiceMapper.isEmpty())
		{
			return false;
		}
		return diServiceMapper.remove(clazzName) != null;
	}
}
