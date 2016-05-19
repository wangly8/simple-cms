package com.framework.cache;

/**
 * 工程中所有的cache 都需要继承该接口
 * @author wangluyang
 *
 */
public interface CMSCache{
	/**
	 * 获取缓存
	 * 
	 * @param key
	 * @return
	 */
	public Object get(Object key);

	/**
	 * 放缓存
	 * 
	 * @param key
	 * @param value
	 */
	public void put(Object key, Object value);

	/**
	 * <pre>
	 * 放缓存
	 * </pre>
	 * 
	 * @param key
	 * @param value
	 * @param eternal 是否持久
	 */
	public void put(Object key, Object value, boolean eternal);

	/**
	 * <pre>
	 * 放缓存
	 * </pre>
	 * @param key
	 * @param value
	 * @param timeToIdleSeconds 访问这个cache中元素的最大间隔时间。如果超过这个时间没有访问这个cache中的某个元素，那么这个元素将被从cache中清除
	 * @param timeToLiveSeconds cache中元素的生存时间。意思是从cache中的某个元素从创建到消亡的时间，从创建开始计时，当超过这个时间，这个元素将被从cache中清除
	 */
	public void put(Object key, Object value, Integer timeToIdleSeconds,
			Integer timeToLiveSeconds);

	/**
	 * 删除缓存
	 * 
	 * @param key
	 */
	public void remove(Object key);

	/**
	 * 清空缓存
	 */
	public void removeAll();

	/**
	 * 销毁缓存
	 */
	public void destroy();
}
