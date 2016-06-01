package com.cst.daoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cst.dao.BaseDao;
import com.cst.util.Page;

/**
 * 增删改查组件实现类
 * @author wangluyang
 *
 */
public class BaseDaoImpl extends HibernateDaoSupport implements BaseDao{

	@Override
	public <T> boolean save(T entity) throws Exception {
		// TODO Auto-generated method stub
		boolean bo = false;  
        try {  
            Serializable io = this.getHibernateTemplate().save(entity);  
            if (io != null) {  
                bo = true;  
            }  
        } catch (Exception e) {  
            bo = false;  
            throw new RuntimeException(e);  
        }  
        return bo; 
	}

	@Override
	public <T> Integer saveAndGetId4Integer(T entity) throws Exception {
		// TODO Auto-generated method stub
		 Integer id = null;  
	        try {  
	            id = (Integer) this.getHibernateTemplate().save(entity);  
	        } catch (Exception e) {  
	            throw new RuntimeException(e);  
	        }  
	        return id;  
	}

	@Override
	public <T> String saveAndGetId4String(T entity) throws Exception {
		// TODO Auto-generated method stub
		 String id = null;  
	        try {  
	            id = (String) this.getHibernateTemplate().save(entity);  
	        } catch (Exception e) {  
	            throw new RuntimeException(e);  
	        }  
	        return id;  
	}

	@Override
	public int executeByHql(String hql) throws Exception {
		// TODO Auto-generated method stub
		try {  
            return this.getHibernateTemplate().bulkUpdate(hql);           
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        } 
	}

	@Override
	public <T> List<T> findByHql(String hql) throws Exception {
		// TODO Auto-generated method stub
		List list = null;  
        try {  
            list = (List<T>) this.getHibernateTemplate().find(hql);  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
        return list; 
	}

	@Override
	public int executeBySql(String sql) throws Exception {
		// TODO Auto-generated method stub
		try {  
            return this.getSession().createSQLQuery(sql).executeUpdate();             
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }
	}

	@Override
	public <T> List<T> findBySql(String sql) throws Exception {
		// TODO Auto-generated method stub
		List list = null;  
        try {  
            list = (List<T>) this.getSession().createSQLQuery(sql).list();  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
        return list;
	}

	@Override
	public <T> boolean edit(T entity) throws Exception {
		// TODO Auto-generated method stub
		boolean bo = false;  
        try {  
            this.getHibernateTemplate().update(entity);  
            bo = true;  
        } catch (Exception e) {  
            bo = false;  
            throw new RuntimeException(e);  
        }  
        return bo; 
	}

	@Override
	public boolean edit(String hql) throws Exception {
		// TODO Auto-generated method stub
		 boolean bo = false;  
	        try {  
	            int count = this.getHibernateTemplate().bulkUpdate(hql);  
	            bo = count > 0 ? true : false;  
	        } catch (Exception e) {  
	            bo = false;  
	            throw new RuntimeException(e);  
	        }  
	        return bo;  
	}

	@Override
	public int editByHql(String hql) throws Exception {
		// TODO Auto-generated method stub
		int count = 0;  
        try {  
            count = this.getHibernateTemplate().bulkUpdate(hql);              
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
        return count;  
	}

	@Override
	public <T> boolean remove(T entity) throws Exception {
		// TODO Auto-generated method stub
		boolean bo = false;  
        try {  
            this.getHibernateTemplate().delete(entity);   
            bo = true;  
        } catch (Exception e) {  
            bo = false;  
            throw new RuntimeException(e);  
        }  
        return bo; 
	}

	@Override
	public <T> T getById(Class<T> c, String id) throws Exception {
		// TODO Auto-generated method stub
		T ety = null;  
        try {  
            ety = (T) this.getHibernateTemplate().get(c, id);             
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
        return ety; 
	}

	@Override
	public <T> T getById(Class<T> c, Integer id) throws Exception {
		// TODO Auto-generated method stub
		T ety = null;  
        try {  
            ety = (T) this.getHibernateTemplate().get(c, id);             
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
        return ety; 
	}

	@Override
	public <T> T get(Class<T> c, Serializable id) throws Exception {
		// TODO Auto-generated method stub
		T ety = null;  
        try {  
            ety = (T) this.getHibernateTemplate().get(c, id);             
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
        return ety; 
	}

	@Override
	public <T> T get(String hql) throws Exception {
		// TODO Auto-generated method stub
		T ety = null;  
        try {  
            ety = (T) this.getSession().createQuery(hql).setMaxResults(1).uniqueResult();         
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
        return ety;  
	}

	@Override
	public <T> List<T> getList(String hql) throws Exception {
		// TODO Auto-generated method stub
		List<T> list = null;  
        try {  
             list = (List<T>) this.getHibernateTemplate().find(hql);        
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
        return list;
	}

	@Override
	public boolean remove(String hql) throws Exception {
		// TODO Auto-generated method stub
		try {  
            return this.executeByHql(hql) > 0 ? true : false;  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        } 
	}

	@Override
	public <T> List<T> getList(Class<T> c) throws Exception {
		// TODO Auto-generated method stub
		List<T> list = null;  
        try {  
            this.getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(c));  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
        return list;
	}

	@Override
	public <T> List<T> getList(String hql, Object[] obj) throws Exception {
		// TODO Auto-generated method stub
		List<T> list = null;  
        try {  
             list = (List<T>) this.getHibernateTemplate().find(hql, obj);       
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
        return list;
	}

	@Override
	public List<?> showPage(String queryHql, String queryCountHql, int firstResult, int maxResult) throws Exception {
		// TODO Auto-generated method stub
		List<Object> list = new ArrayList<Object>();  
        try {  
            Session session = this.getSession();  
            list.add(session.createQuery(queryHql)  
                    .setFirstResult(firstResult).setMaxResults(maxResult).list());   
            list.add(session.createQuery(queryCountHql).setMaxResults(1).uniqueResult());  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
        return list;
	}

	@Override
	public <T> void showPage(String queryHql, String queryCountHql, Page<T> page) throws Exception {
		// TODO Auto-generated method stub
		try {  
            Session session = this.getSession();  
            page.setResult(session.createQuery(queryHql)  
                    .setFirstResult(page.getCurrentPage()).setMaxResults(page.getPageSize()).list());   
            page.setTotalsCount(Integer.parseInt(session.createQuery(queryCountHql).setMaxResults(1).uniqueResult().toString()));  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }
	}

	@Override
	public List<?> showPage(String queryCountHql, DetachedCriteria cResult, int firstResult, int maxResult)
			throws Exception {
		// TODO Auto-generated method stub
		List<Object> list = new ArrayList<Object>();  
        try {  
            Session session = this.getSession();  
            list.add(this.getHibernateTemplate().findByCriteria(cResult, firstResult, maxResult));   
            list.add(session.createQuery(queryCountHql).setMaxResults(1).uniqueResult());  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
        return list;
	}

	@Override
	public <T> void showPage(String queryCountHql, DetachedCriteria cResult, Page<T> page) throws Exception {
		// TODO Auto-generated method stub
		 try {  
	            Session session = this.getSession();  
	            page.setResult(this.getHibernateTemplate().findByCriteria(cResult, page.getCurrentPage(), page.getPageSize()));   
	            page.setTotalsCount(Integer.parseInt(session.createQuery(queryCountHql).setMaxResults(1).uniqueResult().toString()));  
	        } catch (Exception e) {  
	            throw new RuntimeException(e);  
	        }
	}

	@Override
	public <T> List<T> find(DetachedCriteria dc) throws Exception {
		// TODO Auto-generated method stub
		List<T> list = new ArrayList<T>();  
        try {  
            list = (List<T>) this.getHibernateTemplate().findByCriteria(dc);  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
        return list;
	}

	@Override
	public Session session() {
		// TODO Auto-generated method stub
		return this.getSession();
	}

	@Override
	public HibernateTemplate getTemplate() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate();
	}

	
}
