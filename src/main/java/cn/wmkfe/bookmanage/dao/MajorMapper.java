package cn.wmkfe.bookmanage.dao;

import cn.wmkfe.bookmanage.model.Major;

import java.util.List;

public interface MajorMapper {
    List<Major> getListByCollegeId(Integer collegeId);
}
