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
package com.hyts.jfmvc.scan.scanner;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import net.alex.scan.error.ScanException;
import net.alex.scan.factory.ScannerFactory;
import net.alex.scan.model.ScanResultInvoke;
import net.alex.scan.scanner.Scanner;

import org.apache.log4j.Logger;

import com.hyts.jfmvc.scan.adapter.ScannerAdapter;
import com.hyts.jfmvc.scan.annotation.Resource;
import com.hyts.jfmvc.scan.handler.JfmvcScanHandler;


/**  
 * @Title JfmvcScanner.java  
 * @Package com.hyts.jfmvc.scan.scanner  
 * @Description JfmvcScanner服务加载操作  
 * @author LiBo/Alex  
 * @date 2017年10月27日  
 * @version V1.0  
 */
public final class JfmvcScanner {
	
	/**  
	 * @Fields field:field:日志输出器  
	 */ 
	private static final Logger logger = Logger.getLogger(JfmvcScanner.class);
	/**  
	 * @Title: scan  
	 * @Description: 扫描 
	 * @param @param clazzName
	 * @param @return    参数  
	 * @return     返回类型  
	 * @throws  
	 */ 
	public static void scan(String clazzName)
	{
		Scanner scanner;
		try {
			scanner = ScannerFactory.getInstance().runWithAnnotation(Class.forName(clazzName))
					.createScanner();
			Object [] obj2 = 
					scanner.scan().toArray();
			for(Object obj :obj2)
			{
				ScanResultInvoke inv = (ScanResultInvoke)obj;
					logger.info("[hyts-jfmvc-scan] --- [扫描架构] --- "+inv.getClassEntity()+"----->"+inv.getAnnotation()+"---->"+inv.getAnnotationData());
					//构建路由
					JfmvcScanHandler.getInstance().handlerAnnotationByRoute(inv);
					logger.info("[hyts-jfmvc-scan] --- [扫描架构] --- 开始扫描依赖所有Controller控制器中的注入注解Resource的依赖关系进行绑定");
					//构建依赖
					JfmvcScanHandler.getInstance().handlerAnnotationByService(inv);//构建Service注解
					JfmvcScanHandler.getInstance().handlerAnnotationByResource(inv);//构建Resource注解
					JfmvcScanHandler.getInstance().handlerAnnotationByRepository(inv);//构建Repository注解
					//构建ORM对象映射：操作数据库持久化服务
					JfmvcScanHandler.getInstance().handlerAnnotationByModel(inv);
			}
		} catch (ScanException | ClassNotFoundException | IOException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
			e1.printStackTrace();
		} 
	}
	
	/**  
	 * @Title: scan  
	 * @Description: 扫描  
	 * @param @param clazz
	 * @param @return    参数  
	 * @return     返回类型  
	 * @throws  
	 */ 
	public static void scan(Class clazz)
	{
		Scanner scanner;
		try {
			scanner = ScannerFactory.getInstance().runWithAnnotation(clazz)
					.createScanner();
			Object [] obj2 = 
					scanner.scan().toArray();
			for(Object obj :obj2)
			{
				ScanResultInvoke inv = (ScanResultInvoke)obj;
					logger.info("[hyts-jfmvc-scan] --- [扫描架构] --- "+inv.getClassEntity()+"----->"+inv.getAnnotation()+"---->"+inv.getAnnotationData());
					//构建路由
					JfmvcScanHandler.getInstance().handlerAnnotationByRoute(inv);
					logger.info("[hyts-jfmvc-scan] --- [扫描架构] --- 开始扫描依赖所有Controller控制器中的注入注解Resource的依赖关系进行绑定");
					//构建依赖
					JfmvcScanHandler.getInstance().handlerAnnotationByService(inv);//构建Service注解
					JfmvcScanHandler.getInstance().handlerAnnotationByResource(inv);//构建Resource注解
					JfmvcScanHandler.getInstance().handlerAnnotationByRepository(inv);//构建Repository注解
					//构建ORM对象映射：操作数据库持久化服务
					JfmvcScanHandler.getInstance().handlerAnnotationByModel(inv);
			}
		} catch (ScanException | ClassNotFoundException | IOException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
			e1.printStackTrace();
		} 
	}
	
}
