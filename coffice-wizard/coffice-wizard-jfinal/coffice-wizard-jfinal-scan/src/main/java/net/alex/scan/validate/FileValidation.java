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
 
package net.alex.scan.validate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import net.alex.scan.config.Config;
import net.alex.scan.error.ScanException;
import net.alex.scan.tool.PathUtils;
import net.alex.scan.tool.ScanUtils;
import net.alex.scan.tool.StringUtils;

/**
 * @ClassName: FileValidation
 * @Description: 文件类型以及文件操作方式、文件包含重叠的校验
 * @author: 李博/Alex
 * @date: 2017-3-1 上午9:19:10
 * @email:  alexlibochn@china-pui.com.cn
 */
public final class FileValidation {
	
	
	/**
	 * @Title: clearRepeatPackage
	 * @Description: 去除设置的扫描包中重复的包名称
	 * @param packagePath
	 * @return
	 * @return: String[]
	 */
	public static String[] clearRepeatPackage(String [] packagePath){
		
		List<String> tempList = new LinkedList<String>();
		
		for(int index = 0 ; index < packagePath.length ; index++){
			String currentValue = packagePath[index];
			int count = 0;
			for(int cursor = index+1 ; cursor < packagePath.length ;cursor++){
				
				if(packagePath[cursor].equals(currentValue)){
					continue;
				}
				else 
				{
					count++;
				}
				if(count == packagePath.length - index - 1){
					tempList.add(currentValue);
				}
			}
		}
		tempList.add(packagePath[packagePath.length-1]);
		return tempList.toArray(new String[]{});
	}
	
	/**
	 * @Title: clearContainOrCrossPackage
	 * @Description: 清除属于包含 交叉关系的包 切进行合并成为一个包进行扫描
	 * @param packagePath
	 * @return
	 * @return: boolean
	 * @throws ScanException 
	 */
	public static String[] clearContainOrCrossPackage(String[] packagePaths) throws ScanException{
		
		if(packagePaths.length == 1)
			return packagePaths;
		
		//String[][] packageArray = new String[packagePaths.length][Config.SYSTEM_DEFAULT_MAX_PACKAGE_LEVEL];
		List<String[]> elementList = new ArrayList<String[]>();
		
		List<String> resultSet = new ArrayList<String>();
		
		for(String packageName:packagePaths){
			elementList.add(packageName.split("\\."));
		}
		//进行长度大小的排序操作
		Collections.sort(elementList, new Comparator(){
			@Override
			public int compare(Object o1, Object o2) {
				if(o1 instanceof String[] && o2 instanceof String[]){
					String[] tmp1 = (String[]) o1;
					String[] tmp2 = (String[]) o2;
					if(tmp1.length < tmp2.length){
						return 1;
					}
					else
					{
						return -1;
					}
				}
				return 0;
			}
		});
		
		//因为数组是顺序的加载方式，所以不用在意是否由于顺序导致的误差
		
/*		String[] baseElement = null;
		baseElement = elementList.get(0);
		for(int i = 1 ; i<elementList.size();i++){
			//指针
			//int firstCursor = 0,secondCursor = 0;
			if(baseElement.length < elementList.get(i).length){
				//此处无法利用正则表达式 因为有顺序方面的问题和包重名的问题
				for(int k = 0,j = 0 ; k < baseElement.length; k++,j++){
					//String tepElement = baseElement[k];
					//for(int j = k ; j < elementList.get(i).length;j++){
						if(baseElement[k].equals(elementList.get(i)[j])){
							if(k == j)
								break;
						}
						else
						{
							//baseElement = elementList.get(i);
							resultSet.add(StringUtils.join(baseElement, "."));
						}
					//}
				}
			}
			
			else if(baseElement.length == elementList.get(i).length)
			{
				
			}
		}*/
		
		String [] rootPackage = new String[elementList.size()];//相对的根包
		
		//rootPackage[0] = elementList.get(0)[0];
		
		for(int i = 0 ; i<elementList.size();i++){
			
			if(!isParentPackage(elementList.get(i),elementList.get(i+1))){
				
			}
		}
		return resultSet.toArray(new String[]{});
	}
	
	
	/**
	 * @Title: isParentPackage
	 * @Description: 判断是否属于父亲包级别
	 * @param parentPackage
	 * @param childPackage
	 * @return
	 * @return: boolean
	 * @throws ScanException 
	 */
	private static boolean isParentPackage(String[] parentPackage,String[] childPackage) throws ScanException{
		return StringUtils.join(childPackage, "-").startsWith(StringUtils.join(parentPackage,"-"));
	}
	
	public static void main(String[] args) {
		String[] str = {"net.alex.bean","net.alex","net","net.alex.info","net.info"};
		try {
			System.out.println(Arrays.toString(clearContainOrCrossPackage(str)));
		} catch (ScanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
