package com.cst.model;

import java.io.Serializable;

/**
 * 统一定义id的entity基类.
 * @author wangluyang
 *
 */
public class IdEntity implements Serializable {

	public static final long serialVersionUID = 1L;
	
	protected String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
