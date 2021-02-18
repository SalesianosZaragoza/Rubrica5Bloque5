package com.B5R5.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.B5R5.model.Book;
import com.B5R5.service.AuthorService;
import com.B5R5.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService service;

	@Autowired
	private AuthorService authorService;

	@GetMapping("/books")
	public ModelAndView getBooks() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("book", new Book());
		modelAndView.setViewName("bookList");
		return modelAndView;
	}

	@GetMapping("/insertBook")
	public ModelAndView getInsertBook() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("insertBook");
		modelAndView.addObject("book", new Book());
		modelAndView.addObject("authorList", authorService.searchAll());
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

	@PostMapping("/searchBook")
	public ModelAndView searchAuthor(@ModelAttribute("book")Book book) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("book", new Book());
		modelAndView.setViewName("bookList");
		return modelAndView;
	}
} 