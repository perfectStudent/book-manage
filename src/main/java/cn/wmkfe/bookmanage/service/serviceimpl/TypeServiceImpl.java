package cn.wmkfe.bookmanage.service.serviceimpl;

import cn.wmkfe.bookmanage.dao.TypeMapper;
import cn.wmkfe.bookmanage.model.Type;
import cn.wmkfe.bookmanage.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Transactional
    @Override
    public int addType(Type type) {

        return typeMapper.add(type);
    }

    @Transactional
    @Override
    public int deleteType(Integer[] typeId) {
        return typeMapper.delete(typeId);
    }

    @Transactional
    @Override
    public int updateType(Type type) {
        return typeMapper.update(type);
    }

    @Override
    public Type getTypeByTypeId(Integer typeId) {
        return typeMapper.getByTypeId(typeId);
    }

    @Override
    public List<Type> getTypeList(Type type, String keyword, Integer currentPage, Integer pageSize) {
        return typeMapper.getList(type,keyword,(currentPage-1)*pageSize,pageSize);
    }

    @Override
    public List<Type> getTypeListAll() {
        return typeMapper.getListAll();
    }

    @Override
    public int getTypeTotal(String keyword) {
        return typeMapper.getTotal(keyword);
    }
}