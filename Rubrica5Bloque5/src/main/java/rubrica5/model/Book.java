package rubrica5.model;

import org.springframework.stereotype.Component;

@Component
public class Book {
	
	private Integer id;
	private String title;
	private String isbn;
	private String authorName;
	private Integer authorId;
	

	public Book(Integer id, String title, String isbn, String authorName, Integer authorId) {
		setId(id);
		setTitle(title);
		setIsbn(isbn);
		setAuthorName(authorName);
		setAuthorId(authorId);
	}

	public Book() {
	}

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

	public String getAuthorName() {
		return authorName;
	}
	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
}