package es.salesianos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Author;
import es.salesianos.model.Book;
import es.salesianos.service.AuthorService;
import es.salesianos.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/books")
	public ModelAndView getBooks() {
		List <Book> listBooks = bookService.searchAll();
		ModelAndView modelAndView = new ModelAndView("listBooks");
		modelAndView.addObject("list", listBooks);
		modelAndView.addObject("book", new Book());
		return modelAndView;
	}
	
	@GetMapping("/insertBook")
	public ModelAndView getInsertBook() {
		List<Author>listAuthors = authorService.searchAll();
		ModelAndView modelAndView = new ModelAndView("insertBook");
		modelAndView.addObject("book", new Book());
		modelAndView.addObject("listAuthors", listAuthors);
		return modelAndView;
	}
	
	@PostMapping("/insertBook")
	public ModelAndView insertBook(Book book) {
		bookService.insert(book);
		List <Book> listBooks = bookService.searchAll();
		ModelAndView modelAndView = new ModelAndView("listBooks");
		modelAndView.addObject("list", listBooks);
		modelAndView.addObject("book", new Book());
		return modelAndView;
		
	}
	
	@PostMapping("/searchBookByTitle")
	public ModelAndView searchBookByTitle(Book book) {
		List <Book> listBooks = bookService.searchByTitle(book);
		
		ModelAndView modelAndView = new ModelAndView("listBooks");
		modelAndView.addObject("list", listBooks);
		modelAndView.addObject("book", new Book());
		return modelAndView;
	}
	
	@PostMapping("/searchBookByIsbn")
	public ModelAndView searchBookByIsbn(Book book) {
		List <Book> listBooks = bookService.searchByIsbn(book);
		
		ModelAndView modelAndView = new ModelAndView("listBooks");
		modelAndView.addObject("list", listBooks);
		modelAndView.addObject("book", new Book());
		return modelAndView;
	}
	
	@PostMapping("/searchBookByAuthor")
	public ModelAndView searchBookByAuthor(Book book) {
		List <Book> listBooks = bookService.searchByAuthor(book);
		
		ModelAndView modelAndView = new ModelAndView("listBooks");
		modelAndView.addObject("list", listBooks);
		modelAndView.addObject("book", new Book());
		return modelAndView;
	}
}