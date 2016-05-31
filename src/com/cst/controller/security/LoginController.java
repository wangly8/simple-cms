package com.cst.controller.security;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cst.model.LoginUser;
import com.cst.util.UserConstants;
import com.framework.web.BaseHandler;
import com.framework.web.ResponseData;


/**
 * 用户登陆
 * @author wangluyang
 *
 */
@Controller
@RequestMapping(value = "/admin")
public class LoginController extends BaseHandler{
	
	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/toLogin")
	public String toLogin(HttpServletRequest request) {
		try {
			request.getSession().invalidate();
		} catch (Exception e) {
		}
		return "/login";
	}
	
	/**
	 * <pre>
	 * 用户登录
	 * </pre>
	 */
	@RequestMapping(value = "/login")
	@ResponseBody
	public ResponseData<Map<String, Object>> login(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ResponseData<Map<String, Object>> responseData = null;
		String message = "";
		// 是否需要修改密码
		boolean modifyPwd = false;
		// 是否第一次登录
		boolean firstLogin = false;
		// 是否经过引导页
		boolean isIntroductory = false;
		String loginName = request.getParameter("userName");
		String password = request.getParameter("passWord");
		if (StringUtils.isBlank(loginName) || StringUtils.isBlank(password)) {
			responseData = new ResponseData<Map<String,Object>>(responseData.AJAX_STATUS_FAILURE, "用户名或密码不能为空");
		} else {
			
			// 密码错误次数
			
			// 自动解锁周期(小时)

			// 第一次登录是否需要更改密码 yes标示修改
			
			//验证用户
			if(StringUtils.equals("admin", loginName) && StringUtils.equals("123456", password)){
				LoginUser user = new LoginUser();
				user.setLocked("false");
				user.setLoginErrorTimes(0);
				user.setName(loginName);
				user.setPassword(password);
				//保存用户
				
				//保存登录日志
				
				//保存用户入session
				request.getSession().setAttribute(UserConstants.SESSION_CURRENT_USER, user);
				Map<String, Object> map = new HashMap<>();
				map.put("isRedirect", true);
				map.put("redirectUrl", "/admin/user/index");
				responseData = new ResponseData<Map<String,Object>>(ResponseData.AJAX_STATUS_SUCCESS, "登录成功", map);
			}
			
			//密码错误3次不允许登陆，锁定用户信息并跳转到验证页面
			
			//如果是第一次登录，需要修改密码，跳转到登录页面
						
		}
		return responseData;
	}
	
	/**
	 * 系统后台退出
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		Object user = request.getSession().getAttribute(UserConstants.SESSION_CURRENT_USER);
		if (user != null) {
			try {
				request.getSession().setAttribute(UserConstants.SESSION_CURRENT_USER, null);
				request.getSession().invalidate();
			} catch (Exception e) {
			}
		}
		// return "logout";
		return "redirect:/admin/toLogin";
	}
}
