package cn.wmkfe.bookmanage.service;


import cn.wmkfe.bookmanage.model.Reader;

import java.util.List;

public interface ReaderService {
    int addReader(Reader reader);
    int deleteReader(Integer[] readerId);
    int updateReader(Reader reader);
    Reader getByReaderId(Integer readerId);
    List<Reader> getReaderList(Reader reader, String keyword, Integer currentPage, Integer pageSize);
    int getReaderTotal(String keyword);
}
