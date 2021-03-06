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
package com.hyts.jfmvc.web.component;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.alex.scan.annotation.IncludeAnnotations;

/**  
 * @Title FullScanComponent.java  
 * @Package com.hyts.jfmvc.web.component  
 * @Description 扫描系统中所有相关的服务注解-快捷类（Controller/Service/Entity/Repository） 
 * 				只需要继承此类即可
 * @author LiBo/Alex  
 * @date 2017年11月6日  
 * @version V1.0  
 */
@IncludeAnnotations(classPaths = {
	      "com.hyts.jfmvc.scan.annotation.Controller,"
	    + "com.hyts.jfmvc.scan.annotation.Service,"
	    + "com.hyts.jfmvc.scan.annotation.Entity,"
	    + "com.hyts.jfmvc.scan.annotation.Repository"})
public class FullScanComponent {

}
