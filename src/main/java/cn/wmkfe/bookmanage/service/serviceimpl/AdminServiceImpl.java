package cn.wmkfe.bookmanage.service.serviceimpl;

import cn.wmkfe.bookmanage.dao.AdminMapper;
import cn.wmkfe.bookmanage.model.Admin;
import cn.wmkfe.bookmanage.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin getAdminOne(String adminName) {
        Admin byAdminName = adminMapper.getByAdminId(adminName);
        return byAdminName;
    }
}
