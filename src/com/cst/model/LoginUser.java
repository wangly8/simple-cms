package com.cst.model;

/**
 * 登录用户
 * @author wangluyang
 *
 */
public class LoginUser extends ExtEntity{

	/**
	 * 编码
	 */
	private String code="";

	/**
	 * 帐号
	 */
	private String loginName="";
	/**
	 * 员工ID
	 */
	private String employeeId="";
	/**
	 * 员工姓名
	 */
	private String name="";

	/**
	 * 邮箱
	 */
	private String email="";
	/**
	 * 手机号码
	 */
	private String mphone="";
	/**
	 * 密码
	 */
	private String password="";
	/**
	 * 锁定状态
	 */
	private String locked="";
	private String lockedStr = "";
	/**
	 * 启用状态
	 */
	private String available;
	 /**是否为新用户1为新0为老*/
    private int isNew;
    /** 登陆错误次数 */
	private int loginErrorTimes;
	/** 最后一次登陆错误时间 */
	private String lastErrorDate="";
	/** 锁定开始时间 */
	private String lockDate="";
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLocked() {
		return locked;
	}
	public void setLocked(String locked) {
		this.locked = locked;
	}
	public String getLockedStr() {
		return lockedStr;
	}
	public void setLockedStr(String lockedStr) {
		this.lockedStr = lockedStr;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	public int getIsNew() {
		return isNew;
	}
	public void setIsNew(int isNew) {
		this.isNew = isNew;
	}
	public int getLoginErrorTimes() {
		return loginErrorTimes;
	}
	public void setLoginErrorTimes(int loginErrorTimes) {
		this.loginErrorTimes = loginErrorTimes;
	}
	public String getLastErrorDate() {
		return lastErrorDate;
	}
	public void setLastErrorDate(String lastErrorDate) {
		this.lastErrorDate = lastErrorDate;
	}
	public String getLockDate() {
		return lockDate;
	}
	public void setLockDate(String lockDate) {
		this.lockDate = lockDate;
	}
}
