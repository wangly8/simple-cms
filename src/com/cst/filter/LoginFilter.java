package com.cst.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.cst.util.UserConstants;

public class LoginFilter implements Filter{

	private static  Set<String> urlSet;
	private Logger logger = LoggerFactory.getLogger(LoginFilter.class);
	private static final String EPS_LOGOUT_PAGE_URL = "/admin/toLogin";
	static{
    	//不拦截列表
    	urlSet = new HashSet<String>();
    	urlSet.add("/admin/toLogin");
    	urlSet.add("/admin/login");
    }
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		String actionUrl = request.getRequestURI().substring(request.getContextPath().length());
		String logoutUrl = request.getContextPath()+EPS_LOGOUT_PAGE_URL;
		
		Object user = request.getSession().getAttribute(UserConstants.SESSION_CURRENT_USER);
		if (urlSet.contains(actionUrl)){
			filterChain.doFilter(request, response);
		}else{
			if(user==null){
				String ajaxTag = request.getHeader("request-by");
				if (ajaxTag == null || !ajaxTag.trim().equalsIgnoreCase("Ext")) {
//					response.sendRedirect(logoutUrl);
					 response.setContentType("text/html;charset=UTF-8");  
					 response.getWriter().print("<script type='text/javascript'>setTimeout(function(){window.parent.location='"+logoutUrl+"'},1000) ;</script>");
					return  ;
				} else {
					response.addHeader("sessionstatus", "timeout");
					Map<String, Object> result = new HashMap<String, Object>();
					result.put("success", false);
					result.put("timeout", true);
					result.put("redirectUri", logoutUrl);
					response.getWriter().write(JSONObject.toJSONString(result)) ;
					return;
//					filterChain.doFilter(request, response);
				}
			}else{
				filterChain.doFilter(request, response);
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
