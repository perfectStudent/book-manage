package cn.wmkfe.bookmanage.controller.api;

import cn.wmkfe.bookmanage.model.ClassTable;
import cn.wmkfe.bookmanage.service.ClassTableService;
import cn.wmkfe.bookmanage.service.GenderService;
import cn.wmkfe.bookmanage.util.ApiResponseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ClassTableController extends AbstractApiController{
    @Autowired
    private ClassTableService classTableService;
    @GetMapping("/genders/{departmentId}")
    public Map<String,Object> getGenderByDepartmentId(@PathVariable(value = "departmentId")Integer departmentId){
        List<ClassTable> classByDepartmentId = classTableService.getClassByDepartmentId(departmentId);
        return this.resultJson(ApiResponseEnum.SUCCESS.getCode(),ApiResponseEnum.SUCCESS.getName(),classByDepartmentId);
    }
}
