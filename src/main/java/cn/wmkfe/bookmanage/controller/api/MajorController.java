package cn.wmkfe.bookmanage.controller.api;

import cn.wmkfe.bookmanage.model.Major;
import cn.wmkfe.bookmanage.service.MajorService;
import cn.wmkfe.bookmanage.util.ApiResponseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MajorController extends AbstractApiController{
    @Autowired
    private MajorService majorService;
    @GetMapping("/majors/{collegeId}")
    public Map<String,Object> getMajorsByCollegeId(@PathVariable(value = "collegeId") Integer collegeId){
        List<Major> majorListByCollegeId = majorService.getMajorListByCollegeId(collegeId);
        return this.resultJson(ApiResponseEnum.SUCCESS.getCode(),ApiResponseEnum.SUCCESS.getName(),majorListByCollegeId);
    }

}
