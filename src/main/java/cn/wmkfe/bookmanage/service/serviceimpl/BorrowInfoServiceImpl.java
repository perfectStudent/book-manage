package cn.wmkfe.bookmanage.service.serviceimpl;

import cn.wmkfe.bookmanage.dao.BookMapper;
import cn.wmkfe.bookmanage.dao.BorrowInfoMapper;
import cn.wmkfe.bookmanage.model.Book;
import cn.wmkfe.bookmanage.model.BorrowInfo;
import cn.wmkfe.bookmanage.service.BorrowInfoService;
import cn.wmkfe.bookmanage.util.PageSupport;
import cn.wmkfe.bookmanage.vo.UpdateLendVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Service
public class BorrowInfoServiceImpl implements BorrowInfoService {
    @Autowired
    private BorrowInfoMapper borrowInfoMapper;
    @Autowired
    private BookMapper bookMapper;
    @Transactional
    @Override
    public int addBorrowInfo(BorrowInfo borrowInfo) {
        return borrowInfoMapper.add(borrowInfo);
    }

    @Transactional
    @Override
    public int deleteBorrowInfo(Integer[] borrowInfoId) {
        return borrowInfoMapper.delete(borrowInfoId);
    }

    @Transactional
    @Override
    public int updateBorrowInfo(BorrowInfo borrowInfo) {
        return borrowInfoMapper.update(borrowInfo);
    }

    @Override
    public BorrowInfo getByBorrowInfoId(Integer borrowInfoId) {
        return borrowInfoMapper.getById(borrowInfoId);
    }

    @Override
    public List<BorrowInfo> getBorrowInfoList(BorrowInfo borrowInfo, String keyword, Integer from, Integer pageSize) {
        return borrowInfoMapper.getList(borrowInfo,keyword,(from-1)*pageSize,pageSize);
    }

    @Override
    public int getBorrowInfoTotal(String keyword) {
        return borrowInfoMapper.getTotal(keyword);
    }


    @Scheduled(cron = "0 0 6 ? * *")
//    @Scheduled(cron = "0/5 * * * * *")
    @Transactional
    @Override
    public void countBeOverdueAndFine() {
        System.out.println("测试定时任务");
        int total = borrowInfoMapper.getTotal(null);
        PageSupport pageSupport=new PageSupport();
        pageSupport.setPageSize(10);
        pageSupport.setTotal(total);
        int currentPageNo=1;
        while (currentPageNo<=pageSupport.getPageCount()){
            List<BorrowInfo> list = borrowInfoMapper.getList(null, null, (currentPageNo - 1) * 10, 10);
            for (BorrowInfo bo:list) {
                long days = this.calculateDays(bo);
                System.out.println();
                if(days<0){
                    bo.setBeOverdueDay(Long.toString(Math.abs(days)));
                    bo.setBeOverdue(true);
                    BigDecimal money=new BigDecimal("0.05");
                    BigDecimal overdueDay=new BigDecimal(Long.toString(Math.abs(days)));
                    bo.setFine(money.multiply(overdueDay));
                    borrowInfoMapper.update(bo);
                }
            }
            currentPageNo++;
        }
    }

    @Transactional
    @Override
    public int giveBackBook(UpdateLendVo updateLendVo) {
        //更新是否归还图书字段
        borrowInfoMapper.updateWhetherLend(updateLendVo);
        //查询图书借出数量
        Book byBookId = bookMapper.getByBookId(updateLendVo.getBookId());
        //设置借出图书数量
        updateLendVo.setLendNumber(byBookId.getLendNumber()-1);
        //更新图书借出数量
        bookMapper.updateLendNumber(updateLendVo);
        return 0;
    }

    private long calculateDays(BorrowInfo bo){
        LocalDate now=LocalDate.now();//获取当前时间 格式 yyyy-mm-dd
        //Date转化成LocalDate
        Instant instant = bo.getGiveBackTime().toInstant();
        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
        LocalDate start = zdt.toLocalDate();
        return ChronoUnit.DAYS.between(now,start);  //start-now  第一个参数减数  第二个参数被减数
    }
}