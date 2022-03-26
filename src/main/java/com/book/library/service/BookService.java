package com.book.library.service;

import com.book.library.domain.Book;

import java.util.List;

/**
 * @author earl.liu
 * @date 2022/3/25 下午3:21
 */
public interface BookService {

    /**
     * 查询所有图书
     * @return
     */
    List<Book> findBookList();
}
