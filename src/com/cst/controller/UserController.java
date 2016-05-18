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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cst.model.TestUser;
import com.cst.model.User;
import com.cst.service.UserService;

/**
 * @author crazylion
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController
{
	@Resource
	private UserService userService;
	
	public UserService getUserService()
	{
		return userService;
	}
	
	public void setUsersService(UserService userService)
	{
		this.userService = userService;
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
	@RequestMapping(value = "/listall")
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
		TestUser user = new TestUser("123", "testuser", "1233");
		System.out.println(userService.saveTestUser(user));
	}
	
	@RequestMapping(value = "/getTestUser")
	public void getTestUser()
	{
		TestUser user = userService.getTestUser("123");
		System.out.println(user.getId()+user.getName()+user.getText());
	}
}
