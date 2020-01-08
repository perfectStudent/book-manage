package cn.wmkfe.bookmanage.service.serviceimpl;

import cn.wmkfe.bookmanage.dao.GenderMapper;
import cn.wmkfe.bookmanage.model.Gender;
import cn.wmkfe.bookmanage.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GenderServiceImpl implements GenderService {
    @Autowired
    private GenderMapper genderMapper;

    @Override
    public List<Gender> getGenderAllList() {
        return genderMapper.getAllList();
    }
}
