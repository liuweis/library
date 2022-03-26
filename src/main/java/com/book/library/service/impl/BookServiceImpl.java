package com.book.library.service.impl;

import com.book.library.domain.Book;
import com.book.library.mapper.BookMapper;
import com.book.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author earl.liu
 * @date 2022/3/25 下午3:28
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;


    @Override
    public List<Book> findBookList() {
        return bookMapper.findBookListById(null);
    }
}
