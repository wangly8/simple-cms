<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="ai" uri="/WEB-INF/tag/ai-tags.tld" %>
<%@ page import="com.ai.runner.bis.web.system.model.UserLoginVo" %>
<!DOCTYPE html>
<%  UserLoginVo user=(UserLoginVo) request.getSession().getAttribute("user_login"); %>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>宽带在线</title>


	<!--列表页查询按钮-->
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/business/search.js"></script>
</head>
<body>

<div class="herder_top_big">
   <div class="herder_top">
   <ul>
     <li class="code_l"><i class="icon-user"></i><a href="#">${sessionScope.user_login.staffName}</a> ｜
     <p style="display:none">
     <span class="code"><img src="${_bathPath}/images/code_jiao.png"></span>
     <span><a href="${_bathPath}/index/index">个人中心</a></span>
     <span><a href="#">修改密码</a></span>
    </p>
   </li>
   <li><p><a href="${_bathPath}/logout">退出</a></p></li>
  <li class="right" id="configMenu">
 
   </li>
   </ul>
   </div>

</div>

<div class="header1" style=" position:relative;">
 <div class="head1">
  <div class="logo1"><a href="#"><img src="${_bathPath}/images/logo.png"  /></a></div>
  <div class="nav1">
   <div class="nava1">
   <div class="yax1" style="width:140px;">
    <p>
     <img src="${_bathPath}/images/i_city.png"><span><%=user.getTenantName() %></span><i class="icon-caret-down"></i>
    </p>
    <ul style="display:none;">
     <li><a href="#">世通宽带</a></li>
     <li><a href="#">长城网络</a></li>
     <li><a href="#">歌华有线</a></li>
    </ul>
   </div>
   
   </div>
   <div class="naver1">
   <div class="naver_t1 ">
    <ul id="menu" >
  
    </ul>
    
   </div>
   </div>
  </div>
 </div>
</div>



<script type="text/javascript" language="JavaScript">
var myScrollTop=function()  //获得当前窗口显示区顶点位置
{
        return document.documentElement.scrollTop?document.documentElement.scrollTop:document.body.scrollTop;
 };
       
function mymovemenu()  // 随着窗口的拉动，实时调整广告在窗口中的位置
{
        document.getElementById("xuanfu").style.top=myScrollTop()+60+'px';document.getElementById("xuanfu").style.right=3+'px';setTimeout("mymovemenu();",10);
}
</script>



</body>
</html>
<script>
$(document).ready(function() {
	getmenu();
	
	getConfgMenu();
});


function getConfgMenu()
{
	$.ajax({
		url : '${_bathPath}/menu/getChannelMenu',
		type : "post",
		async : true,
		dataType : "html",
		timeout : "10000",
		error : function() {
			alert("服务加载出错");
		},
		success : function(data) {
			var json = eval(data);
			var str="";
			$.each(json, function(index, item) {
				//循环获取数据    
				$("#configMenu").append(" <p><a href="+item.menuUrl+">"+item.menuName+"</a>｜</p>");
			});	
		}
	});

}


function getmenu(){
	$.ajax({
		url : '${_bathPath}/menu/getMenu',
		type : "post",
		async : true,
		dataType : "html",
		timeout : "10000",
		error : function() {
			alert("服务加载出错");
		},
		success : function(data) {
			var json = eval(data);
			var str="";
			$.each(json, function(index, item) {
				//循环获取数据    
				var menuId = json[index].menuId;
				
				//$('#menu').html("<li>");
				//$('#menu').append("<a href='"+json[index].menuUrl+"'>"+json[index].menuName+"</a>");
				var obj=json[index].menuList;
				if(obj == null){
					
					str+= "<li style='float:left'><a href='"+json[index].menuUrl+"'>"+json[index].menuName+"</a>";
					str+="  <ul style='display:none;'>";  
				}else{
					str+="<li style='float:left' class='"+json[index].menuPic+" erji2'><p><a>"+json[index].menuName+"</a></p>";
					str+="  <ul style='display:none;'>";
				}
				//$('#menu').append("<dl style='display:none;'><i class='icon-play'></i>");
				$.each(obj,function(index,item){
					str+="<li><a href='${_bathPath}/"+obj[index].menuUrl+"'>"+obj[index].menuName+"</a></li>";
					//$('#menu').append("<span><a href='"+obj[index].menuUrl+"'>"+obj[index].menuName+"</a></span>");
				});
				str+="</ul></li>"
			
				
			});	
			$('#menu').append(str);
			
			$(".erji2").hover(function(){
		        $(this).children("ul").show(0);
		        $(this).children("p").children().removeClass("reorder");
				$(this).children("p").children().addClass("remove");
		    },function(){
		        $(this).children("ul").hide(0);
		        $(this).children("p").children().removeClass("remove");
				$(this).children("p").children().addClass("reorder");
		    });
		}
	});
}
</script>