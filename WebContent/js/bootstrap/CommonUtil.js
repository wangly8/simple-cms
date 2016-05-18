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
    var CommonUtils = {};
    CommonUtils.StringVar = {
           //记录字符串变量
           "defaultTitle": "\u6E29\u99A8\u63D0\u793A",//温馨提示
           "disableDelBtn": '<button class="btn btn-warning btn-xs" type="button" disabled="disabled"><i class="fa fa-times"></i>&nbsp;\u5220\u9664</button>',//删除
           "defaultBtn": '<button class="btn btn-primary" data-dismiss="modal">\u786E\u5B9A</button>'//确定
       };
    window.CommonUtils = CommonUtils;
})(window);

//对话框类
(function(comm){
    comm.DialogUtil = {
        "commVar": null, //记录初始化的各种变量
        "document": $("body"),
        "init": function(){
            if(comm.DialogUtil.commVar == null){
                var _commonobj = $("#modalDialog_common");
                if(_commonobj.length == 0){
                    //如果无dialog的HTML代码，则需要追加到body中。
                    comm.DialogUtil.document.append(comm.DialogUtil.dialogHTML);
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
                comm.DialogUtil.commVar = {
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
                                    '<h4 class="modal-title">' + CommonUtils.StringVar.defaultTitle + '</h4>' +
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
        "show": function(objTitle){
            comm.DialogUtil.init();
            comm.DialogUtil.disposeFrame();//关闭Frame的window.resize
            comm.DialogUtil.commVar.objCommon.modal("show");
            comm.DialogUtil.document.addClass("modal-open").prop("style").removeProperty("padding-right");
        },
        "hide": function(objTitle){
            comm.DialogUtil.init();
            comm.DialogUtil.commVar.objCommon.modal("hide");
            //判断是否其他dialog开启，如果有，则给Body加上modal-open，否则dialog无法滚动。
            window.setTimeout(function(){
                if($(".fade.in").length > 0){
                    comm.DialogUtil.document.addClass("modal-open");
                }
            },500);
        },
        "setContent": function(obj, html){
            //设置指定对象的内容
            obj.html(html);
        },
        "setTitle": function(title){
            //设置标题
            comm.DialogUtil.init();
            comm.DialogUtil.setContent(comm.DialogUtil.commVar.objTitle, title);
        },
        "setMsg": function(msg){
            //设置信息
            comm.DialogUtil.init();
            comm.DialogUtil.setContent(comm.DialogUtil.commVar.objMsg, msg);
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
            comm.DialogUtil.init();
            comm.DialogUtil.commVar.objMsgContainer.prop("className", ico_class[mode][0]);
            comm.DialogUtil.commVar.objMsgIco.prop("className", ico_class[mode][1]);
        },
        "setButton": function(html){
            //设置按钮
            comm.DialogUtil.init();
            comm.DialogUtil.setContent(comm.DialogUtil.commVar.objFoot, html);
        },
        "setButtonNo": function(html){
            comm.DialogUtil.init();
            comm.DialogUtil.commVar.objFoot.empty();
        },
        "setButtonDefault": function(){
            comm.DialogUtil.init();
            comm.DialogUtil.setButton(comm.StringVar.defaultBtn);
        },
        "setLoading": function(type){
            //1-读取，2-提交
            if(type == 1){
                html = "\u6B63\u5728\u8BFB\u53D6\u6570\u636E\uFF0C\u8BF7\u8010\u5FC3\u7B49\u5019\u2026\u2026";//正在读取数据，请耐心等候……
            }else{
                html = "\u6B63\u5728\u63D0\u4EA4\u6570\u636E\uFF0C\u8BF7\u8010\u5FC3\u7B49\u5019\u2026\u2026";//正在提交数据，请耐心等候……
            }
            comm.DialogUtil.init();
            comm.DialogUtil.setTitle(CommonUtils.StringVar.defaultTitle);
            comm.DialogUtil.setMsg(html + "<i class=\"fa fa-cog fa-spin fa-2x\"></i>");
            comm.DialogUtil.commVar.objMsgContainer.prop("className", "alert alert-info");
            comm.DialogUtil.commVar.objMsgIco.prop("className", "fa fa-cog fa-spin fa-2x");
            comm.DialogUtil.setButtonNo();
        },
        "setDelete": function(len){
            comm.DialogUtil.init();
            comm.DialogUtil.setTitle("\u5220\u9664\u786E\u8BA4");//删除确认
            //确定要删除所选择的&nbsp;<b>" + len + "条</b>&nbsp;数据吗？
            comm.DialogUtil.setMsg("\u786E\u5B9A\u8981\u5220\u9664\u6240\u9009\u62E9\u7684&nbsp;<b>" + len + "\u6761</b>&nbsp;\u6570\u636E\u5417\uFF1F<i class=\"fa fa-quote-right fa-2x\" style=\"margin-left:10px\"></i>");
            comm.DialogUtil.commVar.objMsgContainer.prop("className", "alert alert-info");
            comm.DialogUtil.commVar.objMsgIco.prop("className", "fa fa-quote-left fa-2x");
            //删除 && 放弃删除
            comm.DialogUtil.setButton('<button class="btn btn-danger" style="margin-right:20px" onclick="delDataAjax()"><i class="fa fa-times"></i>&nbsp;\u5220\u9664</button><button class="btn btn-primary" data-dismiss="modal">\u653E\u5F03\u5220\u9664</button>');
        },
        "setError": function(error){
            comm.DialogUtil.init();
            comm.DialogUtil.setTitle("\u9519\u8BEF\u63D0\u793A");//错误提示
            comm.DialogUtil.setMsg(error);
            comm.DialogUtil.setAlertClass(1);
            comm.DialogUtil.setButtonDefault();
        },
        "showFrame": function(title, src, size){
            //显示iframe
            //如果size.w不存在，则使用默认width，如果size.h不存在，则使用全屏高度
            comm.DialogUtil.init();
            comm.DialogUtil.disposeFrame();//关闭Frame的window.resize
            comm.DialogUtil.commVar.objFrmMain.data("parm_size", size);//将参数size缓存到对象上
            comm.DialogUtil.resizeFrame();
            comm.DialogUtil.commVar.objFrmTitle.html(title);
            comm.DialogUtil.commVar.objFrmMain.attr("src", src);
            comm.DialogUtil.commVar.objFrmContainer.modal("show");
            comm.DialogUtil.document.addClass("modal-open").prop("style").removeProperty("padding-right");
            $(window).on("resize", comm.DialogUtil.resizeFrame);
        },
        "resizeFrame": function(){
            var size = comm.DialogUtil.commVar.objFrmMain.data("parm_size");//从对象取出原始参数
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
            if(width){
                comm.DialogUtil.commVar.objFrmContainer.find(".modal-dialog:first").css({"width": width});
            }
            comm.DialogUtil.commVar.objFrmContainer.find(".modal-body:first").css({"height": height});
        },
        "hideFrame": function(){
            //显示iframe
            comm.DialogUtil.init();
            comm.DialogUtil.commVar.objFrmContainer.modal("hide").removeAttr("show");
            comm.DialogUtil.commVar.objFrmContainer.find(".modal-dialog:first").prop("style").removeProperty("width");
            comm.DialogUtil.commVar.objFrmContainer.find(".modal-Body:first").prop("style").removeProperty("height");
        },
        "closeFrame": function(){
            comm.DialogUtil.init();
            comm.DialogUtil.commVar.objFrmMain.attr("src", "about:blank");
            comm.DialogUtil.hideFrame();
            comm.DialogUtil.disposeFrame();
        },
        "disposeFrame": function(){
            //关闭Frame的window.resize
              comm.DialogUtil.commVar.objFrmMain.removeData("parm_size");
            $(window).off("resize", comm.DialogUtil.resizeFrame);//移除resize的定义
        }
    };
})(CommonUtils);