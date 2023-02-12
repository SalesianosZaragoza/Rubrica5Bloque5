package com.example.springbootb5r5.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.View;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import com.example.springbootb5r5.model.Author;
import com.example.springbootb5r5.model.Book;
import com.example.springbootb5r5.model.Search;
import com.example.springbootb5r5.service.AuthorService;
import com.example.springbootb5r5.service.BookService;

@Controller
public class IndexController {

	
	public AuthorService authorService;
	public BookService bookService;
	
	@Autowired
	public IndexController(AuthorService authorService, BookService bookService) {
		this.authorService = authorService;
		this.bookService = bookService;
	}
	
	@GetMapping("/")
	public ModelAndView goToIndexPage() {
		ModelAndView modelAndView = new ModelAndView("index");
		
		
		return modelAndView;
	}
	
	@GetMapping("/goAuthorForm")
	public ModelAndView goAuthorForm() {
		ModelAndView m = new ModelAndView("addAuthor");
		Author author = new Author();
		
		m.addObject(author);
		
		return m;
	}
	
	@GetMapping("/goBookForm")
	public ModelAndView goBookForm() {
		ModelAndView m = new ModelAndView("addBook");
		Book book = new Book();
		
		List<Author> authors = authorService.getAuthors();
		
		m.addObject("authors",authors);
		m.addObject(book);
		
		return m;
	}
	
	@PostMapping("/listAuthors")
	public ModelAndView searchAuthors(Search search) {
		ModelAndView m = new ModelAndView("listAuthors");
		
		
		List<Author> allAuthors = authorService.getAuthors();
		List<Author> authors = new ArrayList<>();
		
		for (Author author : allAuthors) {
			if (author.getName().contains(search.getSearch()) || author.getBirthday().contains(search.getSearch())) {
				authors.add(author);
			}
		}
		
		m.addObject("authors", authors);
		return m;
	}
	
	@PostMapping("/listBooks")
	public ModelAndView searchBooks(Search search) {
		ModelAndView m = new ModelAndView("listBooks");
		
		List<Book> allBooks = bookService.getBooks();
		List<Book> books = new ArrayList<>();
		
		for (Book book : allBooks) {
			if (book.getTitle().contains(search.getSearch()) || book.getIsbn().contains(search.getSearch()) || book.getNom_author().contains(search.getSearch())) {
				books.add(book);
			}
		}
		
		m.addObject("books", books);
		return m;
	}
	
	@GetMapping("/goAuthorList")
	public ModelAndView goAuthorList() {
		ModelAndView m = new ModelAndView("listAuthors");
		Search search = new Search();
		List<Author> authors = authorService.getAuthors();
		
		m.addObject("authors",authors);
		m.addObject(search);
		return m;
	}
	
	@GetMapping("/goBookList")
	public ModelAndView goBookList() {
		ModelAndView m = new ModelAndView("listBooks");
		Search search = new Search();
		List<Book> books = bookService.getBooks();
		
		m.addObject("books",books);
		m.addObject(search);
		return m;
	}
	
	
	
	@PostMapping("addAuthorForm")
	public ModelAndView addAuthorForm(@ModelAttribute("author") Author author) {
		authorService.add(author);
		//l.info(owner.toString());  ESTO SACA POR LOG EL TOSTRING DEL DUEÑO
		
		ModelAndView m = new ModelAndView("index");
		
		return m;
	}
	
	@PostMapping("addBookForm")
	public ModelAndView addBookForm(@ModelAttribute("book") Book book) {
		bookService.add(book);
		Author author = authorService.getAuthorById(book.getId_author());
		book.setNom_author(author.getName());
		//l.info(owner.toString());  ESTO SACA POR LOG EL TOSTRING DEL DUEÑO
		
		ModelAndView m = new ModelAndView("index");
		
		return m;
	}
	
}
