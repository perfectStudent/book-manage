layui.use(['jquery', 'laypage', 'layer', 'table', 'upload', 'form','element'], function(){
    var laypage = layui.laypage //分页
        ,layer = layui.layer //弹层
        ,form = layui.form //表单
        ,$ = layui.jquery //jquery
        ,upload = layui.upload //jquery
        ,element = layui.element //元素操作
    //上传缩略图
    upload.render({
        elem: '.thumbBox',
        url: '/upload',
        method : "post",  //此处是为了演示之用，实际使用中请将此删除，默认用post方式提交
        done: function(res, index, upload){
            console.log(res);
            $('.thumbImg').attr('src',res.data.src);
            $('.thumbBox').css("background","#fff");
        }
    });


    form.on('submit(changeBook)', function(data){
        if (data.field.bookId) {
            updateBooks(data.field);
        }else {
            if(data.field.type==-1)
            {
                layer.msg("请选择图书类型")
                return false;
            }
            addBooks(data.field);
        }
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });

    //数据校验
    form.verify({
        types
    });

    function addBooks(data) {
        $.ajax({
            type:"POST",
            url:"/books",
            data:{
                bookName : data.bookName,  //书名
                author : data.author,      //作者
                type : data.type,
                price : data.price,         //价格
                press : data.press,         //出版社
                number : data.number,        //数量
                isbn : data.isbn,           //标准书号
                cover : $('#cover').attr("src"),         //封面
                describe : data.describe   //描述
            },
            dataType:"json",
            success:function (res) {
                var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
                setTimeout(function () {
                    layer.close(index);
                    parent.layui.table.reload('bookListTable');
                    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                    parent.layer.close(index);
                }, 2000)
            }
        })
    }

    function updateBooks(data) {
        console.log(data)
        $.ajax({
            type:"POST",
            url:"/books",
            data:{
                _method : "PUT",
                bookId : data.bookId,
                bookName : data.bookName,  //书名
                author : data.author,      //作者
                type : data.type,
                price : data.price,         //价格
                press : data.press,         //出版社
                number : data.number,        //数量
                isbn : data.isbn,           //标准书号
                cover : $('#cover').attr("src"),         //封面
                describe : data.describe   //描述
            },
            dataType:"json",
            success:function (res) {
                var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
                setTimeout(function () {
                    layer.close(index);
                    parent.layui.table.reload('bookListTable');
                    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                    parent.layer.close(index);
                }, 2000)
            }
        })
    }

})