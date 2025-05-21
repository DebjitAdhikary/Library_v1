package com.debjit.LibraryManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.debjit.LibraryManagement.model.Borrower;
import com.debjit.LibraryManagement.repository.BorrowerRepository;

@RestController
@RequestMapping("/api/borrowers")
public class BorrowerController {
    @Autowired private BorrowerRepository borrowerRepo;

    @PostMapping
    public Borrower createBorrower(@RequestBody Borrower borrower) {
        return borrowerRepo.save(borrower);
    }

    @GetMapping
    public List<Borrower> getAllBorrowers() {
        return borrowerRepo.findAll();
    }
}

