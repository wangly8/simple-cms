/** 
 * 文 件 名 : Role.java
 * 版权：CopyRright (c) 2008-xxxx: 
 * 描述： 
 * 修改人： crazylion
 * 修改时间： 2013年8月6日
 * 跟踪单号： 
 * 修改单号： 
 * 修改内容： 
 */ 
package com.cst.model;

/**
 * @author crazylion
 *
 */
public class Role
{
	private int id;	
	private String roleName;
	private String roleCreateTime;
	private String roleDescrib;
	
	public int getId()
	{
		return this.id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getRoleName()
	{
		return this.roleName;
	}
	
	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}
	
	public String getRoleCreateTime()
	{
		return this.roleCreateTime;
	}
	
	public void setRoleCreateTime(String roleCreateTime)
	{
		this.roleCreateTime = roleCreateTime;
	}
	
	public String getRoleDescrib()
	{
		return this.roleDescrib;
	}
	
	public void setRoleDescrib(String roleDescrib)
	{
		this.roleDescrib = roleDescrib;
	}
}
