/** 
 * 文 件 名 : RoleDao.java
 * 版权：CopyRright (c) 2008-xxxx: 
 * 描述： 
 * 修改人： crazylion
 * 修改时间： 2013年8月6日
 * 跟踪单号： 
 * 修改单号： 
 * 修改内容： 
 */ 
package com.cst.dao;

import java.util.List;

import com.cst.model.Role;

/**
 * @author crazylion
 *
 */
public interface RoleDao
{
	public void saveRole(Role role);
	
	public List<Role> listAllRoles();
	
	public Role getSingleRoleById(int id);
	
	public void updateRole(Role role);
	
	public void deleteRole(int id);
}
