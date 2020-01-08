package cn.wmkfe.bookmanage.service.serviceimpl;

import cn.wmkfe.bookmanage.dao.ClassTableMapper;
import cn.wmkfe.bookmanage.model.ClassTable;
import cn.wmkfe.bookmanage.service.ClassTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassTableServiceImpl implements ClassTableService {
    @Autowired
    private ClassTableMapper classTableMapper;
    @Override
    public List<ClassTable> getClassByDepartmentId(Integer departmentId) {
        return classTableMapper.getByDepartmentId(departmentId);
    }
}
