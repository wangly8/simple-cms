
$(function() {

	// Validation
	$("#login-form").validate( {
		// Rules for form validation
		rules : {
			userName : {
				required : true,
				minlength : 3,
				maxlength : 20
			},
			passWord : {
				required : true,
				minlength : 3,
				maxlength : 20
			}
		},
		submitHandler : function(form) {
			submitForm();
		},
		// Messages for form validation
		messages : {
			userName : {
				required : '请输入用户名',
				minlength : '用户名至少输入3个字符',
				maxlength : '用户名最多输入20个字符'
			},
			passWord : {
				required : '请输入密码',
				minlength : '密码至少输入3个字符',
				maxlength : '密码最多输入20个字符'
			}
		},
        onfocusout: false
	});
});

submitForm = function(){
	$.ajax({
        method: "POST",
        url:  _base+"/admin/login",
        dataType: "json",
        showWait: true,
        async: false,
        data: $('#login-form').serialize(),
        success: function (data) {
        	if(data.success){
        		if(data.data!=null && data.data.isRedirect){
        			window.location.href = _base+data.data.redirectUrl;
        		}else{
        			$.messager.alert("提示信息",data.message);
        		}
        	}else{
        		$.messager.alert("错误信息",data.message);
        	}
        },
        error:function(XMLResponse){$.messager.alert(XMLResponse.responseText)}
    });
}