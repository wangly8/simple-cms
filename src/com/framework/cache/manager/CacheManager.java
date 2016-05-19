package com.framework.cache.manager;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

import com.framework.cache.CMSCache;
import com.framework.cache.SetCache;

/**
 * 缓存管理工具
 * @author wangluyang
 *
 */
public class CacheManager {

	private static Logger logger = Logger.getLogger(CacheManager.class); 
	
	private static Map<String, Map<String, CMSCache>> caches = new HashMap<String, Map<String, CMSCache>>();
	
	private static SetCache setCaches;
	
	private CacheManager() { }
	
	/**
	 * 获得默认的cache
	 * @return
	 */
	public static CMSCache getDefaultCache(){
		if(!(caches.keySet().contains("default")) ){
			logger.info("sorry , default cache is not defined. ") ;	
		}
		return caches.get("default").get("default") ;
	}
	
	/**
	 * 获得redis set cache
	 * @return
	 */
	public static SetCache getDefaultSetCache(){
		return setCaches;
	}

	public Map<String, Map<String, CMSCache>> getCaches() {
		return caches;
	}

	public void setCaches(Map<String, Map<String, CMSCache>> caches) {
		CacheManager.caches = caches;
	}

	public SetCache getSetCaches() {
		return setCaches;
	}

	public void setSetCaches(SetCache setCaches) {
		CacheManager.setCaches = setCaches;
	}
}
