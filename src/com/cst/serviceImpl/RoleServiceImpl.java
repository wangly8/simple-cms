/** 
 * 文 件 名 : RoleServiceImpl.java
 * 版权：CopyRright (c) 2008-xxxx: 
 * 描述： 
 * 修改人： crazylion
 * 修改时间： 2013年8月6日
 * 跟踪单号： 
 * 修改单号： 
 * 修改内容： 
 */ 
package com.cst.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cst.dao.RoleDao;
import com.cst.model.Role;
import com.cst.service.RoleService;

/**
 * @author crazylion
 *
 */
@Service("roleServiceImpl")
@Repository
public class RoleServiceImpl implements RoleService
{
	@Resource
	private RoleDao roleDao;

	public RoleDao getRoleDao()
	{
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao)
	{
		this.roleDao = roleDao;
	}

	@Override
	public void saveRole(Role role)
	{
		roleDao.saveRole(role);
	}

	@Override
	public void deleteRole(int id)
	{
		roleDao.deleteRole(id);
	}

	@Override
	public void updateRole(Role role)
	{
		roleDao.updateRole(role);
	}

	@Override
	public Role getSingleRoleById(int id)
	{
		return roleDao.getSingleRoleById(id);
	}

	@Override
	public List<Role> listAllRoles()
	{
		return roleDao.listAllRoles();
	}

}
