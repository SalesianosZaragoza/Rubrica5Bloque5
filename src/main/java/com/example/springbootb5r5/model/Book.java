package com.example.springbootb5r5.model;

import java.util.List;

public class Book {

	private int id_book;
	
	private String title;
	
	private String isbn;
	
	private int id_author;
	
	private String nom_author;

	public int getId_book() {
		return id_book;
	}

	public void setId_book(int id_book) {
		this.id_book = id_book;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getId_author() {
		return id_author;
	}

	public void setId_author(int id_author) {
		this.id_author = id_author;
	}
	
	public String getNom_author() {
		return nom_author;
	}
	
	public void setNom_author(String nom_author) {
		this.nom_author = nom_author;
	}

	@Override
	public String toString() {
		return "Book [id_book=" + id_book + ", title=" + title + ", isbn=" + isbn + ", id_author=" + id_author
				+ ", nom_author=" + nom_author + "]";
	}

	
	
	
}
