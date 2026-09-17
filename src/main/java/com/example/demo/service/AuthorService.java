package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public List<Author> listAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public Author updateAuthor(Long authorId, Author updatedAuthor) {
        Author existingAuthor = authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        existingAuthor.setAuthorName(updatedAuthor.getAuthorName());
        existingAuthor.setAuthorCountry(updatedAuthor.getAuthorCountry());

        return authorRepository.save(existingAuthor);
    }

    public String deleteAuthor(Long authorId) {
        if (!authorRepository.existsById(authorId)) {
            throw new RuntimeException("Author not found");
        }

        authorRepository.deleteById(authorId);

        return "Author with ID " + authorId + " has been deleted.";
    }
}