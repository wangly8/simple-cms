/** 
 * 文 件 名 : PermissionDaoImpl.java
 * 版权：CopyRright (c) 2008-xxxx: 
 * 描述： 
 * 修改人： crazylion
 * 修改时间： 2013年8月9日
 * 跟踪单号： 
 * 修改单号： 
 * 修改内容： 
 */ 
package com.cst.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.cst.dao.PermissionDao;
import com.cst.model.Permission;
import com.cst.util.HibernateUtil;

/**
 * @author crazylion
 *
 */
@Component("permissionDaoImpl")
public class PermissionDaoImpl implements PermissionDao
{
	@Override
	public void addPermission(Permission permission)
	{
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		try
		{
			session.save(permission);
			tx.commit();
		}
		catch (Exception e)
		{
			if(null != tx)
			{
				tx.rollback();
			}
		}
		finally
		{
			HibernateUtil.close(session);
		}
	}

	@Override
	public void deletePermission(int id)
	{
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		try
		{
			Permission permission = (Permission) session.get(Permission.class, id);
			session.delete(permission);
			tx.commit();
		}
		catch (Exception e)
		{
			if(null != tx)
			{
				tx.rollback();
			}
		}
		finally
		{
			HibernateUtil.close(session);
		}
		
	}

	@Override
	public void updatePermission(Permission permission)
	{
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		try
		{
			session.update(permission);
			tx.commit();
		}
		catch (Exception e)
		{
			if(null != tx)
			{
				tx.rollback();
			}
		}
		finally
		{
			HibernateUtil.close(session);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Permission> listAllPermissions()
	{
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		List<Permission> list = null;
		
		try
		{
			Query query = session.createQuery("from Permission");
			list = (List<Permission>) query.list();
			tx.commit();
		}
		catch (Exception e)
		{
			if (null != tx)
			{
				tx.rollback();
			}
		}
		finally
		{
			HibernateUtil.close(session);
		}
		return list;
	}

	@Override
	public Permission getSinglePermissionById(int id)
	{
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Permission permission = null;
		
		try
		{
			permission = (Permission) session.get(Permission.class, id);
			tx.commit();
		}
		catch (Exception e)
		{
			if(null != tx)
			{
				tx.rollback();
			}
		}
		finally
		{
			HibernateUtil.close(session);
		}
		
		return permission;
	}

}
