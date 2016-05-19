package com.framework.cache.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import com.framework.cache.SetCache;

/**
 * redis set缓存
 * @author wangluyang
 *
 */
public class SetCacheRedis{

	private RedisTemplate template;
	
	@Autowired
	public void setTemplate(RedisTemplate template) {
		this.template = template;
	}
	
	public void leftPush(String setKey, String value){
		ListOperations lop = this.template.opsForList();
		lop.leftPush(setKey, value);
	}
	
	public void rightPush(String setKey, String value){
		ListOperations lop = this.template.opsForList();
		lop.rightPush(setKey, value);
	}
}
