jQuery(window).load(function () {

    "use strict";
    // Page Preloader
    jQuery('#preloader').delay(350).fadeOut(function () {
       // jQuery('body').delay(350).css({'overflow': 'visible'});
    });
});

jQuery(document).ready(function () {
    "use strict";
    //datepicker
       /* $(".date-picker,.input-daterange,.datepicker-disabled-past,.datepicker-inline").datepicker({
            todayHighlight: !0,
            autoclose: !0
        })*/

    // 左侧菜单收缩
    jQuery('.leftpanel .nav-parent > a').live('click', function () {
        var parent = jQuery(this).parent();
        var sub = parent.find('> ul');
        // Dropdown works only when leftpanel is not collapsed
        if (!jQuery('body').hasClass('leftpanel-collapsed')) {
            if (sub.is(':visible')) {
                sub.slideUp(200, function () {
                    parent.removeClass('nav-active active');
                });
            } else {
                closeVisibleSubMenu();
                $(".nav-bracket").find("li.nav-parent").removeClass("active");
                parent.addClass('nav-active active');
                sub.slideDown(200, function () {
                });
            }
        }
        return false;
    });
    //无子菜单的点击
    jQuery(".nav-bracket>li>a").click(function () {
        if(jQuery(this).parent().hasClass('nav-parent')){

        }else{
            //清除二级菜单选中状态
            jQuery(".children>li").removeClass("active");
            //清除同级的当前状态
            jQuery(this).parent().siblings().removeClass("active");
            //给当前点击添加状态
            jQuery(this).parent().addClass("active");
            //一级含子菜单的收起
            closeVisibleSubMenu();
            //二级级含子菜单的收起
            closeSecondSubMenu();
        }

    })
    //二级级菜单的当前状态
    jQuery(".children > li > a").click(function(){
        jQuery(".nav-bracket").children().find("li").removeClass("active");
        //清楚所有二级菜单active
        jQuery(this).parent().siblings().removeClass("active");
        //清除一级菜单active
        jQuery(".nav-bracket").children().removeClass("active");
        jQuery(this).parent().addClass("active");
        jQuery(this).parent().parent().parent().addClass("active");
        //三级菜单隐藏
        jQuery(this).parents().siblings().find(".nav-third-children").hide(300);
        //三级菜单显示隐藏切换
        jQuery(this).siblings(".nav-third-children").toggle(300);

    })
    //三级菜单点击状态
    jQuery(".nav-third-children > li > a").click(function () {
        var s = jQuery(this);
        s.parent().siblings().removeClass("active");
        s.parent().addClass("active");
    })
    //一级含子菜单的收起
    function closeVisibleSubMenu() {
        jQuery('.leftpanel .nav-parent').each(function () {
            var t = jQuery(this);
            if (t.hasClass('nav-active active')) {
                t.find('.children').slideUp(200, function () {
                    t.removeClass('nav-active active');
                });
            }
        });
    }

    //二级级含子菜单的收起
    function closeSecondSubMenu() {
        jQuery('.nav-third').each(function () {
            var t = jQuery(this);
                t.find('.nav-third-children').slideUp(200);
        });
    }
    //判断菜单在收缩状态下超过浏览器可视区域向上展开菜单
	jQuery('.nav-bracket > li').hover(function () {
		var self = $(this), selfh = self.height();
        self.addClass('nav-hover');
        if(jQuery('body').hasClass('leftpanel-collapsed')){
            var hh = $(".headerbar").height();//获取头部高度
            var fh = $(".footerpanel").height();//获取底部高度
            var win = $(window);//获取窗体高度
            var wh = win.height()-hh-fh;//获取可视区域高度，去除头部和底部
            var ws = win.scrollTop()+30;//获取距离顶部距离
            var st = self.offset().top, sc = self.children(".children:first"), sch = sc.height();
            if(st + selfh + sch > wh + ws){
                sc.css({"top":"-" + sch + "px"});
            }
        }else{
            self.children(".children:first").css({"position":"static"});
        }

    }, function () {
        jQuery(this).removeClass('nav-hover');
    })


    // Menu Toggle
    jQuery('.menutoggle,.toggle-bars').click(function () {

        var body = jQuery('body');
        var bodypos = body.css('position');

        if (bodypos != 'relative') {

            if (!body.hasClass('leftpanel-collapsed')) {
                body.addClass('leftpanel-collapsed');
                jQuery('.nav-bracket ul').attr('style', '');

                jQuery(this).addClass('menu-collapsed');
                jQuery('.leftpanel-collapsed .leftpanel').css({width: '50px',background: 'none',overflow:'visible'});
                jQuery('.leftpanel-collapsed .leftpanel').removeClass('ps-container');
                jQuery('.leftpanel-collapsed .leftpanelinner').css({width: '50px', background: 'none !important'});
                jQuery(".leftpanel-collapsed .nav-bracket .children .active").children("ul").show();

            } else {
                body.removeClass('leftpanel-collapsed chat-view');
                jQuery('.nav-bracket li.active>ul').css({display: 'block'});
                jQuery('.leftpanel').css({width: '200px', overflow: 'hidden'});
                jQuery('.leftpanelinner').css({background: '#E4E7EA',width:'100%'});
                jQuery(this).removeClass('menu-collapsed');
                jQuery('.leftpanel').addClass('ps-container');
            }
        } else {

            if (body.hasClass('leftpanel-show'))
                body.removeClass('leftpanel-show');
            else
                body.addClass('leftpanel-show');

            // adjustmainpanelheight();
        }
    });


    reposition_topnav();
    reposition_searchform();

    jQuery(window).resize(function () {

        if (jQuery('body').css('position') == 'relative') {

            jQuery('body').removeClass('chat-view');

        } else {

            jQuery('body').removeClass('chat-relative-view');
            jQuery('body').css({left: '', marginRight: ''});
        }


        reposition_searchform();
        reposition_topnav();

    });


    /* This function will reposition search form to the left panel when viewed
     * in screens smaller than 767px and will return to top when viewed higher
     * than 767px
     */
    function reposition_searchform() {
        if (jQuery('.searchform').css('position') == 'relative') {
            jQuery('.searchform').insertBefore('.leftpanelinner .userlogged');
        } else {
            jQuery('.searchform').insertBefore('.header-right');
        }
    }


    /* This function allows top navigation menu to move to left navigation menu
     * when viewed in screens lower than 1024px and will move it back when viewed
     * higher than 1024px
     */
    function reposition_topnav() {
        if (jQuery('.nav-horizontal').length > 0) {

            // top navigation move to left nav
            // .nav-horizontal will set position to relative when viewed in screen below 1024
            if (jQuery('.nav-horizontal').css('position') == 'relative') {

                if (jQuery('.leftpanel .nav-bracket').length == 2) {
                    jQuery('.nav-horizontal').insertAfter('.nav-bracket:eq(1)');
                } else {
                    // only add to bottom if .nav-horizontal is not yet in the left panel
                    if (jQuery('.leftpanel .nav-horizontal').length == 0)
                        jQuery('.nav-horizontal').appendTo('.leftpanelinner');
                }

                jQuery('.nav-horizontal').css({display: 'block'})
                    .addClass('nav-pills nav-stacked nav-bracket');

                jQuery('.nav-horizontal .children').removeClass('dropdown-menu');
                jQuery('.nav-horizontal > li').each(function () {

                    jQuery(this).removeClass('open');
                    jQuery(this).find('a').removeAttr('class');
                    jQuery(this).find('a').removeAttr('data-toggle');

                });

                if (jQuery('.nav-horizontal li:last-child').has('form')) {
                    jQuery('.nav-horizontal li:last-child form').addClass('searchform').appendTo('.topnav');
                    jQuery('.nav-horizontal li:last-child').hide();
                }

            } else {
                // move nav only when .nav-horizontal is currently from leftpanel
                // that is viewed from screen size above 1024
                if (jQuery('.leftpanel .nav-horizontal').length > 0) {

                    jQuery('.nav-horizontal').removeClass('nav-pills nav-stacked nav-bracket')
                        .appendTo('.topnav');
                    jQuery('.nav-horizontal .children').addClass('dropdown-menu').removeAttr('style');
                    jQuery('.nav-horizontal li:last-child').show();
                    jQuery('.searchform').removeClass('searchform').appendTo('.nav-horizontal li:last-child .dropdown-menu');
                    jQuery('.nav-horizontal > li > a').each(function () {

                        jQuery(this).parent().removeClass('nav-active');

                        if (jQuery(this).parent().find('.dropdown-menu').length > 0) {
                            jQuery(this).attr('class', 'dropdown-toggle');
                            jQuery(this).attr('data-toggle', 'dropdown');
                        }

                    });
                }

            }

        }
    }



});


