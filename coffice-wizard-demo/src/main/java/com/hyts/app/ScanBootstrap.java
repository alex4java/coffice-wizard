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
package com.hyts.app;

import java.util.stream.Stream;

import net.alex.scan.annotation.IncludeAnnotations;
import net.alex.scan.annotation.IncludePackages;

import com.hyts.jfmvc.scan.annotation.AutoScanComponent;
import com.hyts.jfmvc.web.component.FullScanComponent;

/**
 * @Title ScanBootstrap.java
 * @Package com.hyts.app
 * @Description
 * 			<p>
 * 				 用于模仿SpringBoot扫描注解组件服务
 * 				用户只需要继承FullScanComponent类或者加入父注解：
 * 				AutoScanComponent,即可实现所有注解的扫描无需手动
 * 				配置，但因此减少了灵活性，作者推荐全部都启用，以防止
 * 				对象NPE的出现。因此用户只需要配置自己所需要扫描的
 * 				包@IncludePackages即可,配置IncludePackages的时候，
 * 				注意一定不要交叉，否则会出
 * 				现重复key的问题,所有一般配置一个全局外层根目录,即可
 * 			</p>
 * @author LiBo/Alex
 * @date 2017年10月27日
 * @version V1.0
 */
@IncludePackages(packagePaths = {"com.hyts.app"})
@AutoScanComponent
public class ScanBootstrap {
	
	
}
