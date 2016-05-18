/** 
 * 文 件 名 : Permission.java
 * 版权：CopyRright (c) 2008-xxxx: 
 * 描述： 
 * 修改人： crazylion
 * 修改时间： 2013年8月9日
 * 跟踪单号： 
 * 修改单号： 
 * 修改内容： 
 */ 
package com.cst.model;

/**
 * @author crazylion
 *
 */
public class Permission
{
	private int id;
	private String permissionName;
	private String permissionSerial;
	private String permissionCreateTime;
	private String permissionDecsrib;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getPermissionName()
	{
		return permissionName;
	}

	public void setPermissionName(String permissionName)
	{
		this.permissionName = permissionName;
	}

	public String getPermissionSerial()
	{
		return permissionSerial;
	}

	public void setPermissionSerial(String permissionSerial)
	{
		this.permissionSerial = permissionSerial;
	}

	public String getPermissionCreateTime()
	{
		return permissionCreateTime;
	}

	public void setPermissionCreateTime(String permissionCreateTime)
	{
		this.permissionCreateTime = permissionCreateTime;
	}

	public String getPermissionDecsrib()
	{
		return permissionDecsrib;
	}

	public void setPermissionDecsrib(String permissionDecsrib)
	{
		this.permissionDecsrib = permissionDecsrib;
	}
}
