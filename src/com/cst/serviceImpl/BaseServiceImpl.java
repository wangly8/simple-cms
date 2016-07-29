package com.cst.serviceImpl;

import org.springframework.stereotype.Repository;

import com.cst.dao.BaseDao;

/**
 * 基础操作service
 * @author wangluyang
 *
 */
@Repository
public class BaseServiceImpl {

	public static BaseDao baseDao;

	public void setBaseDao(BaseDao baseDao) {
		BaseServiceImpl.baseDao = baseDao;
	}
}
