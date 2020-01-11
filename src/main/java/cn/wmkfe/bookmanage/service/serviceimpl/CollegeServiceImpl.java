package cn.wmkfe.bookmanage.service.serviceimpl;

import cn.wmkfe.bookmanage.dao.CollegeMapper;
import cn.wmkfe.bookmanage.model.College;
import cn.wmkfe.bookmanage.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    private CollegeMapper collegeMapper;
    @Override
    public List<College> getCollegeAllList() {
        return collegeMapper.getAllList();
    }
}
