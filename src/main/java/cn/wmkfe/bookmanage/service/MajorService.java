package cn.wmkfe.bookmanage.service;

import cn.wmkfe.bookmanage.model.Major;

import java.util.List;

public interface MajorService {
    List<Major> getMajorListByCollegeId(Integer collegeId);
}
