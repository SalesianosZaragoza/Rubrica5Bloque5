package com.example.springbootb5r5.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.springbootb5r5.model.Book;

@Repository
public class BookRepository {

	static List<Book> list = new ArrayList<>();
	
	
	public void add(Book book) {
		int id = getLastIndex();
		book.setId_book(id);
		
		list.add(book);	
	}
	
	public int getLastIndex() {
		int num = 0;
		
		if (!list.isEmpty()) {
			num = list.get(list.size()-1).getId_book();
			num++;
		}
		
		return num;
	}
	
	
	public List<Book> getBooks(){
		return list;
		
	}
}
