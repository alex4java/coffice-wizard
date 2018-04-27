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
package com.hyts.jfmvc.bind.injector;

import com.hyts.jfmvc.bind.base.BaseInjector;
import com.hyts.jfmvc.bind.domain.BindDomains;

/**  
 * @Title DefaultBootStrapInjector.java  
 * @Package com.hyts.bind.injector  
 * @Description 默认操作服务启动依赖注入操作控制器  
 * @author LiBo/Alex  
 * @date 2017年10月25日  
 * @version V1.0  
 */
public class DefaultClassInjector extends BaseInjector{
	
		/**  
		 * 创建一个新的实例-构造器 DefaultClassInjector.  
		 * @param domains  
		 */ 
		public DefaultClassInjector(BindDomains domains) {
			super();
			this.defaultBindDomains = domains;
		}

		/**  
		 * @Title: knit  
		 * @Description: 开始启动服务，依赖注入服务
		 * @param     参数  
		 * @return void 返回类型  
		 * @throws  
		 */ 
		public  void knit()
		{	
			BaseInjector.init();
		}
		
}
