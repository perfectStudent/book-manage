//JavaScript代码区域
layui.use(['element','jquery'], function(){
    var element = layui.element
        ,$=layui.jquery ;
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
});
