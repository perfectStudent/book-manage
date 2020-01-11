package cn.wmkfe.bookmanage.service.serviceimpl;

import cn.wmkfe.bookmanage.dao.ReaderMapper;
import cn.wmkfe.bookmanage.model.Reader;
import cn.wmkfe.bookmanage.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class ReaderServiceImpl implements ReaderService {
    @Autowired
    private ReaderMapper readerMapper;

    @Transactional
    @Override
    public int addReader(Reader reader) {
        return readerMapper.add(reader);
    }

    @Transactional
    @Override
    public int deleteReader(String[] readerId) {
        return readerMapper.delete(readerId);
    }

    @Transactional
    @Override
    public int updateReader(Reader reader) {
        return readerMapper.update(reader);
    }

    @Override
    public Reader getByReaderId(String readerId) {
        return readerMapper.getByReaderId(readerId);
    }

    @Override
    public List<Reader> getReaderList(Reader reader, String keyword, Integer currentPage, Integer pageSize) {
        return readerMapper.getList(reader,keyword,(currentPage-1)*pageSize,pageSize);
    }

    @Override
    public int getReaderTotal(String keyword) {
        return readerMapper.getTotal(keyword);
    }
}
