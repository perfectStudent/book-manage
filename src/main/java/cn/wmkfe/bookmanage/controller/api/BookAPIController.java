package cn.wmkfe.bookmanage.controller.api;


import cn.wmkfe.bookmanage.model.Book;
import cn.wmkfe.bookmanage.service.BookService;
import cn.wmkfe.bookmanage.util.ApiResponseEnum;
import cn.wmkfe.bookmanage.util.PageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BookAPIController extends AbstractApiController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public Map<String, Object> getBooks(@RequestParam(required = false,name = "keyword")String keyword,
                                        @RequestParam(required = false,name = "type")Integer type,
                                        @RequestParam(required = false,name = "page")Integer page,
                                        @RequestParam(required = false,name = "limit",defaultValue = "10")Integer limit) {
        Map<String, Object> map = null;
        Book book=new Book();
        book.setType(type);
        int bookTotal = bookService.getBookTotal(keyword);

        PageSupport pageSupport=new PageSupport();

        pageSupport.setPageSize(limit);

        pageSupport.setCurrentPageNo(page);

        pageSupport.setTotal(bookTotal);

        List<Book> bookList = bookService.getBookList(book, keyword, pageSupport.getCurrentPageNo(), limit);

        map = this.resultJsonLayui(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),bookTotal, bookList);

        return map;
    }

    @PostMapping("/books")
    public Map<String, Object> addBooks(Book book) {
        Map<String, Object> map = null;
        int i = bookService.addBook(book);
        map = this.resultJson(ApiResponseEnum.SUCCESS.getCode(),ApiResponseEnum.SUCCESS.getName(),null);
        return map;
    }

    //修改
    @PutMapping("/books")
    public Map<String, Object> updateBooks(Book book) {
        Map<String, Object> map = null;
        int i = bookService.updateBook(book);
        map = this.resultJson(ApiResponseEnum.SUCCESS.getCode(),ApiResponseEnum.SUCCESS.getName(),null);
        return map;
    }

    //删除
    @DeleteMapping("/books")
    public Map<String, Object> deleteBook(@RequestParam(name = "ids[]") Integer[] bookId) {
        Map<String, Object> map = null;
        int i = bookService.deleteBook(bookId);
        map = this.resultJson(ApiResponseEnum.SUCCESS.getCode(),ApiResponseEnum.SUCCESS.getName(),null);
        return map;
    }

    //根据id查询
    @GetMapping("/books/{id}")
    public Map<String, Object> getBookById(@PathVariable("id")Integer id) {
        Map<String, Object> map = null;
        Book bookByBookId = bookService.getBookByBookId(id);
        map = this.resultJson(ApiResponseEnum.SUCCESS.getCode(),ApiResponseEnum.SUCCESS.getName(),bookByBookId);
        return map;
    }

}
