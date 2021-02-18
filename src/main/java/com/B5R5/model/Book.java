package com.B5R5.model;

public class Book {
	private Integer id;
	private String title;
	private String isbn;
	private String author;
	private Integer authorID;

	public Book(Integer id, String title, String isbn, String author, Integer authorID) {
		super();
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.authorID = authorID;
	}
	public Book() {}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getAuthorID() {
		return authorID;
	}
	public void setAuthorID(Integer authorID) {
		this.authorID = authorID;
	}


}
