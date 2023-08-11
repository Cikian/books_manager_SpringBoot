package com.cikian.service.impl;

import com.cikian.dao.BookDao;
import com.cikian.domain.Book;
import com.cikian.domain.ErrorCode;
import com.cikian.exception.SystemException;
import com.cikian.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public boolean save(Book book) {
        return bookDao.save(book) > 0;
    }

    @Override
    public boolean update(Book book) {
        return bookDao.update(book) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookDao.delete(id) > 0;
    }

    @Override
    public Book getById(Integer id) {
        if (id == 1) {
            throw new SystemException(ErrorCode.SYSTEM_ERR, "id is null");
        }
        return bookDao.getById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
