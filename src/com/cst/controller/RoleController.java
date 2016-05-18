/** 
 * 文 件 名 : RoleController.java
 * 版权：CopyRright (c) 2008-xxxx: 
 * 描述： 
 * 修改人： crazylion
 * 修改时间： 2013年8月6日
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

import com.cst.model.Role;
import com.cst.service.RoleService;

/**
 * @author crazylion
 *
 */
@Controller
@RequestMapping("role")
public class RoleController
{
	@Resource
	private RoleService roleService;

	public RoleService getRoleService()
	{
		return roleService;
	}

	public void setRoleService(RoleService roleService)
	{
		this.roleService = roleService;
	}
	
	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public void addRole(@RequestBody Role role)
	{
		roleService.saveRole(role);
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public void deleteRole(@RequestBody Role role)
	{
		int id = role.getId();
		roleService.deleteRole(id);
	}
	
	@RequestMapping(value = "/patchdelete.do", method = RequestMethod.POST)
	public void patchDeleteRole(@RequestBody Role[] roles)
	{
		for (Role role : roles)
		{
			this.deleteRole(role);
		}
	}
	
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public void updateRole(@RequestBody Role role)
	{
		roleService.updateRole(role);
	}
	
	@RequestMapping(value = "/list.do", method = RequestMethod.POST)
	@ResponseBody
	public Role getSingleRoleById(@RequestBody Role role)
	{
		int id = role.getId();
		return roleService.getSingleRoleById(id);
	}
	
	@RequestMapping(value = "/listall.do", method = RequestMethod.POST)
	@ResponseBody
	public List<Role> listAllRoles()
	{
		return roleService.listAllRoles();
	}
}
