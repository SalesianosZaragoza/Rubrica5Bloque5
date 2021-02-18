package com.B5R5.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.B5R5.model.Author;
import com.B5R5.service.AuthorService;

@Controller
public class AuthorController {

	@Autowired
	private AuthorService service;

	@GetMapping("/authors")
	public ModelAndView getAuthors() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("author", new Author());
		modelAndView.setViewName("authorList");
		return modelAndView;
	}

	@GetMapping("/insertAuthor")
	public ModelAndView getInsertAuthor() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("insertAuthor");
		modelAndView.addObject("author", new Author());
		return modelAndView;
	}

	@PostMapping("/insertAuthor")
	public void insertAuthor(@ModelAttribute("author")Author author, HttpServletResponse httpResponse) {
		service.insert(author);
		try {
			httpResponse.sendRedirect("/authors");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@PostMapping("/searchAuthor")
	public ModelAndView searchAuthor(@ModelAttribute("author")Author author) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("author", new Author());
		modelAndView.setViewName("authorList");
		return modelAndView;
	}
} 