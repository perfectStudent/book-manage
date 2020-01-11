package cn.wmkfe.bookmanage.controller.api;

import cn.wmkfe.bookmanage.model.Class;
import cn.wmkfe.bookmanage.service.ClassService;
import cn.wmkfe.bookmanage.util.ApiResponseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ClassController extends AbstractApiController{
    @Autowired
    private ClassService classService;
    @GetMapping("/classs/{majorId}")
    public Map<String,Object> getGenderByDepartmentId(@PathVariable(value = "majorId")Integer majorId){
        List<Class> classByMajorId = classService.getClassByMajorId(majorId);
        return this.resultJson(ApiResponseEnum.SUCCESS.getCode(),ApiResponseEnum.SUCCESS.getName(),classByMajorId);
    }
}
