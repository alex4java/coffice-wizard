package com.hyts.fmk.base;

import java.util.Map;

import com.google.inject.AbstractModule;
import com.hyts.fmk.config.ModelTypeEnum;

/**
 * project-name:hyts-framework
 * package-name:com.hyts.fmk.base
 * author:Libo/Alex
 * create-date:2017-11-21 17:19
 * copyright:libo-hyts-github
 * email:libo2dev@aliyun.com
 * description:此类主要用于:为基础构建模型对象类
 */
public final class BaseWebModel extends AbstractModule {


    /**
     * @field-name:modelName
     * @field-type:String
     * @description: 模型名称
     */
     private String modelName;

    /**
     * field-name:a
     * field-type:A
     * description:模型类型
     */
     private ModelTypeEnum modelType;

    /**
     * field-name:a
     * field-type:A
     * description:a
     */
     private Class modelClazz;

    /**
     * field-name:a
     * field-type:A
     * description:a
     */
     private String mapping;

    /**
     * field-name:servletOnload
       field-type:int
     * description:servlet启动服务加载
     */
    private Integer servletOnload;
    
    
    private Map<String,String> initParamAndValue;


    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public ModelTypeEnum getModelType() {
        return modelType;
    }

    public void setModelType(ModelTypeEnum modelType) {
        this.modelType = modelType;
    }

    public Class getModelClazz() {
        return modelClazz;
    }

    public void setModelClazz(Class modelClazz) {
        this.modelClazz = modelClazz;
    }

    public String getMapping() {
        return mapping;
    }

    public void setMapping(String mapping) {
        this.mapping = mapping;
    }

    public BaseWebModel(String modelName, ModelTypeEnum modelType, Class modelClazz, String mapping) {
        this.modelName = modelName;
        this.modelType = modelType;
        this.modelClazz = modelClazz;
        this.mapping = mapping;
    }

    public BaseWebModel(ModelTypeEnum modelType, Class modelClazz) {
        this.modelType = modelType;
        this.modelClazz = modelClazz;
    }

    public BaseWebModel(String modelName, ModelTypeEnum modelType,Class modelClazz, String mapping, Integer servletOnload) {
        this.modelType = modelType;
        this.modelName = modelName;
        this.modelClazz = modelClazz;
        this.mapping = mapping;
        this.servletOnload = servletOnload;
    }
    
    public BaseWebModel(String modelName, ModelTypeEnum modelType,Class modelClazz, String mapping,Map<String,String>initParam) {
        this.modelType = modelType;
        this.modelName = modelName;
        this.modelClazz = modelClazz;
        this.mapping = mapping;
        this.initParamAndValue = initParam;
    }
    public Integer getServletOnload() {
        return servletOnload;
    }

    public void setServletOnload(Integer servletOnload) {
        this.servletOnload = servletOnload;
    }

    public BaseWebModel() {
    }

    @Override
    protected void configure() {

    }

	public void setInitParamAndValue(Map<String, String> initParamAndValue) {
		this.initParamAndValue = initParamAndValue;
	}

	public Map<String, String> getInitParamAndValue() {
		return initParamAndValue;
	}
    
	
}
