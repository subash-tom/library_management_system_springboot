package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Book;

@Service
public class BookService {
    public Book getBook() {
        return new Book("java", "james gosling", 599.00f);
    }

    public Book addBook(Book book) {
        return book;
    }
}


