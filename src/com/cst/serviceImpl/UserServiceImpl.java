/** 
 * 文 件 名 : UsersServiceImpl.java
 * 版权：CopyRright (c) 2008-xxxx: 
 * 描述： 
 * 修改人： crazylion
 * 修改时间： 2013年7月14日
 * 跟踪单号： 
 * 修改单号： 
 * 修改内容： 
 */ 
package com.cst.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cst.dao.RedisTestDao;
import com.cst.dao.UserDao;
import com.cst.model.TestUser;
import com.cst.model.User;
import com.cst.service.UserService;

/**
 * @author crazylion
 *
 */
@Service("userServiceImpl")
@Repository
public class UserServiceImpl implements UserService
{
	@Resource
	private UserDao userDao;
	@Resource
	private RedisTestDao redisTestDao;
	
	public UserDao getUserDao()
	{
		return userDao;
	}
	
	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}
	
	@Override
	public void saveUser(User user)
	{
		userDao.saveUser(user);
	}

	@Override
	public List<User> listAllUsers()
	{
		return userDao.listAllUsers();
	}

	@Override
	public void removeUser(Integer id)
	{
		userDao.removeUser(id);
	}

	@Override
	public User getSingleUserById(Integer id)
	{
		return userDao.getSingleUserById(id);
	}

	@Override
	public void updateUser(User user)
	{
		userDao.updateUser(user);
	}

	@Override
	public boolean saveTestUser(TestUser user) {
		return redisTestDao.saveUser(user);
	}

	@Override
	public TestUser getTestUser(String keyId) {
		// TODO Auto-generated method stub
		return redisTestDao.listAllUsers(keyId);
	}

}
