package com.book.library.controller;

import com.book.library.domain.Book;
import com.book.library.service.BookService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liuwei
 * @since 2022-03-25
 */
@RestController
@RequestMapping("book")
@Api(tags = "图书模块")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("findAllBooks")
    public List<Book>findBookList(){
        return bookService.findBookList();
    }






}

