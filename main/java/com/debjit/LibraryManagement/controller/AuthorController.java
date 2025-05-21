package com.debjit.LibraryManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.debjit.LibraryManagement.model.Author;
import com.debjit.LibraryManagement.repository.AuthorRepository;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    @Autowired private AuthorRepository authorRepo;

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorRepo.save(author);
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorRepo.findAll();
    }
}

