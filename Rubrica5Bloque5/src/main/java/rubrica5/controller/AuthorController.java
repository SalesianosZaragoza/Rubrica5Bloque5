package rubrica5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import rubrica5.model.Author;
import rubrica5.service.AuthorService;

@Controller
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/insertAuthor")
	public ModelAndView insertAuthor() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("insertAuthor");
		modelAndView.addObject("author", new Author());
		return modelAndView;
	}
	
	@PostMapping("/insertAuthor")
	public ModelAndView insertAuthor(@ModelAttribute("author")Author author) {
		authorService.insert(author);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", authorService.searchAll());
		modelAndView.addObject("author", new Author());
		modelAndView.setViewName("listAuthors");
		return modelAndView;
	}
	
	@PostMapping("/searchAuthor")
	public ModelAndView searchAuthor(@ModelAttribute("author")Author author) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", authorService.search(author));
		modelAndView.addObject("author", new Author());
		modelAndView.setViewName("listAuthors");
		return modelAndView;
	}
}