package cn.wmkfe.bookmanage.controller.api;

import cn.wmkfe.bookmanage.controller.api.admin.AbstractApiController;
import cn.wmkfe.bookmanage.model.Admin;
import cn.wmkfe.bookmanage.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class LoginController extends AbstractApiController {
    @Autowired
    private AdminService adminService;


    @RequestMapping("/checkLogin")
    public Map<String, Object> checkLogin(@RequestParam("userName") String userName
            , @RequestParam("password") String password
            , @RequestParam("tag") String tag
            , HttpSession session) {

        Map<String, Object> map = null;
        Admin adminOne = adminService.getAdminOne(userName);
        if (adminOne != null && adminOne.getAdminId().equals(password)) {
            adminOne.setPassword(null);
            session.setAttribute("user", adminOne);
            map = this.resultJson("0", "success", null);
            return map;
        }
        map = this.resultJson("-2", "用户名或密码错误！", null);
        return map;
    }

}
