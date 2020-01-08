layui.use(['element', 'jquery', 'form'], function () {
    var $ = layui.jquery //jquery
        , form = layui.form;//表单
    form.render();
    form.on('submit(changeInfo)', function(data){
        console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
        console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });
    form.on('submit(changeLogin)', function(data){
        console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
        console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
        console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });

    //注册请求的方法 开始
    function register(data){
        $.post("/registerUser",{
            username:data.username,                                    //称呼
            readerId:data.readerId,                                //账号
            password : data.password                        //密码
        },function(res){
            if(res.code==200){
                setTimeout(function(){
                    window.location.href = "/admin/index.html";
                },1000);
            }else if(res.code=202){
                setTimeout(function(){
                    layer.msg(res.msg);
                    $("#loginBtn").text("登录").attr("disabled",false).removeClass("layui-disabled");
                },1000);
            }else {
                setTimeout(function(){
                    layer.msg(res.msg);
                    $("#loginBtn").text("登录").attr("disabled",false).removeClass("layui-disabled");
                },1000);
            }
        })
    }
    //注册请求的方法 结束

    //监听系部下拉框开始
    form.on('select(department)', function(data){
        // console.log(data.value); //得到被选中的值
        // console.log(data.othis); //得到美化后的DOM对象
        $.get("/genders/"+data.value,{

        },function(res){
            var data=res.data;
            $("#classId option").remove();
            $("#classId").append("<option value=''>请选择</option>");
            if (data != 0) {
                for ( var i = 0; i < data.length; i++) {
                    var id = data[i].id;
                    var className = data[i].className;
                    $("#classId").append("<option value="+id+">"+ className + "</option>");
                }
                //刷新下拉列表
                form.render('select');
            }
        });
    });
    //监听系部下拉框结束

});
const cards = document.querySelectorAll('.card');
const btns = document.querySelectorAll('.js-btn');
btns.forEach(btn => {btn.addEventListener('click', on_btn_click, true);
btn.addEventListener('touch', on_btn_click, true);
});

function on_btn_click(e) {
    const nextID = e.currentTarget.getAttribute('data-target');
    const next = document.getElementById(nextID);
    if (!next) return;
    bg_change(nextID);
    view_change(next);
    return false;
}

function bg_change(next) {
    document.body.className = '';
    document.body.classList.add('is-' + next);
}

function view_change(next) {
    cards.forEach(card => {card.classList.remove('is-show');
})
    ;next.classList.add('is-show');
}

