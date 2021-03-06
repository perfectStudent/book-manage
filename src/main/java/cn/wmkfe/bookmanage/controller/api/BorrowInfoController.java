package cn.wmkfe.bookmanage.controller.api;

import cn.wmkfe.bookmanage.model.BorrowInfo;
import cn.wmkfe.bookmanage.model.LoginTag;
import cn.wmkfe.bookmanage.model.Reader;
import cn.wmkfe.bookmanage.service.BorrowInfoService;
import cn.wmkfe.bookmanage.util.ApiResponseEnum;
import cn.wmkfe.bookmanage.util.PageSupport;
import cn.wmkfe.bookmanage.vo.UpdateLendVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class BorrowInfoController extends AbstractApiController{
    @Autowired
    private BorrowInfoService borrowInfoService;

    @GetMapping("/borrowInfos")
    public Map<String, Object> getBorrowInfos(@RequestParam(required = false,name = "keyword")String keyword,
                                        @RequestParam(required = false,name = "page")Integer page,
                                        @RequestParam(required = false,name = "limit",defaultValue = "10")Integer limit,
                                        HttpSession session) {
        Map<String, Object> map = null;

        LoginTag loginTag = (LoginTag) session.getAttribute("loginTag");

        int BorrowInfoTotal = borrowInfoService.getBorrowInfoTotal(keyword,loginTag.getObj());

        PageSupport pageSupport=new PageSupport();

        pageSupport.setPageSize(limit);

        pageSupport.setCurrentPageNo(page);

        pageSupport.setTotal(BorrowInfoTotal);

        List<BorrowInfo> borrowInfoList = borrowInfoService.getBorrowInfoList(null, keyword,loginTag.getObj(), pageSupport.getCurrentPageNo(), limit);

        map = this.resultJsonLayui(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),BorrowInfoTotal, borrowInfoList);

        return map;
    }

    @PostMapping("/borrowInfos")
    public Map<String, Object> addBorrowInfos(BorrowInfo borrowInfo, HttpSession session) {
        LoginTag loginTag = (LoginTag) session.getAttribute("loginTag");
        Reader reader= (Reader) loginTag.getObj();
        int i = borrowInfoService.addBorrowInfo(borrowInfo,reader);
        if(i==0){
            return this.resultJson(ApiResponseEnum.FAIL.getCode(),ApiResponseEnum.FAIL.getName(),null);
        }
        return this.resultJson(ApiResponseEnum.SUCCESS.getCode(),ApiResponseEnum.SUCCESS.getName(),null);
     }

    //修改
    @PutMapping("/borrowInfos")
    public Map<String, Object> updateBorrowInfos(BorrowInfo BorrowInfo) {
        Map<String, Object> map = null;
        int i = borrowInfoService.updateBorrowInfo(BorrowInfo);
        map = this.resultJson(ApiResponseEnum.SUCCESS.getCode(),ApiResponseEnum.SUCCESS.getName(),null);
        return map;
    }

    //删除
    @DeleteMapping("/borrowInfos")
    public Map<String, Object> deleteBorrowInfo(@RequestParam(name = "ids[]") Integer[] BorrowInfoId) {
        Map<String, Object> map = null;
        int i = borrowInfoService.deleteBorrowInfo(BorrowInfoId);
        map = this.resultJson(ApiResponseEnum.SUCCESS.getCode(),ApiResponseEnum.SUCCESS.getName(),null);
        return map;
    }

    //根据id查询
    @GetMapping("/borrowInfos/{id}")
    public Map<String, Object> getBorrowInfoById(@PathVariable("id")Integer id) {
        Map<String, Object> map = null;
        BorrowInfo BorrowInfoByBorrowInfoId = borrowInfoService.getByBorrowInfoId(id);
        map = this.resultJson(ApiResponseEnum.SUCCESS.getCode(),ApiResponseEnum.SUCCESS.getName(),BorrowInfoByBorrowInfoId);
        return map;
    }

    //归还图书
    @PutMapping("/giveBackBooks")
    public Map<String,Object> giveBackBooks(UpdateLendVo updateLendVo){
        Map<String, Object> map = null;
        System.out.println(updateLendVo.toString());
        int i = borrowInfoService.giveBackBook(updateLendVo);
        map = this.resultJson(ApiResponseEnum.SUCCESS.getCode(),ApiResponseEnum.SUCCESS.getName(),null);
        return map;
    }
}
