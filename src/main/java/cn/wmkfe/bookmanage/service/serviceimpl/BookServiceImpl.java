package cn.wmkfe.bookmanage.service.serviceimpl;

import cn.wmkfe.bookmanage.dao.BookMapper;
import cn.wmkfe.bookmanage.model.Book;
import cn.wmkfe.bookmanage.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;


    @Transactional
    @Override
    public int addBook(Book book) {
        return bookMapper.add(book);
    }


    @Transactional
    @Override
    public int deleteBook(Integer[] bookId) {
        return bookMapper.delete(bookId);
    }


    @Transactional
    @Override
    public int updateBook(Book book) {
        return bookMapper.update(book);
    }

    @Override
    public Book getBookByBookId(Integer bookId) {
        return bookMapper.getByBookId(bookId);
    }

    @Override
    public List<Book> getBookList(Book book,String keyword,Integer currentPage,Integer pageSize) {
        return bookMapper.getList(book,keyword,(currentPage-1)*pageSize,pageSize);
    }

    @Override
    public int getBookTotal(String keyword) {
        return bookMapper.getTotal(keyword);
    }
}
