package com.debjit.LibraryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.debjit.LibraryManagement.model.Borrower;

public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
	
}
