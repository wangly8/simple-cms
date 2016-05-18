/** 
 * 文 件 名 : RoleDaoImpl.java
 * 版权：CopyRright (c) 2008-xxxx: 
 * 描述： 
 * 修改人： crazylion
 * 修改时间： 2013年8月6日
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

import com.cst.dao.RoleDao;
import com.cst.model.Role;
import com.cst.util.HibernateUtil;

/**
 * @author crazylion
 *
 */
@Component("roleDaoImpl")
public class RoleDaoImpl implements RoleDao
{
	@Override
	public void saveRole(Role role)
	{
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		try
		{
			session.save(role);
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
	public List<Role> listAllRoles()
	{
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		List<Role> list = null;
		
		try
		{
			Query query = session.createQuery("from Role");
			list = (List<Role>) query.list();
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
		
		return list;
	}

	@Override
	public Role getSingleRoleById(int id)
	{
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Role role = null;
		
		try
		{
			role = (Role) session.get(Role.class, id);
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
		
		return role;
	}

	public void updateRole(Role role)
	{
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		try
		{
			session.update(role);
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
	public void deleteRole(int id)
	{
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		try
		{
			Role role = (Role) session.get(Role.class, id);
			session.delete(role);
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

}
