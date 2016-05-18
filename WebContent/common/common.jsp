<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String _bathPath = request.getContextPath();
	//String bp = _bathPath;
	request.setAttribute("_bathPath", _bathPath);
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
	response.setHeader("Pragma", "No-cache");
	request.setAttribute("requestUrl", request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + request.getRequestURI());
	
	String fullPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + request.getContextPath();
%>
<script>
	var webpath = "<%=_bathPath%>";
	var fullPath = "<%=fullPath%>";
</script>
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/css.css" />
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/font-awesome.css" />
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/jquery-1.11.1.min.js?v=201509061722"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jsviews/jsrender.min.js?v=201509061722"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jsviews/jsviews.min.js?v=201509061722"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jsviewstag.js"></script> 

	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.flexslider-min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/home_gundong.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/index.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/validate.js"></script>
	
	<!-- bootstrap框架 -->
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/dist/css/bootstrap.min.css"/>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/bootstrap/dist/js/bootstrap.min.js"></script>
	
	<!-- 分页 -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/bootbox/bootbox.js"></script>
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/ajaxhelper/css/jquery.pagcontroller.css"/>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/ajaxhelper/jquery.form.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/ajaxhelper/jquery.pagcontroller.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/twbs-pagination/jquery.twbsPagination.js"></script>
	
	<!-- 时间插件 -->
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css"/>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
