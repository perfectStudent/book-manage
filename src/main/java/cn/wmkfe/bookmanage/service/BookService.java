package cn.wmkfe.bookmanage.service;

import cn.wmkfe.bookmanage.model.Book;

import java.util.List;

public interface BookService {
    int addBook(Book book);
    int deleteBook(Integer[] bookId);
    int updateBook(Book book);
    Book getBookByBookId(Integer bookId);
    List<Book> getBookList(Book book, String keyword, Integer currentPage, Integer pageSize);
    int getBookTotal(String keyword,Book book);
}
