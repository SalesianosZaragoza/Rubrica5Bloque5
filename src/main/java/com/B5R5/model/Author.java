package com.B5R5.model;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Author {
	private Integer id;
	private String name;
	private Date birthday;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	
	public Author(Integer id, String name, String birthday) {
		super();
		this.id = id;
		this.name = name;
		setBirthday(birthday);
	}
	public Author() {}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		try {
			setBirthday(sdf.parse(birthday));
		} catch (ParseException e) {
			setBirthday(new Date());
		}
	}
	private void setBirthday(Date date) {
		this.birthday = date;

	}

}
