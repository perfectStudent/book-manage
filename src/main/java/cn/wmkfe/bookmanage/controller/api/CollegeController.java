package cn.wmkfe.bookmanage.controller.api;

import cn.wmkfe.bookmanage.model.College;
import cn.wmkfe.bookmanage.service.CollegeService;
import cn.wmkfe.bookmanage.util.ApiResponseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CollegeController extends AbstractApiController {
    @Autowired
    private CollegeService collegeService;
    @GetMapping("/colleges")
    public Map<String,Object> getAllList(){
        List<College> collegeAllList = collegeService.getCollegeAllList();
        return this.resultJson(ApiResponseEnum.SUCCESS.getCode(),ApiResponseEnum.SUCCESS.getName(),collegeAllList);
    }
}
