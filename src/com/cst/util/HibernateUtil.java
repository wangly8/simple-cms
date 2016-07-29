package com.cst.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author wangluyang
 *
 */
@Repository
public class HibernateUtil
{
	private static SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		HibernateUtil.sessionFactory = sessionFactory;
	}

	public static Session openSession()
	{
		Session session = sessionFactory.openSession();
		return session;
	}

	public static void close(Session session)
	{
		if (null != session)
		{
			session.close();
		}
	}
}
