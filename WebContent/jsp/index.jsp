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
	    response.setDateHeader("Expires", -10);
	    response.setHeader("Pragma", "No-cache");
	%>
	<script>
	    var _base = "${_base}";
	</script>
    <link rel="shortcut icon" href="${_base}/images/favicon.png" type="image/png">

    <title>管理系统</title>
    <!-- ======基础样式开始======-->
    <link href="${_base}/css/bootstrap/style.default.css" rel="stylesheet">
    <link href="${_base}/js/tab-page/tab-control.css" rel="stylesheet">
    <!--换肤-->
    <link href="${_base}/css/bootstrap/style.katniss.css" rel="stylesheet">
    <!--IE8兼容样式-->
    <link href="${_base}/css/bootstrap/navigateLowerIE8.css" rel="stylesheet">
    <!-- ======基础样式结束======-->

</head>

<body class="stickyheader">
<!-- Preloader -->
<div id="preloader">
    <div id="status"><i class="fa fa-spinner fa-spin"></i></div>
</div>

<section>

    <div class="leftpanel sticky-leftpanel">
        <div class="leftpanelinner">

            <!-- This is only visible to small devices -->
            <div class="visible-xs hidden-sm hidden-md hidden-lg">
                <div class="media userlogged">
                <span class="pull-left">
                  <i class="fa fa-user"></i>
                </span>

                    <div class="media-body">
                        <h4 class="text-primary">张宏川</h4>
                    </div>
                </div>
                <ul class="nav nav-pills nav-stacked">
                    <li><a href="locked.html"><i class="fa fa-sign-out"></i> <span>注销</span></a></li>
                </ul>
            </div>

            <a class="menutoggle"><i class="fa fa-bars"></i></a>
            <ul class="nav nav-pills nav-stacked nav-bracket">
                <li></li>
                <li class="active"><a href="index.html"><i class="fa fa-home"></i> <span>主页</span></a></li>

                <li class="nav-parent"><a href=""><i class="fa fa-shopping-cart"></i> <span>商品管理</span></a>
                    <ul class="children">
                        <li><a href="javascript:;" onclick="TabControlAppend('1-1','店铺商品管理','${_base}/jsp/goods/goods-list.jsp')"> 店铺商品管理</a></li>
                        <li><a href="javascript:;" onclick="TabControlAppend('1-2','平台店铺管理','portal/goods/goods-store.html')"> 平台店铺管理</a></li>
                        <li><a href="javascript:;" onclick="TabControlAppend('1-3','商品分类管理','portal/goods/goods-class.html')"> 商品分类管理</a></li>
                        <li><a href="javascript:;" onclick="TabControlAppend('1-4','商品价格管理','portal/goods/goods-price.html')"> 商品价格管理</a></li>
                        <li><a href="javascript:;" onclick="TabControlAppend('1-5','商品上下架管理','portal/goods/goods-active.html')"> 商品上下架管理</a></li>
                        <li><a href="javascript:;" onclick="TabControlAppend('1-6','商品一键铺货','portal/goods/goods-onekey.html')"> 商品一键铺货</a></li>
                    </ul>
                </li>
                <li class="nav-parent"><a href=""><i class="fa fa-cogs"></i> <span>系统管理</span></a>
                    <ul class="children">
                        <li class="nav-third"><a href="javascript:void(0);">API设置</a>
                            <ul class="nav-third-children">
                                <li><a href="javascript:;" onclick="TabControlAppend('2-1-1','API管理','portal/system/home-page.html')"> API管理</a></li>
                                <li><a href="javascript:;" onclick="TabControlAppend('2-1-2','API参数设置','portal/system/home-page.html')"> API参数设置</a></li>
                                <li><a href="javascript:;" onclick="TabControlAppend('2-1-3','新增API','portal/system/home-page.html')"> 新增API</a></li>
                            </ul>
                        </li>
                        <li><a href="javascript:;" onclick="TabControlAppend('2-2','店铺管理','portal/system/system-store-manage.html')"> 店铺管理</a></li>
                        <li><a href="javascript:;" onclick="TabControlAppend('2-3','人员管理','portal/system/system-member-manage.html')"> 人员管理</a>
                            <ul class="nav-third-children">
                                <li><a href="javascript:;" onclick="TabControlAppend('2-3-1','API管理','portal/system/home-page.html')"> 帐号详情</a></li>
                                <li><a href="javascript:;" onclick="TabControlAppend('2-3-2','API参数设置','portal/system/home-page.html')"> 员工权限</a></li>
                                <li><a href="javascript:;" onclick="TabControlAppend('2-3-3','新增API','portal/system/home-page.html')"> 店铺权限</a></li>
                                <li><a href="javascript:;" onclick="TabControlAppend('2-3-3','新增API','portal/system/home-page.html')"> 仓库权限</a></li>
                            </ul>
                        </li>
                        <li><a href="javascript:;" onclick="TabControlAppend('2-4','角色管理','portal/system/system-role-manage.html')"> 角色管理</a></li>
                        <li><a href="javascript:;" onclick="TabControlAppend('2-5','工作组维护','portal/system/system-work-group.html')"> 工作组维护</a></li>
                        <li><a href="javascript:;" onclick="TabControlAppend('2-6','资源管理','portal/system/system-source-manage.html')"> 资源管理</a></li>
                        <li><a href="javascript:;" onclick="TabControlAppend('2-7','仓库管理','portal/system/system-repertory-manage.html')"> 仓库管理</a>
                            <ul class="nav-third-children">
                                <li><a href="javascript:;" onclick="TabControlAppend('2-7-1','仓库详情','portal/system/system-repertory-datail.html')"> 仓库详情</a></li>
                                <li><a href="javascript:;" onclick="TabControlAppend('2-7-2','发货范围','portal/system/system-repertory-limit.html')"> 发货范围</a></li>
                            </ul>
                        </li>
                        <li><a href="javascript:;" onclick="TabControlAppend('2-8','商品模板管理','portal/system/system-goods-template.html')"> 商品模板管理</a>
                            <ul class="nav-third-children">
                                <li><a href="javascript:;" onclick="TabControlAppend('2-7-1','仓库详情','portal/system/ssystem-repertory-datail.html')"> 商品模板设置</a></li>
                            </ul>
                        </li>
                        <li><a href="javascript:;" onclick="TabControlAppend('2-9','订单模板管理','portal/system/system-order-template.html')"> 订单模板管理</a>
                            <ul class="nav-third-children">
                                <li><a href="javascript:;" onclick="TabControlAppend('2-7-1','仓库详情','portal/system/ssystem-repertory-datail.html')"> 订单模板设置</a></li>
                            </ul>
                        </li>
                        <li><a href="javascript:;" onclick="TabControlAppend('2-10','会员模板管理','portal/system/system-member-manage.html')"> 会员模板管理</a>
                            <ul class="nav-third-children">
                                <li><a href="javascript:;" onclick="TabControlAppend('2-7-1','仓库详情','portal/system/ssystem-repertory-datail.html')"> 会员模板设置</a></li>
                            </ul>
                        </li>
                        <li><a href="javascript:;" onclick="TabControlAppend('2-11','基础数据管理','portal/system/home-page.html')"> 基础数据管理</a>
                            <ul class="nav-third-children">
                                <li><a href="javascript:;" onclick="TabControlAppend('2-7-1','渠道设置','portal/system/system-road-set.html')"> 渠道设置</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li class="nav-parent"><a href=""><i class="fa fa-file-archive-o"></i> <span>订单管理</span></a>
                    <ul class="children">
                        <li><a href="javascript:;" onclick="TabControlAppend('3-1','基础数据管理','portal/system/home-page.html')"> 订单调度管理</a></li>
                        <li><a href="javascript:;" onclick="TabControlAppend('3-2','基础数据管理','portal/system/home-page.html')"> 订单处理管理</a>
                            <ul class="nav-third-children">
                                <li><a href="javascript:;" onclick="TabControlAppend('3-2-1','原单管理','portal/order/order-original-manage.html')"> 原单管理</a></li>
                                <li><a href="javascript:;" onclick="TabControlAppend('3-2-2','订单处理','portal/order/order-deal-with.html')"> 订单处理</a></li>
                            </ul>

                        </li>
                        <li><a href="javascript:;" onclick="TabControlAppend('3-3','订单审核管理','portal/system/home-page.html')"> 订单审核管理</a></li>
                    </ul>
                </li>
                <li class="nav-parent"><a href=""><i class="fa fa-truck"></i> <span>发货管理</span></a>
                    <ul class="children">
                        <li><a href="javascript:;" onclick="TabControlAppend('4-1','待发货订单','portal/order/order-goods.html')">待发货订单</a></li>
                    </ul>
                </li>
                <li class="nav-parent"><a href=""><i class="fa fa-cubes"></i> <span>库存管理</span></a>
                    <ul class="children">
                        <li><a href="javascript:;" onclick="TabControlAppend('5-1','库存管理','portal/stock/stock-manage-find.html')">库存管理 </a></li>
                        <li><a href="javascript:;" onclick="TabControlAppend('5-2','库存分配','portal/stock/stock-allot-find.html')">库存分配</a></li>
                        <li><a href="javascript:;" onclick="TabControlAppend('5-3','库存共享','portal/stock/stock-share-seek.html')">库存共享</a></li>
                        <li><a href="javascript:;" onclick="TabControlAppend('5-4','库存日志','portal/stock/sstock-record-change.html')">库存日志</a>
                            <ul class="nav-third-children">
                                <li><a href="javascript:;" onclick="TabControlAppend('5-4-1','库存变更日志','portal/stock/stock-record-change.html')"> 库存变更日志</a></li>
                                <li><a href="javascript:;" onclick="TabControlAppend('5-4-2','库存共享历史','portal/stock/stock-record-history.html')"> 库存共享历史</a></li>

                            </ul>
                        </li>
                        <li><a href="javascript:;" onclick="TabControlAppend('5-5','库存统计','portal/stock/sstock-record-change.html')">库存统计</a>
                            <ul class="nav-third-children">
                                <li><a href="javascript:;" onclick="TabControlAppend('5-5-1','发货统计','portal/stock/stock-goods-count.html')"> 发货统计</a></li>
                                <li><a href="javascript:;" onclick="TabControlAppend('5-5-2','库存统计','portal/stock/stock-goods-count.html')"> 库存统计</a></li>
                            </ul>
                        </li>
                        <li><a href="javascript:;" onclick="TabControlAppend('5-6','垃圾箱','portal/stock/stock-litter-history-find.html')">垃圾箱</a>
                            <ul class="nav-third-children">
                                <li><a href="javascript:;" onclick="TabControlAppend('5-6-1','库存变更历史查询','portal/stock/stock-litter-history-find.html')"> 库存变更历史查询</a></li>
                                <li><a href="javascript:;" onclick="TabControlAppend('5-6-2','库存分享历史','portal/stock/stock-litter-history-share.html')"> 库存分享历史</a></li>

                            </ul>
                        </li>
                        <li><a href="javascript:;" onclick="TabControlAppend('5-7','库存预警','portal/stock/stock-warning-rules.html')">库存预警</a>
                            <ul class="nav-third-children">
                                <li><a href="javascript:;" onclick="TabControlAppend('5-7-1','库存预警查询','portal/stock/stock-warning-rules-find.html')"> 库存预警查询</a></li>
                            </ul>
                        </li>
                    </ul>

                <li class="nav-parent"><a href=""><i class="fa fa-file-text-o"></i> <span>库存日志</span></a>
                    <ul class="children">
                        <li><a href="javascript:;" onclick="TabControlAppend('6-1','xxxx','portal/system/xxxx.html')"> 店铺装修</a></li>
                        <li><a href="javascript:;" onclick="TabControlAppend('6-2','xxxx','portal/system/xxxx.html')"> 微信页装修</a></li>
                    </ul>
                </li>
                <li class="text-center text-danger m-t-20">以下为框架组件演示</li>
                <li><a href="javascript:;" onclick="TabControlAppend('200','时间控件演示','datepicker.html')"><i class="fa fa-chain"></i> <span>时间控件演示</span></a></li>
                <li><a href="javascript:;" onclick="TabControlAppend('201','div弹窗演示','modal.html')"><i class="fa fa-chain"></i> <span>div弹窗演示</span></a></li>

            </ul>

        </div>
        <!-- leftpanelinner -->
    </div>
    <!-- leftpanel -->

    <div class="mainpanel">

        <div class="headerbar">
            <div class="header-left">
                <div class="topnav">
                    <div class="logopanel">
                        <h1 class="m-r-10 m-l-10"><img src="images/dhc-logo.png" height="40">全渠道运营管理平台</h1>
                    </div>
                    <!-- logopanel -->

                </div>
            </div>

            <div class="toggle-bar-div visible-xs visible-sm">
                <a class="toggle-bars" href="#"><i class="fa fa-bars"></i></a>
            </div>
            <div class="header-right hidden-xs">

                <ul class="headermenu">
                    <li>
                        <div class="btn-group">
                            <button class="btn btn-default  tp-icon" >
                                <i class="fa fa-sitemap"></i>
                                商品部
                            </button>
                        </div>
                    </li>
                    <li>
                        <div class="btn-group">
                            <button class="btn btn-default tp-icon">
                                <i class="fa  fa-graduation-cap"></i>
                               部门经理
                            </button>
                        </div>
                    </li>
                    <li>
                        <div class="btn-group">
                            <button type="button" class="btn btn-default tp-icon dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-user"></i>
                                张宏川
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu dropdown-menu-usermenu pull-right">
                                <li><a href="#"><i class="fa fa-user"></i> 修改密码</a></li>
                                <li><a href="locked.html"><i class="fa fa-sign-out"></i> 注销</a></li>
                                <li><a href="${_base}/admin/logout"><i class="fa fa-sign-out"></i> 退出</a></li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
            <!-- header-right -->

        </div>
        <!-- headerbar -->
            <div class="tab-control">
                <!-- 标签 -->
                <div class="tab simple">
                    <form>
                        <input class="prev" type="button">
                        <input class="next" type="button">
                        <input class="find" type="button">
                    </form>
                    <ul>
                        <!-- <li>标签<a href="javascript:;">关闭</a></li> -->
                        <li index="0" tab="首页" class="hover" style="">首页<a href="javascript:;">关闭</a></li>
                    </ul>
                </div>
                <!-- 标签查找 -->
                <div class="tab-find hidden">
                    <form>
                        <input class="text" type="text">
                    </form>
                    <ul>
                        <!-- <li>标签<a href="javascript:;">关闭</a></li> -->
                        <li index="0" tab="首页">首页<a href="javascript:;">关闭</a></li></ul>
                </div>
                <!-- 主体 -->
                <div class="main">
                    <!-- <iframe scrolling="auto" frameborder="0"></iframe>-->
                    <iframe src="${_base}/jsp/index/home-page.jsp" scrolling="auto" frameborder="0" reload="undefined" class="" style="height:100%"></iframe>
                </div>
            </div>
        <!-- contentpanel -->

    </div>
    <!-- mainpanel -->

    <div class="footerpanel">
        版权所有<i class="fa fa-copyright"></i>大连华信
    </div>
</section>
<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button aria-hidden="true" data-dismiss="modal" class="close" type="button">&times;</button>
                <h4 class="modal-title">Large Modal</h4>
            </div>
            <div class="modal-body">...

            </div>
            <div class="modal-footer">
                <a href="#" class="js-edit-resouce-button btn btn-success">修改</a>
                <a href="#" class="btn btn-primary" data-dismiss="modal">取消</a>
            </div>
        </div>
    </div>
</div>
<!--基础js开始-->
<script src="${_base}/js/bootstrap/jquery-1.11.1.min.js"></script>
<script src="${_base}/js/bootstrap/jquery-migrate-1.2.1.min.js"></script>
<script src="${_base}/js/bootstrap/bootstrap.min.js"></script>
<script src="${_base}/js/bootstrap/modernizr.min.js"></script>
<%-- <script src="${_base}/js/bootstrap/retina.min.js"></script> --%>
<script src="${_base}/js/bootstrap/jquery-ui-1.10.3.min.js"></script>
<script src="${_base}/js/bootstrap/custom.js"></script>

<!--基础ji结束-->
<!--当前页js开始-->
    <!--右侧tab标签-->
    <script src="${_base}/js/tab-page/tab-control.js"></script>
<!--当前页js结束-->
<script src="${_base}/js/bootstrap-modle/CommonUtil.js"></script>
<script>
//    弹窗的方法样例
        function compose(){
            loading();
            window.setTimeout(function(){
                CommonUtils.DialogUtil.setError("保存出错");
                CommonUtils.DialogUtil.show();
                window.setTimeout(function(){
                    CommonUtils.DialogUtil.showFrame("子窗口", "portal/goods/goods-pop.html", {h:400});
                    CommonUtils.DialogUtil.hide();
                },1500);
            },1500);
        }

//loading弹窗
   /*     function loading(){
            CommonUtils.DialogUtil.setLoading(2);
            CommonUtils.DialogUtil.setTitle("我是loading的标题");
            CommonUtils.DialogUtil.show();
        }*/
//错误弹窗
        function error(){
            CommonUtils.DialogUtil.setError("我是错误内容");
            CommonUtils.DialogUtil.show();
        }
//自定义内容弹窗
     /*   function othersDefine(n){
            CommonUtils.DialogUtil.setTitle("自定义标题");
            CommonUtils.DialogUtil.setMsg("自定义消息自定义消息自定义消息自定义消息自定义消息自定义消息自定义消息自定义消息自定义消息自定义消息自定义消息自定义消息自定义消息自定义消息自定义消息自定义消息");
            CommonUtils.DialogUtil.setAlertClass(n);//1-错误，2-警告，3-成功，4-提示
            CommonUtils.DialogUtil.setButtonDefault();
            CommonUtils.DialogUtil.show();
        }*/
//带按钮弹窗
      /*  function othersBtn(n){
            CommonUtils.DialogUtil.setTitle("提示");
            CommonUtils.DialogUtil.setMsg("是否删除所选择的数据？");
            CommonUtils.DialogUtil.setAlertClass(4);
            CommonUtils.DialogUtil.setButton('<button class="btn btn-danger" style="margin-right:20px" onclick="delDataAjax()"><i class="fa fa-times"></i>&nbsp;删除</button><button class="btn btn-primary" data-dismiss="modal">放弃删除</button>');
            CommonUtils.DialogUtil.show();
        }*/
//警告弹窗
        function othersNoBtn(n){
            CommonUtils.DialogUtil.setTitle("警告");
            CommonUtils.DialogUtil.setMsg("前方高能");
            CommonUtils.DialogUtil.setAlertClass(2);
            CommonUtils.DialogUtil.setButtonNo();
            CommonUtils.DialogUtil.show();
        }

//打开弹窗
        function top_dialogFrm(title,url,parms){
            CommonUtils.DialogUtil.showFrame(title,url,parms);
        }
//关闭弹窗
        function top_dialogFrm_close(){
            CommonUtils.DialogUtil.closeFrame();
        }

function othersBtn(idea,content,order,btn){
    CommonUtils.DialogUtil.setTitle(idea,content,order,btn);
    CommonUtils.DialogUtil.setMsg(content);
    CommonUtils.DialogUtil.setAlertClass(order);
    CommonUtils.DialogUtil.setButton(btn);
    CommonUtils.DialogUtil.show();
}

function othersDefine(title,content,order,btn){
    CommonUtils.DialogUtil.setTitle(title);
    CommonUtils.DialogUtil.setMsg(content);
    CommonUtils.DialogUtil.setAlertClass(order);//1-错误，2-警告，3-成功，4-提示
    CommonUtils.DialogUtil.setButton(btn);
    CommonUtils.DialogUtil.show();
}

function loading(order,title,content){
    CommonUtils.DialogUtil.setLoading(order);
    CommonUtils.DialogUtil.setTitle(title);
    CommonUtils.DialogUtil.setMsg(content);
    CommonUtils.DialogUtil.show();
}
</script>
</body>
</html>
