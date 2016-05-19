package com.framework.cache.impl;

import java.util.Set;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;

import com.framework.cache.SetCache;

/**
 * redis set缓存
 * @author wangluyang
 *
 */
public class SetCacheRedis implements SetCache{

	private RedisTemplate template;
	
	@Override
	public void add(String keyId, Object value) {
		// TODO Auto-generated method stub
		SetOperations set = this.template.opsForSet();
		set.add(keyId, value);
	}

	@Override
	public Object pop(String keyId) {
		// TODO Auto-generated method stub
		SetOperations set = this.template.opsForSet();
		return set.pop(keyId);
	}

	@Override
	public long getSize(String keyId) {
		// TODO Auto-generated method stub
		SetOperations set = this.template.opsForSet();
		return set.size(keyId);
	}

	@Override
	public void remove(String keyId, Object value) {
		// TODO Auto-generated method stub
		SetOperations set = this.template.opsForSet();
		set.remove(keyId, value);
	}

	@Override
	public Set getSet(String keyId) {
		// TODO Auto-generated method stub
		SetOperations set = this.template.opsForSet();
		return set.members(keyId);
	}
	
	public RedisTemplate getTemplate() {
		return template;
	}

	public void setTemplate(RedisTemplate template) {
		this.template = template;
	}
}
