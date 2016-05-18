/** 
 * 文 件 名 : UserDaoImpl.java
 * 版权：CopyRright (c) 2008-xxxx: 
 * 描述： 
 * 修改人： crazylion
 * 修改时间： 2013年8月4日
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

import com.cst.dao.UserDao;
import com.cst.model.User;
import com.cst.util.HibernateUtil;

/**
 * @author crazylion
 * 
 */
@Component("userDaoImpl")
public class UserDaoImpl implements UserDao
{
	@Override
	public void saveUser(User user)
	{
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		try
		{
			session.save(user);
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
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listAllUsers()
	{
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		List<User> list = null;
		try
		{
			// HQL语句,select *可省略
			// 即为默认情况。User为类名(不是表名)，若同名则加上包名
			Query query = session.createQuery("from User");
			list = (List<User>) query.list();
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
	public void removeUser(Integer id)
	{
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		try
		{
			User user = (User) session.get(User.class, id);
			session.delete(user);
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
	}

	@Override
	public User getSingleUserById(Integer id)
	{
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		User user = null;
		try
		{
			user = (User) session.get(User.class, id);
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
		
		return user;
	}

	@Override
	public void updateUser(User user)
	{
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		try
		{
			session.update(user);
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
	}
}
