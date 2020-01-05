package cn.wmkfe.bookmanage.service;

import cn.wmkfe.bookmanage.model.BorrowInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface BorrowInfoService {

    //添加借阅订单
    int addBorrowInfo(BorrowInfo borrowInfo);
    //删除借阅订单
    int deleteBorrowInfo(Integer[] borrowInfoId);
    //更新订单
    int updateBorrowInfo(BorrowInfo borrowInfo);
    //根据订单号查询
    BorrowInfo getByBorrowInfoId(Integer borrowInfoId);
    //查询借阅列表
    List<BorrowInfo> getBorrowInfoList(@Param("BorrowInfo") BorrowInfo borrowInfo,
                                       @Param("keyword") String keyword,
                                       @Param("from") Integer from,
                                       @Param("pageSize") Integer pageSize);

    //获取借阅订单条数
    int getBorrowInfoTotal(@Param("keyword") String keyword);

    //计算逾期和罚金
    void countBeOverdueAndFine();
}