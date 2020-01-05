package cn.wmkfe.bookmanage.dao;


import cn.wmkfe.bookmanage.model.BorrowInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BorrowInfoMapper {
    //添加借阅订单
    int add(BorrowInfo borrowInfo);
    //删除借阅订单
    int delete(Integer[] borrowInfoId);
    //更新订单
    int update(BorrowInfo borrowInfo);
    //根据订单号查询
    BorrowInfo getById(Integer borrowInfoId);
    //查询借阅列表
    List<BorrowInfo> getList(@Param("BorrowInfo") BorrowInfo borrowInfo,
                             @Param("keyword") String keyword,
                             @Param("from") Integer from,
                             @Param("pageSize") Integer pageSize);

    //获取借阅订单条数
    int getTotal(@Param("keyword") String keyword);

}