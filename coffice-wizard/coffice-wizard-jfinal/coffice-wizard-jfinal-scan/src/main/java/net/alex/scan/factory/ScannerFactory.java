/*
 * Copyright (c) 2017, Li Bo/Alex All rights reserved.
 * 
 * http://blog.sina.com.cn/alex4java
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
 
package net.alex.scan.factory;

import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;

import net.alex.scan.adapter.ScanAdapter;
import net.alex.scan.error.ScanException;
import net.alex.scan.model.ScanConfigure;
import net.alex.scan.scanner.Scanner;

/**
 * @ClassName: ScannerFactory
 * @Description: Scanner构建工厂 ：用于构建Scanner扫描器的方法工厂类
 * @author: 李博/Alex
 * @date: 2017-2-27 下午6:04:36
 * @email:  alexlibochn@china-pui.com.cn
 */
public final class ScannerFactory {

	/**
	 * @fieldName: logger
	 * @fieldType: Logger
	 * @Description: 日志输出器
	 */
	private static final Logger logger = Logger.getLogger(ScannerFactory.class);
	/**
	 * @fieldName: scanConfigure
	 * @fieldType: ScanConfigure
	 * @Description: 文件扫描配置对象
	 */
	private ScanConfigure scanConfigure;
	
	/**
	 * @fieldName: scannerFactory
	 * @fieldType: ScannerFactory
	 * @Description: 单例对象
	 */
	private static ScannerFactory scannerFactory = new ScannerFactory();
	
	/**
	 * @Title: getInstance
	 * @Description: 调用实例对象   单例
	 * @return
	 * @return: ScannerFactory
	 */
	
	/*************************************单例模式******************************************/	
	
	public static ScannerFactory getInstance(){ return scannerFactory; } 
	
	
	public void setScanConfigure(ScanConfigure scanConfigure) {
		this.scanConfigure = scanConfigure;
	}

	
	/*************************************构造方法******************************************/	
	
	private ScannerFactory(){}

	
	public ScannerFactory(ScanConfigure scanConfigure) {
		this.scanConfigure = scanConfigure;
	}
	
	/********************************构造运行Annotation*****************************/	

	/**
	 * @Title: runWithAnnotation
	 * @Description: 运行annotation加载扫描服务
	 * @param clazz
	 * @return
	 * @return: ScannerFactory
	 */
	public ScannerFactory runWithAnnotation(Class clazz)
	{
		try {
			if(!ScanAdapter.runWithAnnotation(clazz)){
				throw new RuntimeException("运行注解扫描器加载扫描服务失败!");
			}
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	/********************************构造Scanner扫描器方法*****************************/	

	
	/**
	 * @Title: createScanner
	 * @Description: TODO
	 * @return
	 * @return: Scanner
	 * @throws ScanException 
	 */
	@SuppressWarnings("deprecation")
	public Scanner createScanner() throws ScanException{
		
		synchronized(this){
			return new Scanner();
		}
		//if(this.scanConfigure == null)
			//throw new ScanException("扫描对象ScanConfigure对象未知的或者为空,请赋值ScanConfigure对象~!");
	}
}
