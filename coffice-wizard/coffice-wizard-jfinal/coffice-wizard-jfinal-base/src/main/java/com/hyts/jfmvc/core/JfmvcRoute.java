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
package com.hyts.jfmvc.core;

import com.jfinal.core.Controller;

/**  
 * @Title JfmvcRoute.java  
 * @Package com.hyts.jfmvc.core  
 * @Description 模型路由请求转发操作： 
 * @author LiBo/Alex  
 * @date 2017年10月27日  
 * @version V1.0  
 */
public class JfmvcRoute {
	
	/**
	 * @fieldName: modulePath
	 * @fieldType: String
	 * @Description: 主体模块路径
	 */
	private String modulePath;

	/**
	 * @fieldName: modelClassPath
	 * @fieldType: Class<? extends Controller>
	 * @Description: 模型类路径
	 */
	private Class<? extends Controller> modelClassPath;
	
	/**  
	 * @Fields field:field:{子路经附属一级路径path}
	 */ 
	private String childPath;
	

	/**  
	 * 创建一个新的实例-构造器 JfmvcRoute.  
	 * @param modulePath
	 * @param modelClassPath
	 * @param childPath  
	 */ 
	public JfmvcRoute(String modulePath, Class<? extends Controller> modelClassPath,
			String childPath) {
		super();
		this.modulePath = modulePath;
		this.modelClassPath = modelClassPath;
		this.childPath = childPath;
	}

	
	/**  
	 * 创建一个新的实例-构造器 JfmvcRoute.  
	 * @param modulePath
	 * @param modelClassPath  
	 */ 
	public JfmvcRoute(String modulePath, Class<? extends Controller> modelClassPath) {
		super();
		this.modulePath = modulePath;
		this.modelClassPath = modelClassPath;
	}


	/**  
	 * @return childPath  
	 */
	public String getChildPath() {
		return childPath;
	}




	/**  
	 * @param paramtheparamthe{bare_field_name} to set  
	 */
	public void setChildPath(String childPath) {
		this.childPath = childPath;
	}




	public String getModulePath() {
		return modulePath;
	}

	public void setModulePath(String modulePath) {
		this.modulePath = modulePath;
	}

	public Class<? extends Controller> getModelClassPath() {
		return modelClassPath;
	}

	public void setModelClassPath(Class<? extends Controller> modelClassPath) {
		this.modelClassPath = modelClassPath;
	}


	/* (非 Javadoc)  
	 * <p>Title: toString</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see java.lang.Object#toString()  
	 */  
	@Override
	public String toString() {
		return "JfmvcRoute [modulePath=" + modulePath + ", modelClassPath="
				+ modelClassPath + ", childPath=" + childPath + "]";
	}
}
