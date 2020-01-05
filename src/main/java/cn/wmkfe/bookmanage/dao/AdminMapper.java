package cn.wmkfe.bookmanage.dao;


import cn.wmkfe.bookmanage.model.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    Admin getByAdminId(@Param("adminId") String adminId);
}