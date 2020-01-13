//JavaScript代码区域
layui.use(['element','jquery','layer','form'], function(){
    var element = layui.element
        ,$=layui.jquery
        ,form=layui.form
        ,layer=layui.layer ;
    $(".jump_refresh_url").click(function () {
        var url = $(this).attr('href');
        refreshHighlight(url);
        // this.refreshHighlight(url);
    });

    function refreshHighlight(url) {
        $(".layui-nav[lay-filter='navList'] a").each(function (ind, val) {
            if($(this).attr('href') === url){
                $('.layui-nav dd').removeClass('layui-this');
                $(this).parent('dd').addClass('layui-this');
            }
        })
    }
    //基础资料
    $("#baseData").click(function () {
        var index = layer.open({
            title: "基本资料",
            type: 2,
            content: ['/baseData.html'],
            area: ['500px', '450px','no'],
            success: function (layero, index) {
                setTimeout(function () {
                    layui.layer.tips('点击此处返回图书列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                }, 500)
            }
        })
    });

    //修改密码
    $("#updatePassword").click(function () {
        var index = layer.open({
            title: "修改密码",
            type: 2,
            content: ['/updatePassword.html','no'],
            area: ['460px', '280px'],
            success: function (layero, index) {
                setTimeout(function () {
                    layui.layer.tips('点击此处返回图书列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                }, 500)
            }
        })
    });

});
