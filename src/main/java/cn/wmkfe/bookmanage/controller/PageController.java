package cn.wmkfe.bookmanage.controller;

import cn.wmkfe.bookmanage.model.Type;
import cn.wmkfe.bookmanage.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class PageController {
    @Autowired
    private TypeService typeService;

    //首页
    @RequestMapping(value = {"/","/index"})
    public String indexPage(){
        return "index";
    }

    //登录页面
    @RequestMapping(value = "/login.html")
    public String loginPage(){
        return "login";
    }

    //图书列表
    @RequestMapping(value = "/book-list.html")
    public String bookListPage(){
        return "book/book-list";
    }


    //添加图书页面
    @RequestMapping(value = "/book-add.html")
    public String bookAddPage(Model model){
        List<Type> typeListAll = typeService.getTypeListAll();
        model.addAttribute("typeList",typeListAll);
        return "book/book-add";
    }
    //查看图书页面
    @RequestMapping(value = "/book-detail.html")
    public String bookDetailPage(){
        return "book/book-detail";
    }

    //借阅列表
    @RequestMapping(value = "/borrow-info-list.html")
    public  String borrowInfoListPage(){
        return "borrow-info/borrow-info-list";
    }

}
