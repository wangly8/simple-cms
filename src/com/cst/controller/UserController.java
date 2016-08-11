/** 
 * 文 件 名 : UserController.java
 * 版权：CopyRright (c) 2008-xxxx: 
 * 描述： 
 * 修改人： crazylion
 * 修改时间： 2013年7月14日
 * 跟踪单号： 
 * 修改单号： 
 * 修改内容： 
 */
package com.cst.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.cst.model.Subject;
import com.cst.model.User;
import com.cst.service.SubjectService;
import com.cst.service.UserService;
import com.framework.cache.SetCache;
import com.framework.cache.manager.CacheManager;

/**
 * @author crazylion
 * 
 */
@Controller
@RequestMapping("/admin/user")
public class UserController
{
	@Resource
	private UserService userService;
	@Resource
	private SubjectService subjectService;
	
	private static Logger logger = Logger.getLogger(UserController.class);
	
	public UserService getUserService()
	{
		return userService;
	}
	
	public void setUsersService(UserService userService)
	{
		this.userService = userService;
	}

	public SubjectService getSubjectService() {
		return subjectService;
	}

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	@RequestMapping(value = "/add")
	public void addUser(@RequestBody User user)
	{
		userService.saveUser(user);
	}
	
	@RequestMapping(value = "/list")
	public User getSingleUserById(@RequestBody User user)
	{
		int id = user.getId();
		User result = userService.getSingleUserById(id);
		return result;
	}
	@RequestMapping(value = "/index")
	public String getAllUser(Model model, HttpServletRequest request)
	{
//		List<User> result = userService.listAllUsers();
//		return result;
		return  "/index";
	}
	
	@RequestMapping(value = "/update")
	public void updateUserInfo(@RequestBody User user)
	{
		userService.updateUser(user);
	}
	
	@RequestMapping(value = "/delete")
	public void deleteUser(@RequestBody User user)
	{
		int id = user.getId();
		userService.removeUser(id);
	}
	
	@RequestMapping(value = "/patchdelete")
	public void patchDeleteUser(@RequestBody User[] users)
	{
		for (User user : users)
		{
			this.deleteUser(user);
		}
	}
	
	@RequestMapping(value = "/saveTestUser")
	public void saveTestUser()
	{
		SetCache cache = CacheManager.getDefaultSetCache();
		cache.add("aaa", "AASD");
		cache.add("aaa", "AASSSSS");
	}
	
	@RequestMapping(value = "/getTestUser")
	public void getTestUser()
	{
		SetCache cache = CacheManager.getDefaultSetCache();
		System.out.println("----"+cache.pop("aaa"));
	}
	
	@RequestMapping(value = "/getSubjects")
	public void getSubjects()
	{
		List<User> subjects = this.subjectService.getAll();
		System.out.println(JSONObject.toJSON(subjects));
	}
}
