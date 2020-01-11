package cn.wmkfe.bookmanage.dao;

import cn.wmkfe.bookmanage.model.Class;

import java.util.List;

public interface ClassMapper {
    List<Class> getByMajorId(Integer majorId);
}