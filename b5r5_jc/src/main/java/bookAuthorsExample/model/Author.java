package bookAuthorsExample.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Author {
	
	private Integer id;
	private String name;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public Author(String name, String birthday) {
		setName(name);
		setBirthday(birthday);
	}
	
	public Author(Integer id, String name, String birthday) {
		setId(id);
		setName(name);
		setBirthday(birthday);
	}
	
	public Author() {
	}

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

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setBirthday(String birthday) {
		try {
			setBirthday(sdf.parse(birthday));
		} catch (ParseException e) {
			setBirthday(new Date());
		}
	}
}