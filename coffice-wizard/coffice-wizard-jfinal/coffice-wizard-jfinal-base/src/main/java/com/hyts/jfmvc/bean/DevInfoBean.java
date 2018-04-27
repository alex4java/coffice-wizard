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

/**
 * @ClassName: DevInfoBean
 * @Description: DevInfoBean 开发人员模型类，用于返回
 * 				 DevInfoBean 开发人员基本信息：以及版本信息
 * @author: LiBo/Alex Lee
 * @date: 2017年9月22日 下午4:03:32
 * @email: alexlibochn@china-pui.com.cn/alex.link@foxmail.com
 */
public class DevInfoBean implements Serializable {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 序列号
	 */
	private static final long serialVersionUID = -1840698952110295904L;

	/**
	 * @fieldName: devVersion
	 * @fieldType: String
	 * @Description: JOffice系统服务框架版本
	 */
	private String devVersion;
	
	/**
	 * @fieldName: devChinaName
	 * @fieldType: String
	 * @Description: 开发者中文名
	 */
	private String devChinaName;
	
	/**
	 * @fieldName: devEnglishName
	 * @fieldType: String
	 * @Description: 开发者英文名
	 */
	private String devEnglishName;
	
	/**
	 * @fieldName: devEmail
	 * @fieldType: String
	 * @Description: 开发者电子邮件
	 */
	private String devEmail;
	
	/**
	 * @fieldName: devTelephone
	 * @fieldType: String
	 * @Description: 开发者手机号
	 */
	private String devTelephone;
	
	/**
	 * @fieldName: devHomePage
	 * @fieldType: String
	 * @Description: 开发者主页
	 */
	private String devHomePage;

	/**
	 * @return the devVersion
	 */
	public String getDevVersion() {
		return devVersion;
	}

	/**
	 * @param devVersion the devVersion to set
	 */
	public void setDevVersion(String devVersion) {
		this.devVersion = devVersion;
	}

	/**
	 * @return the devChinaName
	 */
	public String getDevChinaName() {
		return devChinaName;
	}

	/**
	 * @param devChinaName the devChinaName to set
	 */
	public void setDevChinaName(String devChinaName) {
		this.devChinaName = devChinaName;
	}

	/**
	 * @return the devEnglishName
	 */
	public String getDevEnglishName() {
		return devEnglishName;
	}

	/**
	 * @param devEnglishName the devEnglishName to set
	 */
	public void setDevEnglishName(String devEnglishName) {
		this.devEnglishName = devEnglishName;
	}

	/**
	 * @return the devEmail
	 */
	public String getDevEmail() {
		return devEmail;
	}

	/**
	 * @param devEmail the devEmail to set
	 */
	public void setDevEmail(String devEmail) {
		this.devEmail = devEmail;
	}

	/**
	 * @return the devTelephone
	 */
	public String getDevTelephone() {
		return devTelephone;
	}

	/**
	 * @param devTelephone the devTelephone to set
	 */
	public void setDevTelephone(String devTelephone) {
		this.devTelephone = devTelephone;
	}

	/**
	 * @return the devHomePage
	 */
	public String getDevHomePage() {
		return devHomePage;
	}

	/**
	 * @param devHomePage the devHomePage to set
	 */
	public void setDevHomePage(String devHomePage) {
		this.devHomePage = devHomePage;
	}

	/* (non Javadoc)
	 * @Title: toString
	 * @Description: TODO
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DevInfoBean [devVersion=" + devVersion + ", devChinaName=" + devChinaName
				+ ", devEnglishName=" + devEnglishName + ", devEmail=" + devEmail + ", devTelephone=" + devTelephone
				+ ", devHomePage=" + devHomePage + "]";
	}
}
