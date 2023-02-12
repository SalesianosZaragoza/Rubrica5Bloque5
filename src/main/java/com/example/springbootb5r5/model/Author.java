package com.example.springbootb5r5.model;

public class Author {

	private int id_auth;
	
	private String name;
	
	private String birthday;

	
	
	public int getId_auth() {
		return id_auth;
	}

	public void setId_auth(int id_auth) {
		this.id_auth = id_auth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Author [id_auth=" + id_auth + ", name=" + name + ", birthday=" + birthday + "]";
	}
	
	
	
	
	
}
