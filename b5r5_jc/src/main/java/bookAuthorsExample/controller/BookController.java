package bookAuthorsExample.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import bookAuthorsExample.model.Book;
import bookAuthorsExample.service.AuthorService;
import bookAuthorsExample.service.BookService;

@Controller
public class BookController {
	
	private List<Book> list = new ArrayList<Book>();
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private BookService service;
	
	
	@GetMapping("/books")
	public ModelAndView getBooks() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", service.searchAll());
		modelAndView.addObject("book", new Book());
		modelAndView.setViewName("listBooks");
		return modelAndView;
	}
	
	@PostMapping("/searchBook")
	public ModelAndView searchAuthor(@ModelAttribute("book")Book book) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", service.search(book));
		modelAndView.addObject("book", new Book());
		modelAndView.setViewName("listBooks");
		return modelAndView;
	}
	
	@GetMapping("/insertBook")
	public ModelAndView getInsertBook() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("insertBook");
		modelAndView.addObject("book", new Book());
		modelAndView.addObject("listAuthors", authorService.searchAll());
		return modelAndView;
	}
	
	@PostMapping("/insertBook")
	public void insertBook(@ModelAttribute("book")Book book, HttpServletResponse httpResponse) {
		service.insert(book);
		try {
			httpResponse.sendRedirect("/books");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}