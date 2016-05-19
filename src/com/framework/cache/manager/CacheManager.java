package com.framework.cache.manager;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

import com.framework.cache.CMSCache;

/**
 * 缓存管理工具
 * @author wangluyang
 *
 */
public class CacheManager {

	private static Logger logger = Logger.getLogger(CacheManager.class); 
	
	private static Map<String, Map<String, CMSCache>> caches = new HashMap<String, Map<String, CMSCache>>();
	
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

	public Map<String, Map<String, CMSCache>> getCaches() {
		return caches;
	}

	public void setCaches(Map<String, Map<String, CMSCache>> caches) {
		CacheManager.caches = caches;
	}
	
}
