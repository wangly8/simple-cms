package com.cst.controller.security;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framework.web.BaseHandler;

/**
 * 用户登陆
 * @author wangluyang
 *
 */
@Controller
@RequestMapping(value = "/admin")
public class LoginController extends BaseHandler{

	@RequestMapping(value = "/toLogin")
	public String toLogin(HttpServletRequest request) {
		try {
			request.getSession().invalidate();
		} catch (Exception e) {
		}
		return "/login";
	}
}
