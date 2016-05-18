/** 
 * 文 件 名 : Users.java
 * 版权：CopyRright (c) 2008-xxxx: 
 * 描述： 
 * 修改人： crazylion
 * 修改时间： 2013年7月14日
 * 跟踪单号： 
 * 修改单号： 
 * 修改内容： 
 */
package com.cst.model;

/**
 * @author crazylion
 * 
 */
public class User
{
	private int id;
	private String userAccount;
	private String userPassword;
	private String userTrueName;
	private String userSex;
	private String userDepart;
	private String userPhone;
	private String userMobile;
	private String userEmail;
	private String userIdcard;
	private Character userState;
	private int roleId;
	private String userRegTime;
	private String userLastTime;
	private String userTimes;

	public int getId()
	{
		return this.id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getUserAccount()
	{
		return this.userAccount;
	}

	public void setUserAccount(String userAccount)
	{
		this.userAccount = userAccount;
	}

	public String getUserPassword()
	{
		return this.userPassword;
	}

	public void setUserPassword(String userPassword)
	{
		this.userPassword = userPassword;
	}

	public String getUserTrueName()
	{
		return this.userTrueName;
	}

	public void setUserTrueName(String userTrueName)
	{
		this.userTrueName = userTrueName;
	}

	public String getUserSex()
	{
		return this.userSex;
	}

	public void setUserSex(String userSex)
	{
		this.userSex = userSex;
	}

	public String getUserDepart()
	{
		return this.userDepart;
	}

	public void setUserDepart(String userDepart)
	{
		this.userDepart = userDepart;
	}

	public String getUserPhone()
	{
		return this.userPhone;
	}

	public void setUserPhone(String userPhone)
	{
		this.userPhone = userPhone;
	}
	
	public String getUserMobile()
	{
		return this.userMobile;
	}
	
	public void setUserMobile(String userMobile)
	{
		this.userMobile = userMobile;
	}
	
	public String getUserEmail()
	{
		return this.userEmail;
	}

	public void setUserEmail(String userEmail)
	{
		this.userEmail = userEmail;
	}

	public String getUserIdcard()
	{
		return this.userIdcard;
	}

	public void setUserIdcard(String userIdcard)
	{
		this.userIdcard = userIdcard;
	}

	public Character getUserState()
	{
		return this.userState;
	}

	public void setUserState(Character userState)
	{
		this.userState = userState;
	}

	public int getRoleId()
	{
		return this.roleId;
	}

	public void setRoleId(int roleId)
	{
		this.roleId = roleId;
	}

	public String getUserRegTime()
	{
		return this.userRegTime;
	}

	public void setUserRegTime(String userRegTime)
	{
		this.userRegTime = userRegTime;
	}

	public String getUserLastTime()
	{
		return this.userLastTime;
	}

	public void setUserLastTime(String userLastTime)
	{
		this.userLastTime = userLastTime;
	}

	public String getUserTimes()
	{
		return this.userTimes;
	}

	public void setUserTimes(String userTimes)
	{
		this.userTimes = userTimes;
	}
}
