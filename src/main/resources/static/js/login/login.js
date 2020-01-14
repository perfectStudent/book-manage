layui.use(['element', 'jquery', 'form','layer'], function () {
    var $ = layui.jquery //jquery
        , form = layui.form//表单
        , layer = layui.layer;//弹出层
    form.render();
    form.on('submit(changeInfo)', function(data){
        register(data.field);
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });
    form.on('submit(changeLogin)', function(data){
        checkLogin(data.field);
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });
    //注册请求的方法 开始
    function register(data){
        $.post("/registerUser",{
            readerId:data.readerId,                         //账号
            password:data.password,                         //密码
            name : data.username,                               //称呼
            gender : data.gender,                        //性别
            phone : data.phone,                          //号码
            collegeId : data.collegeId,                  //学院ID
            majorId : data.majorId,                       //专业ID
            classId : data.classId                        //班级ID
        },function(res){
            var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
            if(res.code==0){
                setTimeout(function(){
                    layer.close(index);
                    window.location.href = "/login.html";
                },2000);
            }else {
                setTimeout(function(){
                    layer.close(index);
                },2000);
                layer.msg(res.msg);
            }
        });
    }
    //注册请求的方法 结束
    //注册请求的方法 开始
    function checkLogin(data){
        $.post("/checkLogin",{
            username:data.username,                         //账号
            password:data.password,                           //密码
            tag:data.tag                                    //身份
        },function(res){
            var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
            if(res.code==0){
                setTimeout(function(){
                    layer.close(index);
                    window.location.href = "/index.html";
                },1000);
            }else {
                setTimeout(function(){
                    layer.msg(res.msg);
                },1000);
            }
        });
    }
    //注册请求的方法 结束

    //监听学院下拉框开始
    form.on('select(colleges)', function(data){
        if(data.value>0){
            majorRequest(data);
        }else{
            $("#majorId option").remove();
            $("#majorId").append("<option value=''>请选择</option>");
            $("#classId option").remove();
            $("#classId").append("<option value=''>请选择</option>");
        }
    });
    //监听学院下拉框结束

    //监听专业下拉框开始
    form.on('select(major)', function(data){
        // console.log(data.value); //得到被选中的值
        // console.log(data.othis); //得到美化后的DOM对象
        if(data.value>0){
            classsRequest(data);
        }else{
            $("#classId option").remove();
            $("#classId").append("<option value=''>请选择</option>");
        }

    });
    //监听专业下拉框结束

    //获取专业列表请求
    function majorRequest(data) {
        $.get("/majors/"+data.value,{

        },function(res){
            var data=res.data;
            $("#majorId option").remove();
            $("#majorId").append("<option value=''>请选择</option>");
            if (data != 0) {
                for ( var i = 0; i < data.length; i++) {
                    var id = data[i].id;
                    var majorName = data[i].majorName;
                    $("#majorId").append("<option value="+id+">"+ majorName + "</option>");
                }
                //刷新下拉列表
                form.render('select');
            }
        });
    }
    //获取班级列表请求
    function classsRequest(data) {
        $.get("/classs/"+data.value,{

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
    }

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

