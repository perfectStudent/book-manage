package cn.wmkfe.bookmanage.controller.api;

import cn.wmkfe.bookmanage.model.Admin;
import cn.wmkfe.bookmanage.model.LoginTag;
import cn.wmkfe.bookmanage.model.Reader;
import cn.wmkfe.bookmanage.service.AdminService;
import cn.wmkfe.bookmanage.service.ReaderService;
import cn.wmkfe.bookmanage.util.ApiResponseEnum;
import cn.wmkfe.bookmanage.util.MD5Utils;
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
    @Autowired
    private ReaderService readerService;
    @RequestMapping("/checkLogin")
    public Map<String, Object> checkLogin(@RequestParam("username") String username
                                        , @RequestParam("password") String password
                                        , @RequestParam("tag") String tag
                                        , HttpSession session) {
        if ("admin".equals(tag)){
            Admin admin = adminService.getAdminOne(username);
            if (admin != null && admin.getPassword().equals(MD5Utils.MD5Lower(username,password))) {
                admin.setPassword(null);
                session.setAttribute("loginTag", new LoginTag(admin));
                return this.resultJson(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), null);
            }
        }else{
            Reader reader = readerService.getByReaderId(username);
            if (reader != null && reader.getPassword().equals(MD5Utils.MD5Lower(username,password))) {
                reader.setPassword(null);
                session.setAttribute("loginTag", new LoginTag(reader));
                return this.resultJson(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), null);
            }
        }
        return this.resultJson(ApiResponseEnum.LOGIN_ERR.getCode(),ApiResponseEnum.LOGIN_ERR.getName(), null);
    }

    @RequestMapping("/registerUser")
    public Map<String, Object> registerUser(Reader reader) {
        Map<String, Object> map = null;
        reader.setPassword(MD5Utils.MD5Lower(reader.getReaderId(),reader.getPassword()));
        if(readerService.getByReaderId(reader.getReaderId())==null){
            //添加读者信息
            int i = readerService.addReader(reader);
            return this.resultJson(ApiResponseEnum.SUCCESS.getCode(),ApiResponseEnum.SUCCESS.getName(),null);
        }
        return this.resultJson(ApiResponseEnum.FAIL.getCode(),"此账号已经存在",null);
    }

}
