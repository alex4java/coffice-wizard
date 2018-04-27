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

/**  
 * @Title JfmvcModel.java  
 * @Package com.hyts.jfmvc.core  
 * @Description Jfmvc框架的模型-数据库-映射关系容器服务：ORM映射操作容器  
 * @author LiBo/Alex  
 * @date 2017年10月27日  
 * @version V1.0  
 */
public final class JfmvcModel {

	/**  
	 * @Fields field:field:{表名称}  
	 */ 
	private String tableName;
	
	/**  
	 * @Fields field:field:{id主键-关键字}  
	 */ 
	private String idName;
	
	/**  
	 * @Fields field:field:{模型操作类} 
	 */ 
	private Class<?> modelClass;

	
	/**  
	 * 创建一个新的实例-构造器 JfmvcModels.    
	 */ 
	public JfmvcModel() {
		super();
	}
	
	/**  
	 * 创建一个新的实例-构造器 JfmvcModels.  
	 * @param tableName
	 * @param idName
	 * @param modelClass  
	 */ 
	public JfmvcModel(String tableName, String idName, Class<?> modelClass) {
		super();
		this.tableName = tableName;
		this.idName = idName;
		this.modelClass = modelClass;
	}

	/**  
	 * 创建一个新的实例-构造器 JfmvcModels.  
	 * @param tableName
	 * @param modelClass  
	 */ 
	public JfmvcModel(String tableName, Class<?> modelClass) {
		super();
		this.tableName = tableName;
		this.modelClass = modelClass;
	}

	/**  
	 * @return tableName  
	 */
	public String getTableName() {
		return tableName;
	}

	/**  
	 * @param paramtheparamthe{bare_field_name} to set  
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**  
	 * @return idName  
	 */
	public String getIdName() {
		return idName;
	}

	/**  
	 * @param paramtheparamthe{bare_field_name} to set  
	 */
	public void setIdName(String idName) {
		this.idName = idName;
	}

	/**  
	 * @return modelClass  
	 */
	public Class<?> getModelClass() {
		return modelClass;
	}

	/**  
	 * @param paramtheparamthe{bare_field_name} to set  
	 */
	public void setModelClass(Class<?> modelClass) {
		this.modelClass = modelClass;
	}

	@Override
	public String toString() {
		return "JfmvcModel [tableName=" + tableName + ", idName=" + idName
				+ ", modelClass=" + modelClass + "]";
	}
}
