package com.cst.daoImpl;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import com.cst.dao.AbstractBaseRedisDao;
import com.cst.dao.RedisTestDao;
import com.cst.model.TestUser;

@Component("redisTestDaoImpl")
public class RedisTestDaoImpl extends AbstractBaseRedisDao<String, TestUser> implements RedisTestDao {

	@Override
	public boolean saveUser(final TestUser user) {
		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] key  = serializer.serialize(user.getId());
                byte[] name = serializer.serialize(user.getName());
                return connection.setNX(key, name);
            }
        });
        return result;
	}

	@Override
	public TestUser listAllUsers(final String keyId) {
		TestUser result = redisTemplate.execute(new RedisCallback<TestUser>() {
	            public TestUser doInRedis(RedisConnection connection)
	                    throws DataAccessException {
	                RedisSerializer<String> serializer = getRedisSerializer();
	                byte[] key = serializer.serialize(keyId);
	                byte[] value = connection.get(key);
	                if (value == null) {
	                    return null;
	                }
	                String name = serializer.deserialize(value);
	                return new TestUser(keyId, name, null);
	            }
	        });
	        return result;
	}
}
