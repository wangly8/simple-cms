
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
			$(form).ajaxSubmit( {
				beforeSubmit : showRequest,
				success : showResponse,
				url : 'login.htm',
				type : "post",
				dataType : "json",
				resetForm : false
			});
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

		// Do not change code below
		errorPlacement : function(error, element) {
            error.insertAfter(element.parent())
		},
		/* 重写错误显示消息方法,以alert方式弹出错误消息 */  
        showErrors: function(errorMap, errorList) {  
            var msg = "";  
            $.each( errorList, function(i,v){  
              msg += (v.message+"\r\n");  
            });  
            if(msg!="") alert(msg);  
        }
	});
});