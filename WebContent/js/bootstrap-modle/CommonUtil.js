/**
 * 通用的工具类
 * 
 * CommonUtils.TimerUtil    定时器工具类
 * CommonUtils.StringUtil    String工具类
 * CommonUtils.AjaxUtil    Ajax工具类
 * CommonUtils.DialogUtil    ModelDialog工具类
 * 
 * 扩展方式：
 * (function(comm){
 *        comm.工具类名 = {
 *            "方法名1": function(){},
 *            "方法名2": function(){}
 *        };
 * })(CommonUtils);
 * 
 * @author BBF
 * */
(function(){
	'use strict';
    var CommonUtils = {};
    CommonUtils.StringVar = {
           //记录字符串变量
           "defaultTitle": "\u6E29\u99A8\u63D0\u793A",//温馨提示
           "disableDelBtn": '<button class="btn btn-warning btn-xs" type="button" disabled="disabled"><i class="fa fa-times"></i>&nbsp;\u5220\u9664</button>',//删除
           "defaultBtn": '<button class="btn btn-primary" data-dismiss="modal">\u786E\u5B9A</button>'//确定
       };
    window.CommonUtils = CommonUtils;
})(window);

//计时器类
(function(comm){
	'use strict';
    comm.TimerUtil = {
        "timer": new Date(), //通用计时器对象暂存
        "clearTimeout": function(){
            window.clearTimeout(comm.TimerUtil.timer);
        },
        "clearInterval": function(){
            window.clearInterval(comm.TimerUtil.timer);
        },
        "tipBlockTime": 1000, //阻塞时间，单位毫秒
        "getTimeInterval": function(startTime){
            //如果AJAX返回的时间小于阻塞时间，则将结果暂时隐藏。此处返回0，表示禁止阻塞
            var diff = new Date().valueOf() - startTime.valueOf(), tbt = comm.TimerUtil.tipBlockTime;
            return diff > tbt ? 0 : tbt - diff;
        }
    };
})(CommonUtils);

//字符串类
(function(comm){
	'use strict';
    comm.StringUtil = {
        "trim": function(str){
           return str.replace(/(^\s*)|(\s*$)/g, ''); 
        },
        "lTrim": function(str){
           return str.replace(/(^\s*)/g, ''); 
        },
        "rTrim": function(str){
           return str.replace(/(\s*$)/g, ''); 
        },
        "isNull": function(str){
            return !!(typeof str == 'undefined' || str == null);
        },
        "killNull": function(str){
            if(this.isNull(str)){
                return "";
            }
        },
        "isBlank": function(str){
            return !!(typeof str == 'undefined' || str == null || comm.StringUtil.trim(str) == '');
        },
        "isNotBlank": function(str){
            return !this.isBlank(str);
        },
        "isNumber": function(str) {
            if(typeof str == 'undefined' || str == null || comm.StringUtil.trim(str) == ''){
                return false;
            }
            return (/^\d*$/g).test(str);
        },
        "randomWord": function(len, randlen){
            //产生任意长度随机字母数字组合
            //len - 密码长度，randlen - 附加随机长度
            var str = [], range = len;
            var arr = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz", arrlen = arr.length;
            //随机产生
            if(randlen > 0){
                range = Math.round(Math.random() * randlen) + len;
            }
            arrlen--;
            for(var i = 0; i < range; i++){
                var pos = Math.round(Math.random() * arrlen);
                str.push(arr[pos]);
            }
            str = str.join("");
            return str;
        }
    };
})(CommonUtils);

//AJAX类
(function(comm){
	'use strict';
    comm.AjaxUtil = {
        "CommonLoadData": function(url, currPage, parm, callback){
            //通过ajax读取数据
            if(!currPage){
                currPage = 1;
            }
            window.scrollTo(0,0);
            $("#tableList").LoadData("table", {
                "url": url,
                "parm": parm,
                "page": {
                    "pageIndex": currPage,
                    "pageSize": PageSize
                }, "callback": {
                    "success": function (obj, opt, num) {
                        callback && callback(obj, opt, num);
                    },
                    "nodata": function (obj) {
                        //console.log("nodata");
                    }
                }
            }, function () {
            });
        },
        "CommonDelData": function(){
            //删除前的检验
			var Dialog = comm.DialogUtil;
            if(CHECK_IDS.length == 0){
                Dialog.setTitle(comm.StringVar.defaultTitle);
                Dialog.setMsg("\u8BF7\u5148\u9009\u62E9\u6570\u636E\u540E\uFF0C\u518D\u64CD\u4F5C\uFF01");//请先选择数据后，再操作！
                Dialog.setAlertClass(1);
                Dialog.setButtonDefault();
                Dialog.show();
            }else{
                Dialog.setDelete(CHECK_IDS.length);
                Dialog.show();
            }
        },
        "CommonAjaxData": function(url, parm, conf){
            /*
             * 通用保存数据 
             * url -- ajax的路径
             * parm -- ajax提交的参数
             * conf  -- 配置参数，见函数内部 defaults 定义
             */
            var defaults = {
                "autoCloseModal": true, //自动关闭提示
                "lazyTime": 1000, // successCallback 延迟执行的时间，毫秒
                "loadingTitle": "\u8F7D\u5165\u4E2D...", // loading的标题，<载入中...>
                "loadingType": 1, //1 - 读取，2 - 提交
                "msgTitle": comm.StringVar.defaultTitle, // 信息标题
                "msg": "\u64CD\u4F5C\u6210\u529F\uFF01", // 信息正文，<操作成功！>
                "wrong": "\u64CD\u4F5C\u5931\u8D25\uFF01", // 返回成功但无结果的提示，<操作失败！>
                "error": "\u64CD\u4F5C\u9519\u8BEF\uFF01" , // 返回错误的提示，<操作错误！>
                "preAjaxCallback": function(){}, //Ajax调用前的回调函数
                "successCallback": function(result){}, //Ajax成功的回调函数
                "completeCallback":function(){}
            };
            var options = $.extend({}, defaults, conf);
			var Dialog = comm.DialogUtil;
            Dialog.setLoading(conf.loadingType);
            Dialog.setTitle(options.loadingTitle);
            Dialog.show();
            var startTime = new Date();
            options.preAjaxCallback && options.preAjaxCallback();
            $.ajax({
                "url": url,
                "type": "POST",
                "data": parm,
                "cache": false,
                "dataType": "json",
                "success": function(data){
                    if (data && data.success) {
                        var result = data.result;
                        if (result) {
                            window.setTimeout(function(){
                                Dialog.setTitle(options.msgTitle);
                                Dialog.setMsg(options.msg);
                                Dialog.setAlertClass(3);
                                Dialog.setButtonDefault();
                                window.setTimeout(function(){
                                    options.successCallback && options.successCallback(result);
                                    if(options.autoCloseModal){
                                        Dialog.hide();
                                    }
                                },options.lazyTime);
                            }, comm.TimerUtil.getTimeInterval(startTime));
                        }else{
                            Dialog.setError(options.wrong);
                            Dialog.show();
                        }
                    }else{
                        Dialog.setError(options.error + data.message);
                        Dialog.show();
                    }
                },
                "error": function (XMLHttpRequest, textStatus, errorThrown) {
                    Dialog.setError(textStatus + "，" + errorThrown);
                    Dialog.show();
                },
                "complete":function(){
                	options.completeCallback && options.completeCallback();
                }
            });
        }
    };
})(CommonUtils);

//对话框类
(function(comm){
	'use strict';
    comm.DialogUtil = {
        "commVar": null, //记录初始化的各种变量
        "document": null,
        "init": function(){
        	var that = comm.DialogUtil;
        	if(that.document == null){
        		that.document = $("body");
        		/*
        		 * 修复bootstrap.js#modal的一个问题，描述如下：
        		 * 如果页面有滚动条，窗口A打开后，body加入padding-right:17px，（17px是滚动条宽度）
        		 * 在窗口A中触发事件，显示窗口B，自动关闭窗口A，
        		 * 此时，关闭窗口B，body的padding-right = 34px，
        		 * 重复多次，padding-right会不断累加。
        		 * 
        		 * 针对此情况，重写了resetScrollbar，将每次的padding-right设置为0
        		 */
        		var bootstarpModal = $.fn.modal.Constructor;
        		bootstarpModal.prototype.resetScrollbar = function () {
        			this.$body.css('padding-right', '');
        		}
        	}
            if(that.commVar == null){
                var _commonobj = $("#modalDialog_common");
                if(_commonobj.length == 0){
                    //如果无dialog的HTML代码，则需要追加到body中。
                    that.document.append(that.dialogHTML);
                    _commonobj = $("#modalDialog_common");
                }
                var _title = _commonobj.find(".modal-title:first");
                var _body = _commonobj.find(".modal-body:first");
                var _foot = _body.next();
                var _msgContainer = _body.children(".alert:first");
                var _msg = _msgContainer.children("span:first");
                var _msgIco = _msg.prev();
                var _frmobj = $("#modalDialog_common_frm");
                var _frmtitle = _frmobj.find(".modal-title:first");
                var _frmmain = _frmobj.find("iframe:first");
                that.commVar = {
                    "objCommon": _commonobj,
                    "objTitle": _title,
                    "objBody": _body,
                    "objFoot": _foot,
                    "objMsgContainer": _msgContainer,
                    "objMsg": _msg,
                    "objMsgIco": _msgIco,
                    "objFrmContainer": _frmobj,
                    "objFrmTitle": _frmtitle,
                    "objFrmMain": _frmmain
                };
            }
        },
        "dialogHTML": '<div class="modal fade item-delete-modal-static" tabindex="-1" id="modalDialog_common" data-backdrop="static">' +
                        '<div class="modal-dialog">' +
                            '<div class="modal-content">' +
                                '<div class="modal-header">' +
                                    '<button aria-hidden="true" data-dismiss="modal" class="close" type="button">&#215;</button>' +
                                    '<h4 class="modal-title">' + comm.StringVar.defaultTitle + '</h4>' +
                                '</div>' +
                                '<div class="modal-body">' +
                                    '<div class="alert alert-danger">' +
                                        '<i class="fa fa-remove fa-2x"></i><span style="margin-left:10px"></span>' +
                                    '</div>' +
                                '</div>' +
                                '<div class="modal-footer text-center">' +
                                    '<button class="btn btn-primary" data-dismiss="modal">\u786E\u5B9A</button>' + //确定
                                '</div>' +
                            '</div>' +
                        '</div>' +
                    '</div>' +
                    '<div class="modal fade item-delete-modal-static" tabindex="-1" id="modalDialog_common_frm" data-backdrop="static">' +
                        '<div class="modal-dialog">' +
                            '<div class="modal-content">' +
                                '<div class="modal-header">' +
                                    '<button aria-hidden="true" data-dismiss="modal" class="close" type="button">&#215;</button>' +
                                    '<h4 class="modal-title"></h4>' +
                                '</div>' +
                                '<div class="modal-body"><iframe src="about:blank" style="border:0;width:100%;height:100%"></iframe></div>' +
                            '</div>' +
                        '</div>' +
                    '</div>',
        "show": function(){
            var that = comm.DialogUtil;
            that.init();
            that.disposeFrame();//关闭Frame的window.resize
            that.commVar.objCommon.modal("show");
            window.setTimeout(function(){
            	that.document.addClass("modal-open").prop("style").removeProperty("padding-right");
            },600);
        },
        "hide": function(){
            var that = comm.DialogUtil;
            that.init();
            that.commVar.objCommon.modal("hide");
            //判断是否其他dialog开启，如果有，则给Body加上modal-open，否则dialog无法滚动。
            window.setTimeout(function(){
                if($(".fade.in").length > 0){
                    that.document.addClass("modal-open");
                }
            },600);
        },
        "setContent": function(obj, html){
            //设置指定对象的内容
            obj.html(html);
        },
        "setTitle": function(title){
            //设置标题
            var that = comm.DialogUtil;
            that.init();
            that.setContent(that.commVar.objTitle, title);
        },
        "setMsg": function(msg){
            //设置信息
            var that = comm.DialogUtil;
            that.init();
            that.setContent(that.commVar.objMsg, msg);
        },
        "setAlertClass": function(mode){
            //设置提示信息的class
            //1-错误，2-警告，3-成功，4-提示
            var ico_class = [
                    ["alert alert-danger","fa fa-times-circle fa-2x"],
                    ["alert alert-warning","fa fa-exclamation-circle fa-2x"],
                    ["alert alert-success","fa fa-check-circle fa-2x"],
                    ["alert alert-info","fa fa-question-circle fa-2x"]
                ];
            if(mode > 4 || mode < 1){
                mode = 1;
            }
            --mode;
            var that = comm.DialogUtil;
            that.init();
            that.commVar.objMsgContainer.prop("className", ico_class[mode][0]);
            that.commVar.objMsgIco.prop("className", ico_class[mode][1]);
        },
        "setButton": function(html){
            //设置按钮
            var that = comm.DialogUtil;
            that.init();
            that.setContent(that.commVar.objFoot, html);
        },
        "setButtonNo": function(){
            var that = comm.DialogUtil;
            that.init();
            that.commVar.objFoot.empty();
        },
        "setButtonDefault": function(){
            var that = comm.DialogUtil;
            that.init();
            that.setButton(comm.StringVar.defaultBtn);
        },
        "setLoading": function(type){
            //1-读取，2-提交
        	var html = "\u6B63\u5728\u63D0\u4EA4\u6570\u636E\uFF0C\u8BF7\u8010\u5FC3\u7B49\u5019\u2026\u2026";//正在提交数据，请耐心等候……
            if(type == 1){
                html = "\u6B63\u5728\u8BFB\u53D6\u6570\u636E\uFF0C\u8BF7\u8010\u5FC3\u7B49\u5019\u2026\u2026";//正在读取数据，请耐心等候……
            }
            var that = comm.DialogUtil;
            that.init();
            that.setTitle(comm.StringVar.defaultTitle);
            that.setMsg(html + "<i class=\"fa fa-cog fa-spin fa-2x\"></i>");
            that.commVar.objMsgContainer.prop("className", "alert alert-info");
            that.commVar.objMsgIco.prop("className", "fa fa-cog fa-spin fa-2x");
            that.setButtonNo();
        },
        "setDelete": function(len){
            var that = comm.DialogUtil;
            that.init();
            that.setTitle("\u5220\u9664\u786E\u8BA4");//删除确认
            //确定要删除所选择的&nbsp;<b>" + len + "条</b>&nbsp;数据吗？
            that.setMsg("\u786E\u5B9A\u8981\u5220\u9664\u6240\u9009\u62E9\u7684&nbsp;<b>" + len + "\u6761</b>&nbsp;\u6570\u636E\u5417\uFF1F<i class=\"fa fa-quote-right fa-2x\" style=\"margin-left:10px\"></i>");
            that.commVar.objMsgContainer.prop("className", "alert alert-info");
            that.commVar.objMsgIco.prop("className", "fa fa-quote-left fa-2x");
            //删除 && 放弃删除
            that.setButton('<button class="btn btn-danger" style="margin-right:20px" onclick="delDataAjax()"><i class="fa fa-times"></i>&nbsp;\u5220\u9664</button><button class="btn btn-primary" data-dismiss="modal">\u653E\u5F03\u5220\u9664</button>');
        },
        "setError": function(error){
            var that = comm.DialogUtil;
            that.init();
            that.setTitle("\u9519\u8BEF\u63D0\u793A");//错误提示
            that.setMsg(error);
            that.setAlertClass(1);
            that.setButtonDefault();
        },
        "showFrame": function(title, src, size){
            //显示iframe
            //如果size.w不存在，则使用默认width，如果size.h不存在，则使用全屏高度
            var that = comm.DialogUtil;
            that.init();
            var thatVar = that.commVar;
            that.disposeFrame();//关闭Frame的window.resize
            thatVar.objFrmMain.data("parm_size", size);//将参数size缓存到对象上
            that.resizeFrame();
            thatVar.objFrmTitle.html(title);
            thatVar.objFrmMain.attr("src", src);
            thatVar.objFrmContainer.modal("show");
            that.document.addClass("modal-open").prop("style").removeProperty("padding-right");
            $(window).on("resize", that.resizeFrame);
        },
        "resizeFrame": function(){
        	var that = comm.DialogUtil, size = that.commVar.objFrmMain.data("parm_size");//从对象取出原始参数
            var win = $(window), _h = win.height() - 120, _w = win.width();
            var width = size.w, height = size.h;
            if(!!width){
                if(width > _w){
                    width = _w;
                }
            }
            //100 = modal-objTitle(60) + modal-Body.padding(15*2) + modal-dialog.margin(15*2)
            if(!!height){
                if(height > _h){
                    height = _h;
                }
            }else{
                height = _h;
            }
            var thatFrm = that.commVar.objFrmContainer;
            if(width){
            	thatFrm.find(".modal-dialog:first").css({"width": width});
            }else{
            	thatFrm.find(".modal-dialog:first").prop("style").removeProperty("width");
            }
            thatFrm.find(".modal-body:first").css({"height": height});
        },
        "hideFrame": function(){
            //显示iframe
            var that = comm.DialogUtil;
            that.init();
            var thatFrm = that.commVar.objFrmContainer;
            thatFrm.modal("hide").removeAttr("show");
            thatFrm.find(".modal-dialog:first").prop("style").removeProperty("width");
            thatFrm.find(".modal-Body:first").prop("style").removeProperty("height");
        },
        "closeFrame": function(){
            var that = comm.DialogUtil;
            that.init();
            that.commVar.objFrmMain.attr("src", "about:blank");
            that.hideFrame();
            that.disposeFrame();
        },
        "disposeFrame": function(){
            //关闭Frame的window.resize
        	var that = comm.DialogUtil;
            that.commVar.objFrmMain.removeData("parm_size");
            $(window).off("resize", that.resizeFrame);//移除resize的定义
        }
    };
})(CommonUtils);