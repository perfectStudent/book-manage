package cn.wmkfe.bookmanage.service;


import cn.wmkfe.bookmanage.model.Type;

import java.util.List;

public interface TypeService {
    int addType(Type type);
    int deleteType(Integer[] typeId);
    int updateType(Type type);
    Type getTypeByTypeId(Integer typeId);
    List<Type> getTypeList(Type type, String keyword, Integer currentPage, Integer pageSize);
    List<Type> getTypeListAll();
    int getTypeTotal(String keyword);
}