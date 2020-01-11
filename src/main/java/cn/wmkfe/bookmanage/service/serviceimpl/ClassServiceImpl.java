package cn.wmkfe.bookmanage.service.serviceimpl;

import cn.wmkfe.bookmanage.dao.ClassMapper;
import cn.wmkfe.bookmanage.model.Class;
import cn.wmkfe.bookmanage.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassMapper classMapper;
    @Override
    public List<Class> getClassByMajorId(Integer majorId) {
        return classMapper.getByMajorId(majorId);
    }


}
