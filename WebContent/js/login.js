
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
		/* 重写错误显示消息方法,以alert方式弹出错误消息 */  
        showErrors: function(errorMap, errorList) {  
            var msg = "";  
            $.each( errorList, function(i,v){  
              msg += (v.message+"\r\n");  
            });  
            if(msg!="") alert(msg);  
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
        			alert(data.message);
        		}
        	}else
        		alert(data.message);
        },
        error:function(XMLResponse){alert(XMLResponse.responseText)}
    });
}