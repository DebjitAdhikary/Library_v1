package com.debjit.LibraryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.debjit.LibraryManagement.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {}
