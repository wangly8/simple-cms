/** 
 * 文 件 名 : PermissionDao.java
 * 版权：CopyRright (c) 2008-xxxx: 
 * 描述： 
 * 修改人： crazylion
 * 修改时间： 2013年8月9日
 * 跟踪单号： 
 * 修改单号： 
 * 修改内容： 
 */ 
package com.cst.dao;

import java.util.List;

import com.cst.model.Permission;

/**
 * @author crazylion
 *
 */
public interface PermissionDao
{
	public void addPermission(Permission permission);
	
	public void deletePermission(int id);
	
	public void updatePermission(Permission permission);
	
	public List<Permission> listAllPermissions();
	
	public Permission getSinglePermissionById(int id);
}
