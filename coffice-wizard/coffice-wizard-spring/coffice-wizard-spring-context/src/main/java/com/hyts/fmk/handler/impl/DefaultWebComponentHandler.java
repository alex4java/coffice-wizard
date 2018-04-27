package com.hyts.fmk.handler.impl;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.hyts.fmk.base.BaseWebModel;
import com.hyts.fmk.config.ModelTypeEnum;
import com.hyts.fmk.handler.WebComponentHandler;

import javax.servlet.Filter;
import javax.servlet.http.HttpServlet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * project-name:hyts-framework
 * package-name:com.hyts.fmk.handler.impl
 * author:Libo/Alex
 * create-date:2017-11-21 17:20
 * copyright:libo-hyts-github
 * email:libo2dev@aliyun.com
 * description:此类主要用于:默认webComponent操作的实现服务绑定操作
 */
@Singleton
public final class DefaultWebComponentHandler extends WebComponentHandler{


    /**
     * field-name:baseModelList
     * field-type:List<BaseWebModel>
     * description:基础Web组件模型类
     */
    private static List<BaseWebModel> baseModelList;

    /**
     * author:Alex/Libo
     * create-date:2017/11/21
     * create-time:17:22
     * method-name:registerServlet
     * param: servletName servletClass mapping
     * return: 结果空
     * description: 注册servlet组件
     */
    @Override
    public void registerServlet(String servletName, Class<? extends HttpServlet> servletClass, String mapping,Integer onStart)
    {
        if(baseModelList == null)
        {
            baseModelList = new LinkedList<BaseWebModel>();
        }
        //修改基础模型web组件类
        if(onStart == null)
        {
            baseModelList.add(new BaseWebModel(servletName, ModelTypeEnum.SERVLET,servletClass,mapping));
        }
        else
        {
            baseModelList.add(new BaseWebModel(servletName,ModelTypeEnum.SERVLET,servletClass,mapping,onStart));
        }
    }

    /**
     * author:Alex/Libo
     * create-date:2017/11/21
     * create-time:17:27
     * method-name:registerFilter
     * param: filterName filterClass mapping
     * return:
     * description: 注册Filter组件
     */
    @Override
    public void registerFilter(String filterName, Class<? extends Filter> filterClass, String mapping,Map<String,String> initInfo) {
        if(baseModelList == null)
        {
            baseModelList = new LinkedList<BaseWebModel>();
        }
        //修改基础模型web组件类
        baseModelList.add(new BaseWebModel(filterName, ModelTypeEnum.FILTER,filterClass,mapping,initInfo));
        
    }

    /**
     * author:Alex/Libo
     * create-date:2017/11/21
     * create-time:17:27
     * method-name: registerListener
     * param:listener
     * return:
     * description:注册Listener
     */
    @Override
    public <T> void registerListener(Class<T> listener) {
        if(baseModelList == null)
        {
            baseModelList = new LinkedList<BaseWebModel>();
        }
        //修改基础模型web组件类
        baseModelList.add(new BaseWebModel(ModelTypeEnum.LISTENER,listener));
    }

    public static List<BaseWebModel> getBaseModelList() {
        return baseModelList;
    }


    /**
     * author:Alex/Libo
     * create-date:2017/11/22
     * create-time:15:46
     * method-name:DefaultWebComponentHandler
     * param:
     * return: DefaultWebComponentHandler对象
     * description: 获取全局单例模式对象
     */
    public static DefaultWebComponentHandler getInstance()
    {
        Injector injector = Guice.createInjector(new BaseWebModel());
        return injector.getInstance(DefaultWebComponentHandler.class);
    }
}
