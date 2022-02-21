package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Author;
import com.example.repo.H2repo;

@Service
public class DatabaseService implements MyDatabase {

	@Autowired
	H2repo repo;

	@Override
	public void insert(Author author) {
		repo.insert(author);

	}
}
