package cn.wmkfe.bookmanage.service;

import cn.wmkfe.bookmanage.model.Class;

import java.util.List;

public interface ClassService {
    List<Class> getClassByMajorId(Integer majorId);
}
