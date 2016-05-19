package com.framework.cache;

import java.util.Map;

import org.springframework.beans.factory.FactoryBean;

/**
 * 
 * 创建FactoryBean
 * @author wangluyang
 *
 */
public class CacheFactoryBean implements FactoryBean<Object> {
	
	private Map<String,CMSCache> catcheDefinitions  ; 

	/**
	 * Spring中有两种类型的Bean，一种是普通Bean，另一种是工厂Bean，即FactoryBean。工厂Bean跟普通Bean不同，其返回的对象不是指定类的一个实例，其返回的是该工厂Bean的getObject方法所返回的对象。
	 */
	public Object getObject() throws Exception {
		return this.catcheDefinitions;
	}

	@SuppressWarnings("unchecked")
	public Class getObjectType() {
		return Map.class;
	}

	public boolean isSingleton() {
		return true;
	}

	public void setCatcheDefinitions(Map<String, CMSCache> catcheDefinitions) {
		this.catcheDefinitions = catcheDefinitions;
	}

}
