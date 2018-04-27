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

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**  
 * @Title JfmvcContainer.java  
 * @Package com.hyts.jfmvc.core  
 * @Description TODO(用一句话描述该文件做什么)  
 * @author LiBo/Alex  
 * @date 2017年10月27日  
 * @version V1.0  
 */
public class JfmvcHandler {

	/**  
	 * @Fields field:field:{操作处理器父类}  
	 */ 
	private static JfmvcHandler handlerCont;
	
	 /**  
	 * @Fields field:field:{model模型映射集合}
	 */ 
	private List<JfmvcModel> jfmvcModels;
	
	 /**  
	 * @Fields field:field:{route路由映射集合}
	 */ 
	private List<JfmvcRoute> jfmvcRoutes;

	/**  
	 * @Fields field:field:{Service注解信息数据类列表:去重}  
	 */ 
	private HashSet<Class> serviceList;
	
	/**  
	 * 创建一个新的实例-构造器 JfmvcHandler.    
	 */ 
	private JfmvcHandler()
	{
		jfmvcModels = new LinkedList<JfmvcModel>();
		jfmvcRoutes = new LinkedList<JfmvcRoute>();
		serviceList = new LinkedHashSet<Class>();
	}
	
	/**  
	 * @return jfmvcModels  
	 */
	public  List<JfmvcModel> getJfmvcModels() {
		return jfmvcModels;
	}

	/**  
	 * @return jfmvcRoutes  
	 */
	public  List<JfmvcRoute> getJfmvcRoutes() {
		return jfmvcRoutes;
	}
	
	/**  
	 * @return serviceList  
	 */
	public HashSet<Class> getServiceList() {
		return serviceList;
	}

	/**  
	 * @Title: getGlobalInstance  
	 * @Description: 单例对象 
	 * @param @return    参数  
	 * @return JfmvcHandler    返回类型  
	 * @throws  
	 */ 
	public static JfmvcHandler getGlobalInstance()
	{
		if(handlerCont == null)
		{
			handlerCont = new JfmvcHandler();
		}
		return handlerCont;
	}
}
