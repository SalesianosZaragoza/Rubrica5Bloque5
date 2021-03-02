package AuthorsBooks.model;

public class Book {
	private String name;
	String isbn;
	private String authorName;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}