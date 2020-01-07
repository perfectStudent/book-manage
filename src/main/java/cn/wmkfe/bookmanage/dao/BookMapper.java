package cn.wmkfe.bookmanage.dao;


import cn.wmkfe.bookmanage.model.Book;
import cn.wmkfe.bookmanage.vo.UpdateLendVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    int add(Book book);
    int delete(Integer[] bookId);
    int update(Book book);
    Book getByBookId(Integer bookId);
    List<Book> getList(@Param("book") Book book,
                       @Param("keyword") String keyword,
                       @Param("from") Integer from,
                       @Param("pageSize") Integer pageSize);
    int getTotal(@Param("keyword") String keyword);
    int updateLendNumber(UpdateLendVo updateLendVo);
}