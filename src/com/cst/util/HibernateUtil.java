/** 
 * 文 件 名 : HibernateUtil.java
 * 版权：CopyRright (c) 2008-xxxx: 
 * 描述： 
 * 修改人： crazylion
 * 修改时间： 2013年8月4日
 * 跟踪单号： 
 * 修改单号： 
 * 修改内容： 
 */
package com.cst.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author crazylion
 * 
 */
public class HibernateUtil
{
	private static SessionFactory sessionFactory;
	static
	{
		try
		{
			sessionFactory = new Configuration().configure("/config/hibernate.cfg.xml").buildSessionFactory();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
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
