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

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cst.model.AmcInvoiceLog;
import com.cst.model.Permission;
import com.cst.service.PermissionService;
import com.cst.util.HibernateUtil;

/**
 * @author crazylion
 *
 */
@Service("permissionServiceImpl")
@Repository
public class PermissionServiceImpl extends BaseServiceImpl implements PermissionService
{
	
	@Override
	public void addPermission(Permission permission) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePermission(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePermission(Permission permission) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Permission getPermissionById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Permission> listAllPermissions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AmcInvoiceLog> listAllInvoiceLog() {
		// TODO Auto-generated method stub
		List<AmcInvoiceLog> result = null;
		try {
			result = baseDao.getList(AmcInvoiceLog.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
