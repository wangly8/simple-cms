package com.framework.cache.manager;

import java.util.HashMap;
import java.util.Map;

import com.framework.cache.CMSCache;

/**
 * 缓存管理工具
 * @author wangluyang
 *
 */
public class CacheManager {

	private static Map<String, Map<String, CMSCache>> caches = new HashMap<String, Map<String, CMSCache>>();

	public static Map<String, Map<String, CMSCache>> getCaches() {
		return caches;
	}

	public static void setCaches(Map<String, Map<String, CMSCache>> caches) {
		CacheManager.caches = caches;
	}
	
}
