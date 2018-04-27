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
package com.hyts.jfmvc.bind;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.hyts.jfmvc.boot.JfmvcResourceBuilder;
import com.jfinal.aop.Duang;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**  
 * @Title BindInterceptor.java  
 * @Package com.hyts.jfmvc.jfinal  
 * @Description Jfinal框架总体核心基础拦截器 
 * @author LiBo/Alex  
 * @date 2017年10月26日  
 * @version V1.0  
 */
public class BindServiceInterceptor implements Interceptor {

	
	/**  
	 * @Fields field:field:{日志输出器} 
	 */ 
	private static final Logger LOG = Logger.getLogger(BindServiceInterceptor.class);

	/* (非 Javadoc)  
	 * <p>Title: intercept</p>  
	 * <p>Description: </p>  
	 * @param inv  
	 * @see com.jfinal.aop.Interceptor#intercept(com.jfinal.aop.Invocation)  
	 */
	@Override
	public void intercept(Invocation inv) {
		//获取Service实现业务层次类
		//System.out.println(inv.getTarget());
		Object clazz = inv.getTarget();
		String clazzName = clazz.getClass().getName();
		if(StringUtils.isNotBlank(clazzName) && StringUtils.indexOf(clazzName, "$$") > -1)
		{
			clazzName = StringUtils.substring(clazzName,0,StringUtils.indexOf(clazzName, "$$"));
		}
		LOG.info("[hyts-jfmvc-base] --- [Service-控制器-拦截器] --- "+clazzName);
		List<Field> tempList = JfmvcResourceBuilder.getMapperList(clazzName);
		tempList.forEach(field->{
			boolean flag = field.isAccessible();
			if(!flag)
			{
				field.setAccessible(true);
			}
			//进行实例化对于的实例-通过反射
		    Object value = BindSubjectHandler.getFmkInjector().getInstance(field.getType());
			LOG.info("[hyts-jfmvc-base] --- [Service-控制器-拦截器] --- 构建执行Service映射：进行反射依赖注入：Service类 ----> "+value);
			try {
				field.set(clazz,value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		//最后执行以及操作执行
		inv.invoke();
	}

}
