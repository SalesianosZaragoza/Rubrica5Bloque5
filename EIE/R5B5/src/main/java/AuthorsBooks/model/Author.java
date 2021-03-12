package AuthorsBooks.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Author {
	private String name;
	private String surname;
	private Date born;
	private List<Book> libros = new ArrayList<Book>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Book> getLibros() {
		return libros;
	}

	public void setLibros(List<Book> libros) {
		this.libros = libros;
	}

	@Override
	public String toString() {
		return "(Autor) [name=" + name + ", surname=" + surname + "]";
	}

	public Date getBorn() {
		return born;
	}

	public void setBorn(Date born) {
		this.born = born;
	}

}

