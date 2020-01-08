package cn.wmkfe.bookmanage.dao;

import cn.wmkfe.bookmanage.model.ClassTable;

import java.util.List;

public interface ClassTableMapper {
    List<ClassTable> getByDepartmentId(Integer departmentId);
}