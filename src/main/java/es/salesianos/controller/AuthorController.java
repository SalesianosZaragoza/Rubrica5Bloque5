package es.salesianos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Author;
import es.salesianos.service.AuthorService;

@Controller
public class AuthorController {
	
	@Autowired
	private AuthorService service;
	
	@GetMapping("/authors")
	public ModelAndView getAuthors() {
		List <Author> listAuthors = service.searchAll();
		
		ModelAndView modelAndView = new ModelAndView("listAuthors");
		modelAndView.addObject("list", listAuthors);
		modelAndView.addObject("author", new Author());
		return modelAndView;
	}
	
	@GetMapping("/insertAuthor")
	public ModelAndView getInsertAuthor() {
		ModelAndView modelAndView = new ModelAndView("insertAuthor");
		modelAndView.addObject("author", new Author());
		return modelAndView;
	}
	
	@PostMapping("/insertAuthor")
	public ModelAndView insertAuthor(Author author) {
		service.insert(author);
		List <Author> listAuthors = service.searchAll();
		ModelAndView modelAndView = new ModelAndView("listAuthors");
		modelAndView.addObject("list", listAuthors);
		modelAndView.addObject("author", new Author());
		return modelAndView;
		
	}
	
	@PostMapping("/searchAuthorByName")
	public ModelAndView searchAuthorByName(Author author) {
		List <Author> listAuthors = service.searchByName(author);
		
		ModelAndView modelAndView = new ModelAndView("listAuthors");
		modelAndView.addObject("list", listAuthors);
		modelAndView.addObject("author", new Author());
		return modelAndView;
	}
	
	@PostMapping("/searchAuthorByDayOfBirth")
	public ModelAndView searchAuthorByDayOfBirth(Author author) {
		List <Author> listAuthors = service.searchByDayOfBirth(author);
		
		ModelAndView modelAndView = new ModelAndView("listAuthors");
		modelAndView.addObject("list", listAuthors);
		modelAndView.addObject("author", new Author());
		return modelAndView;
	}
}