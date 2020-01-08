package cn.wmkfe.bookmanage.service;

import cn.wmkfe.bookmanage.model.ClassTable;

import java.util.List;

public interface ClassTableService {
    List<ClassTable> getClassByDepartmentId(Integer departmentId);
}
