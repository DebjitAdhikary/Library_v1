package com.debjit.LibraryManagement.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.debjit.LibraryManagement.dto.BookRequest;
import com.debjit.LibraryManagement.model.Author;
import com.debjit.LibraryManagement.model.Book;
import com.debjit.LibraryManagement.model.Borrower;
import com.debjit.LibraryManagement.repository.AuthorRepository;
import com.debjit.LibraryManagement.repository.BookRepository;
import com.debjit.LibraryManagement.repository.BorrowerRepository;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired 
    private BookRepository bookRepo;
    
    @Autowired 
    private AuthorRepository authorRepo;
    
    @Autowired 
    private BorrowerRepository borrowerRepo;

    @PostMapping
    public Book createBook(@RequestBody BookRequest bookRequest) {
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setIsbn(bookRequest.getIsbn());
        book.setPublishedDate(bookRequest.getPublishedDate());

        Set<Author> authors = new HashSet<>(authorRepo.findAllById(bookRequest.getAuthorIds()));
        book.setAuthor(authors);

        return bookRepo.save(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @PutMapping("/{bookId}/borrow/{borrowerId}")
    public Book borrowBook(@PathVariable Long bookId, @PathVariable Long borrowerId) {
        Book book = bookRepo.findById(bookId).orElseThrow();
        Borrower borrower = borrowerRepo.findById(borrowerId).orElseThrow();
        book.setBorrower(borrower);
        return bookRepo.save(book);
    }

    @PutMapping("/{bookId}/return")
    public Book returnBook(@PathVariable Long bookId) {
        Book book = bookRepo.findById(bookId).orElseThrow();
        book.setBorrower(null);
        return bookRepo.save(book);
    }
}

