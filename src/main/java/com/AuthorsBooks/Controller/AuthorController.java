package com.AuthorsBooks.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.AuthorsBooks.Model.AuthorModel;
import com.AuthorsBooks.Service.AuthorInterface;

@Controller
public class AuthorController {
	
	@Autowired
	private AuthorInterface AutorInterfaz;
	
	@PostMapping(path="/formularioAuthor")
	public String saveOwner(@ModelAttribute(name = "author") AuthorModel author) {
		System.out.println(author.toString());
		return "author Saved";
	}
	@GetMapping(path="formularioAuthor")
	public ModelAndView getAddOwnerPage() {
		ModelAndView model = new ModelAndView("formularioAuthor");
		model.addObject(new AuthorModel());
		return model;
	}

	@GetMapping(path = "listAuthor")
	public String getListAuthorPage() {
		return "listAuthor";
	}
}
