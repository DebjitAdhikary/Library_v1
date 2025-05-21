package com.debjit.LibraryManagement.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Borrower {

	@Id @GeneratedValue
    private Long id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "borrower")
    private Set<Book> borrowedBooks = new HashSet<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
