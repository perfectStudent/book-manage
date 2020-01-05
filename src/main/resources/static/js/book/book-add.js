layui.use(['jquery', 'laypage', 'layer', 'table', 'upload', 'form','element'], function(){
    var laypage = layui.laypage //分页
        ,layer = layui.layer //弹层
        ,form = layui.form //表单
        ,$ = layui.jquery //jquery
        ,upload = layui.upload //jquery
        ,element = layui.element //元素操作
        form.render();

    //上传缩略图
    upload.render({
        elem: '.thumbBox',
        url: '../../json/userface.json',
        method : "get",  //此处是为了演示之用，实际使用中请将此删除，默认用post方式提交
        done: function(res, index, upload){
            $('.thumbImg').attr('src',"http://book.img.ireader.com/idc_1/m_1,w_117,h_156,q_100/1ed97056/group61/M00/61/1C/CmQUOV3qCCCED8ffAAAAADyo0VE790657608.jpg?v=Ud3g9MGg&t=CmQUOV37QKg.");
            $('.thumbBox').css("background","#fff");
        }
    });


    form.on('submit(changeBook)', function(data){
        // console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
        // console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
        // console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
        if (data.field.bookId) {
            updateBooks(data.field);
        }else {
            addBooks(data.field);
        }
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });

    //数据校验
    form.verify({

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
                // tableIndex.reload();
                parent.layui.table.reload('bookListTable');
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
                parent.layui.table.reload('bookListTable');
            }
        })
    }

})