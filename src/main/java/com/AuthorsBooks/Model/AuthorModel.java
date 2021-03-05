package com.AuthorsBooks.Model;

import java.util.Date;

public class AuthorModel {
	private int AuthorID;
	private String name;
	private Date BirthDate;
	
	public Integer getAuthorID() {
		return AuthorID;
	}
	public void setAuthorID(int authorID) {
		AuthorID = authorID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return BirthDate;
	}
	public void setBirthDate(Date birthDate) {
		BirthDate = birthDate;
	}
	
	
}
