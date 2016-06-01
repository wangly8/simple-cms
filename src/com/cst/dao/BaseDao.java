package com.cst.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.cst.util.Page;

/**
 * 增删改查组件规范接口 
 * @author wangluyang
 *
 */
public interface BaseDao {
	
	/** 
     * <b>function:</b> 增加一个entity对象，返回是否添加成功 
     * @param <T> 对象类型 
     * @param entity 对象 
     * @return boolean true/false 
     * @throws Exception 
     */  
    public <T> boolean save(T entity) throws Exception;  
      
    /** 
     * <b>function:</b> 添加一个entity对象，返回添加对象的Integer类型的主键 
     * @param <T> 对象类型 
     * @param entity 将要添加的对象 
     * @return Integer 返回主键 
     * @throws Exception 
     */  
    public <T> Integer saveAndGetId4Integer(T entity) throws Exception;  
      
    /** 
     * <b>function:</b> 添加一个对象并且返回该对象的String类型的主键 
     * @createDate 2010-8-2 下午05:31:32 
     * @author hoojo 
     * @param <T> 对象类型 
     * @param entity 将要添加的对象 
     * @return String 返回的主键 
     * @throws Exception 
     */  
    public <T> String saveAndGetId4String(T entity) throws Exception;  
      
    /** 
     * <b>function:</b> 传入hql语句执行 
     * @param hql String hql语句 
     * @return int 影响行数 
     * @throws Exception 
     */  
    public int executeByHql(String hql) throws Exception;  
      
    /** 
     * <b>function:</b> 传入hql语句执行查询，返回list集合 
     * @param hql 查询的hql语句 
     * @return List集合 
     * @throws Exception 
     */  
    public <T> List<T> findByHql(String hql) throws Exception;  
      
    /** 
     * <b>function:</b> 执行原生态的sql语句，添加、删除、修改语句 
     * @param sql 将要执行的sql语句 
     * @return int 
     * @throws Exception 
     */  
    public int executeBySql(String sql) throws Exception;  
      
    /** 
     * <b>function:</b> 传入sql语句执行查询，返回list集合 
     * @param sql 查询的sql语句 
     * @return List集合 
     * @throws Exception 
     */  
    public <T> List<T> findBySql(String sql) throws Exception;  
      
    /** 
     * <b>function:</b> 修改entity对象，返回是否修改成功 
     * @param <T> 对象类型 
     * @param entity 将要修改的对象 
     * @return boolean true/false 是否修改成功 
     * @throws Exception 
     */  
    public <T> boolean edit(T entity) throws Exception;  
      
    /** 
     * <b>function:</b> 传入hql语句执行修改，返回是否修改成功 
     * @param hql 查询的hql语句 
     * @return boolean true/false 返回是否修改成功 
     * @throws Exception 
     */  
    public boolean edit(String hql) throws Exception;  
      
    /** 
     * <b>function:</b> 执行修改的hql语句，返回修改的行数 
     * @param hql 修改语句 
     * @return int 返回修改的行数 
     * @throws Exception 
     */  
    public int editByHql(String hql) throws Exception;  
      
    /** 
     * <b>function:</b> 传入一个将要删除的entity对象，返回删除是否成功 
     * @param <T> 传入对象类型 
     * @param entity 将要传入的对象 
     * @return boolean true/false 
     * @throws Exception 
     */  
    public <T> boolean remove(T entity) throws Exception;  
      
    /** 
     * <b>function:</b> 传入一个entity对象Class和String型主键，返回该对象 
     * @param <T> 返回、传入对象类型 
     * @param c 对象Class 
     * @param id 主键 
     * @return T 返回传入类型对象 
     * @throws Exception 
     */  
    public <T> T getById(Class<T> c, String id) throws Exception;  
      
    /** 
     * <b>function:</b> 传入一个entity对象Class和Integer类型主键，返回该对象 
     * @param <T> 返回、传入对象类型 
     * @param c 对象Class 
     * @param id 主键 
     * @return T 返回该类型的对象 
     * @throws Exception 
     */  
    public <T> T getById(Class<T> c, Integer id) throws Exception;  
      
    /** 
     * <b>function:</b> 传入一个entity对象Class和Serializable类型主键，返回该对象 
     * @createDate 2010-8-2 下午05:48:36 
     * @author hoojo 
     * @param <T> 返回、传入对象类型 
     * @param c 对象Class 
     * @param id 主键 
     * @return T 返回该类型的对象 
     * @throws Exception 
     */  
    public <T> T get(Class<T> c, Serializable id) throws Exception;  
      
    /** 
     * <b>function:</b> 传入hql语句，查询对象 
     * @param <T> 返回对象类型 
     * @param hql 查询的hql语句 
     * @return 对象T 
     * @throws Exception 
     */  
    public <T> T get(String hql) throws Exception;  
      
    /** 
     * <b>function:</b> 通过hql语句查询List集合 
     * @param hql 查询hql语句 
     * @return List<?> 
     * @throws Exception 
     */  
    public <T> List<T> getList(String hql) throws Exception;  
      
    /** 
     * <b>function:</b> 传入删除的hql语句，删除记录 
     * @param hql 将要被执行删除的hql语句 
     * @return 是否删除成功 
     * @throws Exception 
     */  
    public boolean remove(String hql) throws Exception;  
      
    /** 
     * <b>function:</b> 动态查询 
     * @param <T> 查询类的类型 
     * @param c 动态查询组合对象 
     * @return list集合 
     * @throws Exception 
     */  
    public <T> List<T> getList(Class<T> c) throws Exception;  
      
      
    /** 
     * <b>function:</b> 传入hql查询语句和object数组类型的参数，返回查询list集合 
     * @param hql 查询的hql语句 
     * @param obj 查询参数 
     * @return 返回list集合 
     * @throws Exception 
     */  
    public <T> List<T> getList(String hql, Object[] obj) throws Exception;  
      
      
    /** 
     * <b>function:</b> 传入查询语句和查询总条数（总记录）的hql语句、当前页数、每页显示调试数；返回查询后的list集合； 
     * list集合保存总记录调试和记录结果 
     * @param queryHql 查询记录hql语句 
     * @param queryCountHql 查询记录条数hql语句 
     * @param firstResult 当前查询页 
     * @param maxResult 每页显示多少条 
     * @return List返回集合 集合0保存查询结果、集合1保存总记录条数 
     * @throws Exception 
     */  
    public List<?> showPage(String queryHql, String queryCountHql, int firstResult, int maxResult) throws Exception;  
      
    /** 
     * <b>function:</b> 传入查询语句和查询总条数（总记录）的hql语句、page分页对象；返回查询后的list集合； 
     * @param queryHql list集合结果查询 
     * @param queryCountHql 总记录调试查询 
     * @param page 分页对象 
     * @throws Exception 
     */  
    public <T> void showPage(String queryHql, String queryCountHql, Page<T> page) throws Exception;  
      
    /** 
     * <b>function:</b> 分页查询，传入查询count的hql语句和DetachedCriteria动态查询条件进行查询分页 
     * @param queryCountHql hql查询count语句总条数 
     * @param cResult  DetachedCriteria 动态查询条件 
     * @param firstResult 起始 
     * @param maxResult 最大页数 
     * @return List<?> 查询集合 
     * @throws Exception 
     */  
    public List<?> showPage(String queryCountHql, DetachedCriteria cResult, int firstResult, int maxResult) throws Exception;  
      
    /** 
     * <b>function:</b> 分页查询，传入查询的count的hql语句和动态查询DetachedCriteria类及page分页entity 
     * @param queryCountHql 查询count语句 
     * @param cResult DetachedCriteria 动态查询组合类 
     * @param page Page分页实体类 
     * @throws Exception 
     */  
    public <T> void showPage(String queryCountHql, DetachedCriteria cResult, Page<T> page) throws Exception;  
      
    /** 
     * <b>function:</b> 传入查询条件DetachedCriteria进行查询 
     * @param <T> 类型 
     * @param dc DetachedCriteria动态条件查询 
     * @return List 
     * @throws Exception 
     */  
    public <T> List<T> find(DetachedCriteria dc) throws Exception;  
      
    /** 
     * <b>function:</b> 暴露基类session供用户使用 
     * @return Session 
     */  
    public Session session();  
      
    /** 
     * <b>function:</b> 暴露HibernateTemplate模板，当基类（增删改查组件）方法不够用可以用模板进行操作 
     * @return HibernateTemplate 
     */  
    public HibernateTemplate getTemplate();  

}
