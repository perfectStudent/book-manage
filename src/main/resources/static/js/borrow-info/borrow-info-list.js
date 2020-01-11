layui.use(['jquery', 'laypage', 'layer', 'table', 'element', 'util','form'], function () {
    var laypage = layui.laypage //分页
        , layer = layui.layer //弹层
        , table = layui.table //表格
        , $ = layui.jquery //jquery
        , element = layui.element //元素操作
        , util = layui.util //工具
        , form = layui.form //表单
    //执行一个 table 实例
    var tableIndex = table.render({
        id: 'borrowInfoListTable',
        elem: '#borrow-info-list' //填写id
        , height: 'full-100'
        , url: '/borrowInfos' //数据接口
        , title: '用户表'
        , page: true //开启分页
        // ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
        , cols: [[ //表头
            {type: 'checkbox', fixed: 'left'}
            , {field: 'borrowId', title: '借阅订单号',align: 'center', width: 100,hide: true}
            , {field: 'readerId', title: '读者ID',align: 'center', width: 100}
            , {field: 'name', title: '读者姓名', align: 'center', width: 120, templet: function (d) {
                    return d.reader.name;
                }}
            , {field: 'bookId', title: '书本ID', width: 80, hide: true}
            , {field: 'bookName', title: '书名', align: 'center', width: 120, templet: function (d) {
                    return d.book.bookName;
                }}
            , {field: 'beOverdue', title: '是否逾期', align: 'center', width: 120, templet: function (d) {
                    return d.beOverdue ? '<span class=\"layui-red\">是</span>' : '否';
                }}

            , {field: 'borrowId', title: 'ID', width: 60, hide: true}
            , {field: 'lendTime', title: '借书时间', align: 'center', width: 180, templet: function (d) {
                    return util.toDateString(d.lendTime, 'yyyy-MM-dd HH:mm:ss')
                }}
            , {field: 'giveBackTime', align: 'center', title: '到期时间', width: 180, templet: function (d) {
                    return util.toDateString(d.giveBackTime, 'yyyy-MM-dd HH:mm:ss')
                }}
            , {field: 'beOverdueDay', title: '逾期天数', align: 'center', width: 120}
            , {field: 'fine', title: '罚款', align: 'center', width: 100,templet: function (d) {
                    return d.fine+'元';
                }}
            , {fixed: 'right',title:'是否归还', width: 165, align: 'center', toolbar: '#borrow-info-bar'}  //每行的操作按钮
            // , {field: 'whetherLend', title: '是否归还', align: 'center', width: 120,templet: function (d) {
            //         return d.whetherLend ? '<input type=\"checkbox\" name=\"whetherLend\" lay-filter=\"whetherLend\" lay-skin=\"switch\" lay-text=\"未归还|已归还\" disabled>'
            //             :'<input type=\"checkbox\" name=\"whetherLend\" lay-filter=\"whetherLend\" lay-skin=\"switch\" lay-text=\"未归还|已归还\" checked>';
            //     }}
        ]]
    });


    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click", function () {
        if ($(".searchVal").val() != '') {
            table.reload("borrowInfoListTable", {
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    keyword: $(".searchVal").val()  //搜索的关键字
                }
            })
        } else {
            layer.msg("请输入搜索的内容");
        }
    });


    $(".addBook_btn").click(function () {
        addBook();
    })

    //批量删除
    $(".delAll_btn").click(function () {
        var checkStatus = table.checkStatus('borrowInfoListTable'),
            data = checkStatus.data;
        if (data.length > 0) {
            layer.confirm('确定删除选中的图书？', {icon: 3, title: '提示信息'}, function (index) {
                deleteBooks(data, index);
            })
        } else {
            layer.msg("请选择需要删除的图书");
        }
    })

    function deleteBooks(data, index) {
        var checkStatus = table.checkStatus('borrowInfoListTable'),
            data = checkStatus.data,
            bookId = [];
        for (var i in data) {
            bookId.push(data[i].bookId);
        };
        $.ajax({
            type: "POST",
            url: "/books",
            data: {
                _method: "DELETE",
                ids: bookId
            },
            dataType: "json",
            success: function (res) {
                tableIndex.reload();
                layer.close(index);
            }
        })
    }


    //归还图书
    form.on('switch(whetherLend)', function(data){
        // 获取当前所在行
        var parentTr = data.othis.parents("tr");
        // console.log(parentTr);
        //eq(2): 代表的是表头字段位置    .layui-table-cell: 这个元素是我找表格div找出来的
        var borrowId = $(parentTr).find("td:eq(1)").find(".layui-table-cell").text();
        var bookId = $(parentTr).find("td:eq(4)").find(".layui-table-cell").text();
        var whetherLend=true;//开关是否开启，true或者false
        $(data.elem).attr("disabled","true");
        $(data.othis).addClass("layui-checkbox-disbaled layui-disabled");
        updateLend(bookId,borrowId,whetherLend);
    });

    function updateLend(bookId,borrowId,whetherLend){
        $.ajax({
            type: "POST",
            url: "/giveBackBooks",
            data: {
                _method: "PUT",
                borrowId:borrowId,
                bookId: bookId,
                whetherLend:whetherLend
            },
            dataType: "json",
            success: function (res) {
                // tableIndex.reload();
                layer.close(index);
            }
        })
    }
});
