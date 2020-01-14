package cn.wmkfe.bookmanage.controller.api;

import cn.wmkfe.bookmanage.model.Reader;
import cn.wmkfe.bookmanage.service.ReaderService;
import cn.wmkfe.bookmanage.util.ApiResponseEnum;
import cn.wmkfe.bookmanage.util.MD5Utils;
import cn.wmkfe.bookmanage.util.PageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
public class ReaderController extends AbstractApiController {
    @Autowired
    private ReaderService readerService;

    @GetMapping("/readers")
    public Map<String, Object> getreaders(@RequestParam(required = false,name = "keyword")String keyword,
                                              @RequestParam(required = false,name = "page")Integer page,
                                              @RequestParam(required = false,name = "limit",defaultValue = "10")Integer limit) {
        Map<String, Object> map = null;
        int ReaderTotal = readerService.getReaderTotal(keyword);

        PageSupport pageSupport=new PageSupport();

        pageSupport.setPageSize(limit);

        pageSupport.setCurrentPageNo(page);

        pageSupport.setTotal(ReaderTotal);

        List<Reader> ReaderList = readerService.getReaderList(null, keyword, pageSupport.getCurrentPageNo(), limit);

        map = this.resultJsonLayui(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),ReaderTotal, ReaderList);

        return map;
    }

    @PostMapping("/readers")
    public Map<String, Object> addreaders(Reader reader) {
        if(readerService.getByReaderId(reader.getReaderId())==null){
            int i = readerService.addReader(reader);
            return this.resultJson(ApiResponseEnum.SUCCESS.getCode(),ApiResponseEnum.SUCCESS.getName(),null);
        }
        return this.resultJson(ApiResponseEnum.FAIL.getCode(),"此账号已经存在",null);
    }

    //修改
    @PutMapping("/readers")
    public Map<String, Object> updatereaders(Reader Reader) {
        Map<String, Object> map = null;
        int i = readerService.updateReader(Reader);
        map = this.resultJson(ApiResponseEnum.SUCCESS.getCode(),ApiResponseEnum.SUCCESS.getName(),null);
        return map;
    }

    //删除
    @DeleteMapping("/readers")
    public Map<String, Object> deleteReader(@RequestParam(name = "ids[]") String[] ReaderId) {
        Map<String, Object> map = null;
        int i = readerService.deleteReader(ReaderId);
        map = this.resultJson(ApiResponseEnum.SUCCESS.getCode(),ApiResponseEnum.SUCCESS.getName(),null);
        return map;
    }

    //根据id查询
    @GetMapping("/readers/{readerId}")
    public Map<String, Object> getReaderById(@PathVariable("readerId")String readerId) {
        Map<String, Object> map = null;
        Reader ReaderByReaderId = readerService.getByReaderId(readerId);
        map = this.resultJson(ApiResponseEnum.SUCCESS.getCode(),ApiResponseEnum.SUCCESS.getName(),ReaderByReaderId);
        return map;
    }
    //更新密码
    @PutMapping("/readers/updatePassword")
    public Map<String, Object> updatePassword(@RequestParam(value = "password")String password,@RequestParam(value = "newPassword")String newPassword, HttpSession session) {
        Object loginTag = session.getAttribute("loginTag");
        if(Reader.class==loginTag.getClass()){
            Reader reader = (Reader) loginTag;
            reader = readerService.getByReaderId(reader.getReaderId());
            //校验原密码
            if(reader.getPassword().equals(MD5Utils.MD5Lower(reader.getReaderId(),password))){
                reader.setPassword(MD5Utils.MD5Lower(reader.getReaderId(),password));
                readerService.updateReader(reader);
                return this.resultJson(ApiResponseEnum.SUCCESS.getCode(),ApiResponseEnum.SUCCESS.getName(),null);
            }
        }
        return this.resultJson(ApiResponseEnum.FAIL.getCode(),"原密码输入不正确!",null);
    }

}
