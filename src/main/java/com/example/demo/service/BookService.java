package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
@Service
public class BookService {
private final BookRepository repository;
    public BookService(BookRepository repository) { 
        this.repository = repository;
    }   

    public Book addBook(Book book) {
        return repository.save(book);
    }
public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Book getBookById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }
public Book updateBook(Long id, Book updatedBook) {
        Book existingBook = repository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setPrice(updatedBook.getPrice());
        return repository.save(existingBook);
    }

    public void deleteBook(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Book not found");
        }
        repository.deleteById(id);
    }
}


