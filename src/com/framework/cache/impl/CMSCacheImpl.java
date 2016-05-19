package com.framework.cache.impl;

import org.apache.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;

import com.framework.cache.CMSCache;

/**
 * 
 * @author wangluyang
 *
 */
public class CMSCacheImpl implements CMSCache{

	private final static Logger logger = Logger.getLogger(CMSCacheImpl.class);
	private RedisTemplate template;
	private String systemKey;
	
	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void put(Object key, Object value) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void put(Object key, Object value, boolean eternal) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void put(Object key, Object value, Integer timeToIdleSeconds, Integer timeToLiveSeconds) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void remove(Object key) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
