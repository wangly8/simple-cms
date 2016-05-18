/** 
 * 文 件 名 : PermissionServiceImpl.java
 * 版权：CopyRright (c) 2008-xxxx: 
 * 描述： 
 * 修改人： crazylion
 * 修改时间： 2013年8月9日
 * 跟踪单号： 
 * 修改单号： 
 * 修改内容： 
 */ 
package com.cst.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cst.dao.PermissionDao;
import com.cst.model.Permission;
import com.cst.service.PermissionService;

/**
 * @author crazylion
 *
 */
@Service("permissionServiceImpl")
@Repository
public class PermissionServiceImpl implements PermissionService
{
	@Resource
	private PermissionDao permissionDao;
	
	public PermissionDao getPermissionDao()
	{
		return this.permissionDao;
	}
	
	public void setPermissionDao(PermissionDao permissionDao)
	{
		this.permissionDao = permissionDao;
	}
	
	@Override
	public void addPermission(Permission permission)
	{
		permissionDao.addPermission(permission);
	}

	@Override
	public void deletePermission(int id)
	{
		permissionDao.deletePermission(id);
	}

	@Override
	public void updatePermission(Permission permission)
	{
		permissionDao.updatePermission(permission);
	}

	@Override
	public Permission getPermissionById(int id)
	{
		return permissionDao.getSinglePermissionById(id);
	}

	@Override
	public List<Permission> listAllPermissions()
	{
		return permissionDao.listAllPermissions();
	}

}
