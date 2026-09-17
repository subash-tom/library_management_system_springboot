package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository repository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository repository,
                       AuthorRepository authorRepository) {
        this.repository = repository;
        this.authorRepository = authorRepository;
    }

    public Book addBook(Book book) {

        if (book.getAuthor() != null) {

            Long authorId = book.getAuthor().getAuthorId();

            Author author = authorRepository.findById(authorId)
                    .orElseThrow(() -> new RuntimeException("Author not found"));

            book.setAuthor(author);
        }

        return repository.save(book);
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Book getBookById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public Book updateBook(Long id, Book updatedBook) {

        Book existingBook = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setPrice(updatedBook.getPrice());

        if (updatedBook.getAuthor() != null) {

            Long authorId = updatedBook.getAuthor().getAuthorId();

            Author author = authorRepository.findById(authorId)
                    .orElseThrow(() -> new RuntimeException("Author not found"));

            existingBook.setAuthor(author);
        }

        return repository.save(existingBook);
    }

    public String deleteBook(Long id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("Book not found");
        }

        repository.deleteById(id);

        return "Book with ID " + id + " has been deleted.";
    }
}