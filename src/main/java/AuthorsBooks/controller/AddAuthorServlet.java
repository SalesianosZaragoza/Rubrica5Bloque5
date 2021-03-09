package AuthorsBooks.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import AuthorsBooks.model.Author;
import AuthorsBooks.service.AuthorService;

@Controller
public class AddAuthorServlet {
	
	@Autowired
	private AuthorService service;
	
	@PostMapping(path = "addAuthor")
	public String saveAuthor(@ModelAttribute(name = "Author") Author author) {
		service.addAuthor(author);
		System.out.println(author.toString());
		return "authorSaved";
	}
}