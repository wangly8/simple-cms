<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-cn">
<!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width; initial-scale=0.8;  user-scalable=0;" />
	<%
	    String _base = request.getContextPath();
	    request.setAttribute("_base", _base);
	    response.setHeader("Cache-Control", "no-cache");
	    response.setDateHeader("Expires", 0);
	    response.setHeader("Pragma", "No-cache");
	%>
	<script>
	    var _base = "${_base}";
	</script>
    <!-- ======基础样式开始======-->
    <link href="${_base}/css/bootstrap/style.default.css" rel="stylesheet">
    <!--换肤-->
    <link href="${_base}/css/bootstrap/style.katniss.css" rel="stylesheet">
    <!--IE8兼容样式-->
    <link href="${_base}/css/bootstrap/navigateLowerIE8.css" rel="stylesheet">
    <!-- ======基础样式结束======-->
  <title>大连华信全渠道运营管理平台</title>
</head>

<body class="signin">


<section>
  
    <div class="signinpanel">
        
        <div class="row">
            
            <div class="col-md-7">
                
                <div class="signin-info">
                    <div class="logopanel">
                        <h1><img src="${_base}/images/dhc-logo-inverse.png" alt=""/>全渠道运营管理平台 </h1>
                    </div><!-- logopanel -->
                    <div class="mb20"></div>
                    <h5><strong>欢迎登录大连华信全渠道运营管理平台</strong></h5>
                    <ul>
                        <li><i class="fa fa-arrow-circle-o-right mr5"></i> 商品管理</li>
                        <li><i class="fa fa-arrow-circle-o-right mr5"></i> 系统管理</li>
                        <li><i class="fa fa-arrow-circle-o-right mr5"></i> 订单管理</li>
                        <li><i class="fa fa-arrow-circle-o-right mr5"></i> 发货管理</li>
                        <li><i class="fa fa-arrow-circle-o-right mr5"></i> 库存管理</li>
                    </ul>
                </div><!-- signin0-info -->
            
            </div><!-- col-sm-7 -->
            
            <div class="col-md-5">
                
                <form method="post" id="login-form">
                    <h4 class="nomargin">登录</h4>
                    <p class="mt5 mb20">请输入您的帐号密码登录。</p>
                
                    <input type="text" class="form-control uname" name="userName" id="userName" class="form-control" placeholder="用户名" />
                    <input type="password" class="form-control pword" name="passWord" id="passWord" class="form-control" placeholder="密码" />
                    <a href=""><small>忘记密码？</small></a>
                    <button type="submit" class="btn btn-success btn-block">登录</button>
                    
                </form>
            </div><!-- col-sm-5 -->
            
        </div><!-- row -->
        
        <div class="signup-footer">
            <div class="pull-left">
                &copy; 2015. 版权所有 <i class="fa fa-copyright"></i>大连华信计算机技术股份有限公司
            </div>
            <div class="pull-right">
                技术支持： <a href="http://www.dhc.com.cn" target="_blank">DHC</a>
            </div>
        </div>
        
    </div><!-- signin -->
  
</section>


<script src="${_base}/js/bootstrap/jquery-1.11.1.min.js"></script>
<script src="${_base}/js/bootstrap/jquery-migrate-1.2.1.min.js"></script>
<script src="${_base}/js/bootstrap/bootstrap.min.js"></script>
<script src="${_base}/js/bootstrap/modernizr.min.js"></script>
<script src="${_base}/js/bootstrap/retina.min.js"></script>
<script src="${_base}/js/jquery.validate/jquery.validate.min.js"></script>
<script src="${_base}/js/login.js"></script>
</body>
</html>
