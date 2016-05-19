package com.framework.cache.impl;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.framework.cache.CMSCache;

/**
 * 
 * @author wangluyang
 *
 */
public class CMSCacheRedis implements CMSCache{

	private final static Logger logger = Logger.getLogger(CMSCacheRedis.class);
	private RedisTemplate template;
	private String systemKey;
	
	@Override
	public Object get(Object key) { 
		// TODO Auto-generated method stub
		logger.info("redis get key=" + key);
		HashOperations voper = this.template.opsForHash();
		Object value = voper.get(systemKey,key);
		return value;
	}
	@Override
	public void put(Object key, Object value, boolean eternal) {
		logger.info("redis put key=" + key + " value=" + value.toString());
		HashOperations voper = this.template.opsForHash();
		value = voper.get(systemKey,key);
	}

	@Override
	public void put(Object key, Object value, Integer timeToIdleSeconds,
			Integer timeToLiveSeconds) {
		logger.info("redis put key=" + key + " value=" + value.toString());
		ValueOperations<Object,Object> voper = this.template.opsForValue();
		voper.set(key, value, timeToIdleSeconds);
	}

	@Override
	public void put(Object key, Object value) {
		logger.info("redis put key=" + key + " value=" + value.toString());
		HashOperations voper = this.template.opsForHash();
		voper.put(systemKey,key,value);
	}

	@Override
	public void remove(Object key) {
		logger.info("redis remove key=" + key);
		HashOperations voper = this.template.opsForHash();
		voper.delete(systemKey,key);
	}

	@Override
	public void removeAll() {
		logger.info("redis removeAll");
		HashOperations voper = this.template.opsForHash();
		Set<String> keys = voper.keys(systemKey);
		logger.info(keys);
		if(!keys.isEmpty()){
			for(Object key:keys){
				voper.delete(systemKey,key);
			}
		}
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	public RedisTemplate getTemplate() {
		return template;
	}
	public void setTemplate(RedisTemplate template) {
		this.template = template;
	}
	public String getSystemKey() {
		return systemKey;
	}
	public void setSystemKey(String systemKey) {
		this.systemKey = systemKey;
	}
}
