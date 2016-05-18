/** 
 * 文 件 名 : PermissionController.java
 * 版权：CopyRright (c) 2008-xxxx: 
 * 描述： 
 * 修改人： crazylion
 * 修改时间： 2013年8月9日
 * 跟踪单号： 
 * 修改单号： 
 * 修改内容： 
 */ 
package com.cst.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cst.model.Permission;
import com.cst.service.PermissionService;

/**
 * @author crazylion
 *
 */
@Controller
@RequestMapping("permission")
public class PermissionController
{
	@Resource
	private PermissionService permissionService;
	
	public PermissionService getPermissionService()
	{
		return this.permissionService;
	}
	
	public void setPermissionService(PermissionService permissionService)
	{
		this.permissionService = permissionService;
	}
	
	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public void addPermission(@RequestBody Permission permission)
	{
		permissionService.addPermission(permission);
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public void deletePermission(@RequestBody Permission permission)
	{
		int id = permission.getId();
		permissionService.deletePermission(id);
	}
	
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public void updatePermission(@RequestBody Permission permission)
	{
		permissionService.updatePermission(permission);
	}
	
	@RequestMapping(value = "/list.do", method = RequestMethod.POST)
	@ResponseBody
	public Permission getPermissionById(@RequestBody Permission permission)
	{
		int id = permission.getId();
		
		return permissionService.getPermissionById(id);
	}
	
	@RequestMapping(value = "/listall.do", method = RequestMethod.POST)
	@ResponseBody
	public List<Permission> listAllPermissions()
	{
		return permissionService.listAllPermissions();
	}
}

