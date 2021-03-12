package AuthorsBooks.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Repository;

import AuthorsBooks.model.Book;

@Repository
public class BookRepository {

	private List<Book> books = new ArrayList<Book>();

	public void insert(Book bookForm) {
		books.add(bookForm);
	}

	public List<Book> getBooks(String searchBy, String val) {
		if (searchBy.equals("name")) {
			Collections.sort(books, new Comparator<Book>() {
				public int compare(final Book object1, final Book object2) {
					return object1.getName().compareTo(object2.getName());
				}
			});
			int first = -1;
			for (int i = 0; i < books.size(); i++) {
				if (books.get(i) != null && books.get(i).getName().equals(val)) {
					first = i;
					break;
				}
			}
			int last = -1;
			for (int i = books.size() - 1; i >= 0; i--) {
				if (books.get(i) != null && books.get(i).getName().equals(val)) {
					last = i;
					break;
				}
			}
			return books.subList(first, last);
		} else if (searchBy.equals("isbn")) {
			int index = -1;
			for (int i = 0; i < books.size(); i++) {
				if (books.get(i) != null && books.get(i).getIsbn().equals(val)) {
					index = i;
					break;
				}
			}
			List<Book> isbnBook = new ArrayList<Book>();
			isbnBook.add(books.get(index));
			return isbnBook;
		} else if (searchBy.equals("authorName")) {
			Collections.sort(books, new Comparator<Book>() {
				public int compare(final Book object1, final Book object2) {
					return object1.getAuthorName().compareTo(object2.getAuthorName());
				}
			});
			int first = -1;
			for (int i = 0; i < books.size(); i++) {
				if (books.get(i) != null && books.get(i).getAuthorName().equals(val)) {
					first = i;
					break;
				}
			}
			int last = -1;
			for (int i = books.size() - 1; i >= 0; i--) {
				if (books.get(i) != null && books.get(i).getAuthorName().equals(val)) {
					last = i;
					break;
				}
			}
			return books.subList(first, last);
		}
		return null;
	}
}