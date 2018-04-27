/*
 * Copyright (c) 2017, Li Bo/Alex Lee All rights reserved.
 * 
 * http://www.libo4dream.club/
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
 
package net.alex.scan.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: ExcludePackages
 * @Description: TODO
 * @author: LiBo/Alex Lee
 * @date: 2017年10月6日 上午12:54:10
 * @email: alexlibochn@china-pui.com.cn/alex.link@foxmail.com
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Target({ElementType.TYPE})
public @interface ExcludePackages {
	
	/**
	 * @Title: packagePaths
	 * @Description: 包路径集合
	 * @return
	 * @return: String[]
	 */
	public String[] packagePaths()  default "";
	
	
}
