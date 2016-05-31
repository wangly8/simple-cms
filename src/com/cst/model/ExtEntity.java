package com.cst.model;


/**
 * 统一定义扩展的entity基类.
 * @author wangluyang
 *
 */
public abstract class ExtEntity extends IdEntity {
	
	/**
	 * 假删除标示
	 */
	protected String flag="1";
	
	protected String createDate;
	
	
	protected String createUserId;
	
	protected String updateUserId;
	
	protected String updateDate;
	
	/**
	 * 取得删除标识
	 * 
	 * @return 标示值（1 可用，0 删除）
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * 设置删除标示（1 可用，0 删除）
	 * 
	 * @param flag 标示值
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}
}
