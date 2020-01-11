package cn.wmkfe.bookmanage.controller;

import cn.wmkfe.bookmanage.model.College;
import cn.wmkfe.bookmanage.model.Gender;
import cn.wmkfe.bookmanage.model.Type;
import cn.wmkfe.bookmanage.service.CollegeService;
import cn.wmkfe.bookmanage.service.GenderService;
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
    @Autowired
    private GenderService genderService;
    @Autowired
    private CollegeService collegeService;
    //首页
    @RequestMapping(value = {"/","/index"})
    public String indexPage(){
        return "index";
    }

    //登录页面
    @RequestMapping(value = "/login.html")
    public String loginPage(Model model){
        //获取性别列表
        List<Gender> genderAllList = genderService.getGenderAllList();
        //获取学院列表
        List<College> getCollegeAllList = collegeService.getCollegeAllList();
        model.addAttribute("genders",genderAllList);
        model.addAttribute("colleges",getCollegeAllList);
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

    //阅读列表
    @RequestMapping(value = "/reader-list.html")
    public String readerListPage(){
        return "reader/reader-list";
    }

}
