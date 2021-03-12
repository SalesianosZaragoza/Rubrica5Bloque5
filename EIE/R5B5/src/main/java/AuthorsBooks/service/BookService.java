package AuthorsBooks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AuthorsBooks.model.Book;
import AuthorsBooks.repository.BookRepository;

@Service("bookService")
public class BookService {

	@Autowired
	private BookRepository repository;

	public void addBook(Book book) {
		repository.insert(book);
	}

	public List<Book> listAllBook(String searchBy, String val) {
		return repository.getBooks(searchBy, val);
	}
}