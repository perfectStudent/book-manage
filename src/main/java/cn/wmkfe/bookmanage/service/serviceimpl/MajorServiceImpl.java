package cn.wmkfe.bookmanage.service.serviceimpl;

import cn.wmkfe.bookmanage.dao.MajorMapper;
import cn.wmkfe.bookmanage.model.Major;
import cn.wmkfe.bookmanage.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MajorServiceImpl implements MajorService {
    @Autowired
    private MajorMapper majorMapper;
    @Override
    public List<Major> getMajorListByCollegeId(Integer collegeId) {
        return majorMapper.getListByCollegeId(collegeId);
    }
}
