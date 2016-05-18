package com.cst.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * 
* @ClassName: AbstractBaseRedisDao
* @Description: TODO
* @author wangly
* @date 2016年5月17日 下午10:19:44
*
* @param <K>SS
* @param <V>
 */
public abstract class AbstractBaseRedisDao<K,V> {

    @Autowired
    protected RedisTemplate<K, V> redisTemplate;

//    /**
//	 * 设置redisTemplate
//	 * @param redisTemplate the redisTemplate to set
//	 */
//	public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
//		this.redisTemplate = redisTemplate;
//	}
//    
    protected RedisSerializer<String> getRedisSerializer() {
        return redisTemplate.getStringSerializer();
    }

}
