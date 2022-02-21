package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.models.Author;
import com.example.services.DatabaseService;

@Controller
public class AuthorController {

	@Autowired
	private DatabaseService service;

	public DatabaseService getService() {
		return service;
	}

	public void setService(DatabaseService service) {
		this.service = service;
	}

	@GetMapping("/insertAuthor")
	public String insertAuthor(Author author) {
		service.insert(author);
		return "fin";
	}

	@GetMapping("/")
	public ModelAndView welcome() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		modelAndView.addObject("author", new Author());
		return modelAndView;
	}
}
