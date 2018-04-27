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
package com.hyts.jfmvc.bean;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

/**  
 * @Title TransferBean.java  
 * @Package com.hyts.jfmvc.bean  
 * @Description 
 * 				<p>
 * 					转换传递操作域对象：<br>
 * 					用于各个服务或者架构模型项目之间的数，<br>
 * 				        据传递主要用于传递信息数据给其他层次。 <br>
 *  				目前可以不使用，暂时可以自定义，此对<br>
 *  				象用于传递RPC服务使用
 * 				</p>  
 * @author LiBo/Alex  
 * @date 2017年10月26日  
 * @version V1.0  
 */
public class TransferBean implements Serializable {

	/**  
	 * @Fields field:field:{todo}(用一句话描述这个变量表示什么)  
	 */ 
	private static final long serialVersionUID = 5245153893042418266L;

	/**  
	 * @Fields field:field:{todo}内部操作此Param JSONObject对象  
	 */ 
	private JSONObject param;
	
	/**  
	 * 创建一个新的实例-构造器 TransferDomain.    
	 */ 
	public TransferBean()
	{
		param = new JSONObject();
	}

	/**  
	 * @Title: put  
	 * @Description: 放入对象中的方法  
	 * @param @param key
	 * @param @param value
	 * @param @return    参数  
	 * @return Object    返回类型  
	 * @throws  
	 */ 
	public Object put(String key,Object value)
	{
		return param.put(key, value);
	}
	
	/**  
	 * @Title: get  
	 * @Description: 获取key对于的参数值
	 * @param @param key
	 * @param @return    参数  
	 * @return Object    返回类型  
	 * @throws  
	 */ 
	public Object get(String key)
	{
		return param.get(key);
	}
	
	/**  
	 * @Title: replace  
	 * @Description: 替换key对于的参数值  
	 * @param @param key
	 * @param @param value
	 * @param @return    参数  
	 * @return Object    返回类型  
	 * @throws  
	 */ 
	public Object replace(String key,Object value)
	{
		return param.replace(key, value);
	}
	
	/**  
	 * @Title: remove  
	 * @Description: 删除key对于的值
	 * @param @param key
	 * @param @return    参数  
	 * @return Object    返回类型  
	 * @throws  
	 */ 
	public Object remove(String key)
	{
		return param.remove(key);
	}
	
	/**  
	 * @Title: entity  
	 * @Description: 执行传入的实体对象数据  
	 * @param @return    参数  
	 * @return JSONObject    返回类型  
	 * @throws  
	 */ 
	public JSONObject entity()
	{
		return param;
	}

	/* (非 Javadoc)  
	 * <p>Title: toString</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see java.lang.Object#toString()  
	 */  
	@Override
	public String toString() {
		return param.toJSONString();
	}
}
