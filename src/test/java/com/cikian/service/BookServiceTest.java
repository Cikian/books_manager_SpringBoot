package com.cikian.service;

import com.cikian.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    public void testGetById() {
        Book book = bookService.getById(15);
        System.out.println(book);
    }

    @Test
    public void testGetAll() {
        List<Book> books = bookService.getAll();
        System.out.println(books);
    }

    @Test
    public void testSave1() {
        Book book = new Book();
        book.setType("Java");
        book.setName("Java编程思想");
        book.setDescription("Java编程思想（第4版）");
        bookService.save(book);
    }

    @Test
    public void testSave2() {
        Book book = new Book();
        book.setType("Java");
        book.setName("Java核心技术");
        book.setDescription("Java核心技术（卷1）");
        bookService.save(book);
    }

    @Test
    public void testSave3() {
        Book book = new Book();
        book.setType("Java");
        book.setName("Java核心技术");
        book.setDescription("Java核心技术（卷2）");
        bookService.save(book);
    }

    @Test
    public void testSave4() {
        Book book = new Book();
        book.setType("Java");
        book.setName("Java并发编程实战");
        book.setDescription("Java并发编程实战");
        bookService.save(book);
    }

    @Test
    public void testSave5() {
        Book book = new Book();
        book.setType("Java");
        book.setName("Java性能优化权威指南");
        book.setDescription("Java性能优化权威指南");
        bookService.save(book);
    }

    @Test
    public void testSave6() {
        Book book = new Book();
        book.setType("Java");
        book.setName("Java多线程编程核心技术");
        book.setDescription("Java多线程编程核心技术");
        bookService.save(book);
    }
}
