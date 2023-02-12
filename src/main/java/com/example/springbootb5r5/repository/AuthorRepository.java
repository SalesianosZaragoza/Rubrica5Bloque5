package com.example.springbootb5r5.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.springbootb5r5.model.Author;


@Repository
public class AuthorRepository {

	static List<Author> list = new ArrayList<>();

	public void add(Author author) {
		int id = getLastIndex();
		author.setId_auth(id);
		list.add(author);
		
	}
	
	public Author getAuthorById(int id) {
		Author aut = new Author();
		
		for (Author author : list) {
			if (author.getId_auth()==id) {
				aut = author;
			}
		}
		
		return aut;
	}
	
	public int getLastIndex() {
		int num = 0;
		
		if (!list.isEmpty()) {
			num = list.get(list.size()-1).getId_auth();
			num++;
		}
		
		return num;
	}
	
	public List<Author> getAuthors(){
		return list;
	}
}
