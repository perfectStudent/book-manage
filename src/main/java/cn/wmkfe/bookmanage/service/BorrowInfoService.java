package cn.wmkfe.bookmanage.service;

import cn.wmkfe.bookmanage.model.BorrowInfo;
import cn.wmkfe.bookmanage.model.Reader;
import cn.wmkfe.bookmanage.vo.UpdateLendVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface BorrowInfoService {

    //添加借阅订单
    int addBorrowInfo(BorrowInfo borrowInfo,Reader reader);
    //删除借阅订单
    int deleteBorrowInfo(Integer[] borrowInfoId);
    //更新订单
    int updateBorrowInfo(BorrowInfo borrowInfo);
    //根据订单号查询
    BorrowInfo getByBorrowInfoId(Integer borrowInfoId);
    //查询借阅列表
    List<BorrowInfo> getBorrowInfoList(BorrowInfo borrowInfo,
                                       String keyword,
                                       Object loginTag,
                                       Integer from,
                                       Integer pageSize);

    //获取借阅订单条数
    int getBorrowInfoTotal(String keyword, Object loginTag);

    //计算逾期和罚金
    void countBeOverdueAndFine();

    //图书归还
    int giveBackBook(UpdateLendVo updateLendVo);
}