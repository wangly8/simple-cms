/** 
 * 文 件 名 : UserDao.java
 * 版权：CopyRright (c) 2008-xxxx: 
 * 描述： 
 * 修改人： crazylion
 * 修改时间： 2013年8月4日
 * 跟踪单号： 
 * 修改单号： 
 * 修改内容： 
 */
package com.cst.dao;

import java.util.List;

import com.cst.model.User;

/**
 * @author crazylion
 * 
 */
public interface UserDao
{
	public void saveUser(User user);

	public List<User> listAllUsers();

	public void removeUser(Integer id);

	public User getSingleUserById(Integer id);

	public void updateUser(User user);
}
