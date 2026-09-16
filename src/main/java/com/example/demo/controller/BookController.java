package com.example.demo.controller;
import com.example.demo.service.BookService;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Book;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }
    @GetMapping
    public Book getBook() {
        return service.getBook();
    }
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return service.addBook(book);
    }

}