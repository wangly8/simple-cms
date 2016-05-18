<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="tanc_cz cancel" style="display:none;z-index:12;position:fixed;">
	<div class="tanc_bg"></div>
	<div class="qux">
		<div class="qux_title">
			<p>提示信息</p>
			<i class="icon-remove" onclick="close_qx()"></i>
		</div>
		<div class="qux_nr">
			<p>取消原因：</p>
			<span><textarea name="reason"></textarea></span>
		</div>
		<div class="tanc_qx">
			<ul>
				<li><button class="btn sc1" onclick="confirm_qx()">确认</button></li>
				<li><button class="btnh sc1" onclick="close_qx()">关闭</button></li>
			</ul>
		</div>
	</div>
</div>