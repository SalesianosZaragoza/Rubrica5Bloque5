package es.salesianos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.Book;
import es.salesianos.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired 
	private BookRepository repository;
	
	public void insert(Book book) {
		repository.insert(book);
	}
	
	public List<Book> searchAll() {
		return repository.searchAll();
	}
	
	public List<Book> searchByTitle(Book book) {
		return repository.searchByTitle(book.getTitle());
	}
	
	public List<Book> searchByIsbn(Book book) {
		return repository.searchByIsbn(book.getIsbn());
	}
	
	public List<Book> searchByAuthor(Book book) {
		return repository.searchByAuthor(book.getAuthorName());
	}
}