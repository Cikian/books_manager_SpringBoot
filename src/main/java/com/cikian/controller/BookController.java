package com.cikian.controller;

import com.cikian.domain.Book;
import com.cikian.domain.ErrorCode;
import com.cikian.domain.Result;
import com.cikian.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Result save(@RequestBody Book book) {
        boolean flag = bookService.save(book);
        System.out.println(book);
        return new Result(flag ? ErrorCode.SAVE_SUCCESS : ErrorCode.SAVE_FAIL, flag);
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag = bookService.update(book);
        return new Result(flag ? ErrorCode.UPDATE_SUCCESS : ErrorCode.UPDATE_FAIL, flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = bookService.delete(id);
        return new Result(flag ? ErrorCode.DELETE_SUCCESS : ErrorCode.DELETE_FAIL, flag);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Book book = bookService.getById(id);
        Integer code = book != null ? ErrorCode.GET_SUCCESS : ErrorCode.GET_FAIL;
        String msg = book != null ? "" : "查询失败";
        return new Result(code, book, msg);
    }

    @GetMapping
    public Result getAll() {
        List<Book> books = bookService.getAll();
        Integer code = books != null ? ErrorCode.GET_SUCCESS : ErrorCode.GET_FAIL;
        String msg = books != null ? "" : "查询失败";
        return new Result(code, books, msg);
    }
}
