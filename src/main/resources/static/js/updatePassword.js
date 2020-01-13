//JavaScript代码区域
layui.use(['element','jquery','layer','form'], function(){
    var element = layui.element
        ,$=layui.jquery
        ,form=layui.form
        ,layer=layui.layer ;

    form.on('submit(changePassword)', function(data){
        data=data.field
        $.ajax({
            type:"POST",
            url:"/readers/updatePassword",
            data:{
                _method : "PUT",
                password : data.password,
                newPassword : data.newPassword
            },
            dataType:"json",
            success:function (res) {
               if (res.code==0){
                   layer.msg("修改成功！");
                   setTimeout(function () {
                       var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                       parent.layer.close(index);
                   }, 2000)
               }else{
                   layer.alert(res.msg);
               }
            },
            error:function (res) {
                layer.msg("服务器内部错误！");
            }
        })
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });
    window.myValidate=function () {
        var newPwd = $("input[name='newPassword']").val();
        var newPwdAgrin = $("input[name='newPasswordAgrin']").val();
        if(newPwd!=newPwdAgrin){
            $("#tips").html("密码不一致");
            $(".btn").attr("disabled","disabled");
        }else{
            $("#tips").html("");
            $(".btn").removeAttr("disabled");
        }
    }
});
