package AuthorsBooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import AuthorsBooks.model.Author;
import AuthorsBooks.service.AuthorService;

@Controller
public class AddAuthor {

	@Autowired
	private AuthorService authorservice;

	@PostMapping(path = "addAuthor")
	public String saveAuthor(@ModelAttribute(name = "Author") Author author) {
		authorservice.addAuthor(author);
		System.out.println(author.toString());
		return "authorSaved";
	}
}
