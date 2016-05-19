package com.framework.cache;

import java.util.Set;

/**
 * redis set封装
* @ClassName: SetCache
* @Description: TODO
* @author wangly
* @date 2016年5月19日 下午10:22:01
*
 */
public interface SetCache {
	
	/**
	 * 存入set
	 * @param keyId 当前set的唯一标示
	 * @param value
	 */
	public void add(String keyId, Object value);
	/**
	 * 取出set顶部第一个元素并删除set中第一个元素
	 * @param keyId
	 * @return
	 */
	public Object pop(String keyId);
	/**
	 * 获得当前的set中的所有数据
	 * @param keyId
	 * @return
	 */
	public Set getSet(String keyId);
	/**
	 * 获得当前set大小
	 * @param keyId
	 * @return
	 */
	public long getSize(String keyId);
	/**
	 * 删除set中的特定元素
	 * @param keyId
	 * @param value
	 */
	public void remove(String keyId, Object value);
}
