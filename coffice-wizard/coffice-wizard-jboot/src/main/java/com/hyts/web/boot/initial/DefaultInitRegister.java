package com.hyts.web.boot.initial;

import org.apache.log4j.Logger;

import com.hyts.fmk.base.InitRegister;

/**
 * project-name:hyts-framework
 * package-name:com.hyts.web.boot.initial
 * author:Libo/Alex
 * create-date:2017-11-22 16:07
 * copyright:libo-hyts-github
 * email:libo2dev@aliyun.com
 * description:此类主要用于:用于提供默认注册服务方法
 */

public class DefaultInitRegister implements InitRegister {

	final Logger logger = Logger.getLogger(DefaultInitRegister.class);
    
	@Override
    public void doRegister() {
        logger.info("系统没有选择任何初始化注册器，失败启动!");
    }

}
