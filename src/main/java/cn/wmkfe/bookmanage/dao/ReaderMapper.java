package cn.wmkfe.bookmanage.dao;


import cn.wmkfe.bookmanage.model.Reader;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReaderMapper {
    int add(Reader reader);
    int delete(Integer[] readerId);
    int update(Reader reader);
    Reader getByReaderId(Integer readerId);
    List<Reader> getList(@Param("reader") Reader reader,
                       @Param("keyword") String keyword,
                       @Param("from") Integer from,
                       @Param("pageSize") Integer pageSize);
    int getTotal(@Param("keyword") String keyword);
}