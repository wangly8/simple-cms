/** 
 * 文 件 名 : UsersService.java
 * 版权：CopyRright (c) 2008-xxxx: 
 * 描述： 
 * 修改人： crazylion
 * 修改时间： 2013年7月14日
 * 跟踪单号： 
 * 修改单号： 
 * 修改内容： 
 */ 
package com.cst.service;

import java.util.List;

import com.cst.model.TestUser;
import com.cst.model.User;

/**
 * @author crazylion
 *
 */
public interface UserService
{
	public void saveUser(User user);
	
	public List<User> listAllUsers();
	
	public void removeUser(Integer id);
	
	public User getSingleUserById(Integer id);
	
	public void updateUser(User user);
	
	public boolean saveTestUser(TestUser user);
	
	public TestUser getTestUser(String keyId);
}
