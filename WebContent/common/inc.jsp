<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String _base = request.getContextPath();
request.setAttribute("_base", _base);
response.setHeader("Cache-Control", "no-cache");
response.setDateHeader("Expires", -10);
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

<script src="${_base}/js/bootstrap/jquery-1.11.1.min.js"></script>
<script src="${_base}/js/bootstrap/jquery-migrate-1.2.1.min.js"></script>
<script src="${_base}/js/bootstrap/bootstrap.min.js"></script>
<script src="${_base}/js/bootstrap/modernizr.min.js"></script>
<!-- <script src="../../js/bootstrap/retina.min.js"></script> -->
<script src="${_base}/js/bootstrap/jquery-ui-1.10.3.min.js"></script>
<script src="${_base}/js/echarts/echarts-all.js"></script>
<script src="${_base}/js/util/util.js"></script>