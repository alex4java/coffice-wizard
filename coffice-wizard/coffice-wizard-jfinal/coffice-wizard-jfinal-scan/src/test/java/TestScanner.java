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
 


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import net.alex.scan.annotation.IncludeAnnotations;
import net.alex.scan.annotation.IncludePackages;
import net.alex.scan.error.ScanException;
import net.alex.scan.factory.ScannerFactory;
import net.alex.scan.model.ScanResultInvoke;
import net.alex.scan.scanner.Scanner;

/*
 * @ClassName: TestScanner
 * @Description: TODO
 * @author: LiBo/Alex Lee
 * @date: 2017年10月6日 下午3:58:00
 * @email: alexlibochn@china-pui.com.cn/alex.link@foxmail.com
 */
@IncludePackages(packagePaths = {"net"})
@IncludeAnnotations(classPaths = {"com.hyts.jfmvc.scan.TestAnnotation1"})
public class TestScanner {

	
	  public static void main(String[] args) throws IOException, ClassNotFoundException, ScanException, IllegalAccessException, InvocationTargetException 
	{
		Scanner scanner = ScannerFactory.getInstance().runWithAnnotation(TestScanner.class)
				.createScanner();
		Object [] obj2 = 
				scanner.scan().toArray();
		for(Object obj :obj2)
		{
			ScanResultInvoke inv = (ScanResultInvoke)obj;
			System.out.println(inv.getClassEntity());
			try {
			} catch (IllegalArgumentException  e) {
				// TODO Auto-generated catch block runWithAnnotation(TestScanner.class).
				e.printStackTrace();
			} 
		}
	}
}
