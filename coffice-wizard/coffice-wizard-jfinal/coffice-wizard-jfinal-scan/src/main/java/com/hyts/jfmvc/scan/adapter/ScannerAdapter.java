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
package com.hyts.jfmvc.scan.adapter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**  
 * @Title ScannerAdapter.java  
 * @Package com.hyts.bind.scanner  
 * @Description 依赖注入框架扫描适配器操作服务<br>
 * 				兼顾起注解以及依赖注入服务的双<br>
 * 				向整合，达到桥接的模式过程<br>
 * @author LiBo/Alex  
 * @date 2017年10月25日  
 * @version V1.0  
 */
public final class ScannerAdapter {

	/**  
	 * @Title: scanField  
	 * @Description: 获取指定类中的所有字段相关指定注解类  
	 * @param @param clazz
	 * @param @return    参数  
	 * @return List<String>    返回类型  
	 * @throws  
	 */ 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<Field> scanField(Class clazz,Class annotation)
	{
		Field [] fields = clazz.getDeclaredFields();
		List<Field> annotationMap = new ArrayList<Field>();
		for(Field field:fields)
		{
			Annotation fieldAnnotation = field.getDeclaredAnnotation(annotation);
			annotationMap.add(field);
		}
		return annotationMap;
	}
	
	/**  
	 * @Title: scanMethod  
	 * @Description: 获取指定类中的所有方法相关指定注解类  
	 * @param @param clazz
	 * @param @param annotation
	 * @param @return    参数  
	 * @return Map<String,Annotation>    返回类型  
	 * @throws  
	 */ 
	public static Map<String,Annotation> scanMethod(Class clazz,Class annotation)
	{
		Method [] methods = clazz.getDeclaredMethods();
		Map<String,Annotation> annotationMap = new HashMap<String,Annotation>();
		for(Method method:methods)
		{
			Annotation fieldAnnotation = method.getDeclaredAnnotation(annotation);
			annotationMap.put(method.getName(),fieldAnnotation);
		}
		return annotationMap;
	}
}
