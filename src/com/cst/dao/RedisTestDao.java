package com.cst.dao;

import com.cst.model.TestUser;

public interface RedisTestDao {

	public boolean saveUser(TestUser user);

	public TestUser listAllUsers(String keyId);
}
