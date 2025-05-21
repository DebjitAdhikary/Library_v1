package com.debjit.LibraryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.debjit.LibraryManagement.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
	
}