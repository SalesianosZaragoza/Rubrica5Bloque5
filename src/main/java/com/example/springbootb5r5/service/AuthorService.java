package com.example.springbootb5r5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.springbootb5r5.model.Author;
import com.example.springbootb5r5.model.Book;
import com.example.springbootb5r5.repository.AuthorRepository;


@Service
public class AuthorService {

	@Autowired
	public AuthorRepository repository;
	
	public void add(Author author) {
		repository.add(author);
		
	}
	
	public List<Author> getAuthors(){
		return repository.getAuthors();
	}

	public Author getAuthorById(int id_author) {
		// TODO Auto-generated method stub
		return repository.getAuthorById(id_author);
	}

}
