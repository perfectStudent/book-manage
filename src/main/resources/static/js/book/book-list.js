layui.use(['jquery', 'laypage', 'layer', 'table', 'element'], function () {
    var laypage = layui.laypage //分页
        , layer = layui.layer //弹层
        , table = layui.table //表格
        , $ = layui.jquery //jquery
        , element = layui.element //元素操作
        , form = layui.form //表单

    //执行一个 table 实例
    var tableIndex = table.render({
        id: 'bookListTable',
        elem: '#book-list' //填写id
        , height: 'full-100'
        , url: '/books' //数据接口
        , title: '用户表'
        , page: true //开启分页
        // ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
        , cols: [[ //表头
            {type: 'checkbox', fixed: 'left'}
            // ,{field: 'username', title: '用户名', width:120,templet:function(d){
            //         return '<div><a href="#" target="_blank"><img height="150" src="http://book.img.ireader.com/idc_1/m_1,w_117,h_156,q_100/1ed97056/group61/M00/61/1C/CmQUOV3qCCCED8ffAAAAADyo0VE790657608.jpg?v=Ud3g9MGg&t=CmQUOV37QKg."  /></a></div>';}}
            , {field: 'bookId', title: 'ID', width: 60,hide:true}
            , {field: 'bookName', title: '书名', width: 100}
            , {field: 'author', title: '作者', width: 100}
            , {field: 'type', title: '分类Id', width: 120,hide:true}
            , {field: 'typeName', title: '分类', width: 120,templet:function(d){
                return d.typeModel.typeName;
            }}
            , {field: 'price', title: '价格', width: 80}
            , {field: 'press', title: '出版社', width: 130}
            , {field: 'number', title: '数量', width: 80}
            , {field: 'isbn', title: '标准书号', width: 120}
            , {field: 'cover', title: '封面', width: 100}
            , {field: 'describe', title: '描述', width: 260}
            , {fixed: 'right', width: 165, align: 'center', toolbar: '#book-list-bar'}  //每行的操作按钮
        ]]
    });


    //监听行工具事件
    table.on('tool(book-list-filter)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data //获得当前行数据
            , layEvent = obj.event; //获得 lay-event 对应的值
        if (layEvent === 'detail') {
            detailBook(data);
            // layer.msg('查看操作');
        } else if (layEvent === 'del') {
            layer.confirm('真的删除行么', function (index) {
                // obj.del(); //删除对应行（tr）的DOM结构
                // layer.close(index);
                //向服务端发送删除指令
                deleteBooks(data, index);
            });
        } else if (layEvent === 'edit') {
            addBook(data);
            layer.msg('编辑操作');
        }
    });

    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click", function () {
        if ($(".searchVal").val() != '') {
            table.reload("bookListTable", {
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

    //添加图书
    function addBook(edit) {
        var index = layui.layer.open({
            title: "添加图书",
            type: 2,
            content: ['/book-add.html', 'no'],
            area: ['700px', '600px'],
            success: function (layero, index) {
                form.render();
                var body = layui.layer.getChildFrame('body', index);
                if (edit) {
                    body.find(".bookId").val(edit.bookId);
                    body.find(".bookName").val(edit.bookName);
                    body.find(".author").val(edit.author);
                    body.find(".type select").val(edit.type);
                    body.find(".price").val(edit.price);
                    body.find(".press").val(edit.press);
                    body.find(".number").val(edit.number);
                    body.find(".isbn").val(edit.isbn);
                    body.find(".cover").attr("src", edit.cover);
                    body.find(".describe").val(edit.describe);
                    form.render();
                }
                setTimeout(function () {
                    layui.layer.tips('点击此处返回图书列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                }, 500)
            }
        })

    }


    function detailBook(data){
        console.log(data)
        var index = layui.layer.open({
            title: "查看图书",
            type: 2,
            content: ['/book-detail.html', 'no'],
            area: ['700px', '600px'],
            success: function (layero, index) {
                form.render();
                var body = layui.layer.getChildFrame('body', index);
                    body.find(".bookId").val(data.bookId);
                    body.find(".bookName").val(data.bookName);
                    body.find(".author").val(data.author);
                    body.find(".type").val(data.typeModel.typeName);
                    body.find(".price").val(data.price);
                    body.find(".press").val(data.press);
                    body.find(".number").val(data.number);
                    body.find(".isbn").val(data.isbn);
                    body.find(".cover").attr("src", data.cover);
                    body.find(".describe").val(data.describe);
                    form.render();
                setTimeout(function () {
                    layui.layer.tips('点击此处返回图书列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                }, 500)
            }
        })
    }


    $(".addBook_btn").click(function () {
        addBook();
    })

    //批量删除
    $(".delAll_btn").click(function () {
        var checkStatus = table.checkStatus('bookListTable'),
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
        var checkStatus = table.checkStatus('bookListTable'),
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

});