package AuthorsBooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import AuthorsBooks.service.AuthorService;

@Controller
public class ListAuthor {

	@Autowired
	AuthorService authorservice;

	@PostMapping(path = "/listAllAuthor")
	public ModelAndView listAllAuthor(@RequestParam String searchBy, @RequestParam String val) {
		ModelAndView model = new ModelAndView("listAuthor");
		model.addObject("listAllAuthor", authorservice.listAllAuthor(searchBy, val));
		return model;
	}
}