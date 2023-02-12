package com.example.springbootb5r5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootb5r5.model.Book;
import com.example.springbootb5r5.repository.BookRepository;


@Service
public class BookService {

	
	@Autowired
	public BookRepository repository;
	
	public void add(Book book) {
		repository.add(book);
		
	}
	
	public List<Book> getBooks(){
		return repository.getBooks();
	}
}
