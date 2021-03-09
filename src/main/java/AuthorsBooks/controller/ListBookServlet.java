package AuthorsBooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import AuthorsBooks.service.BookService;

@Controller
public class ListBookServlet {

	@Autowired
	BookService service;

	@PostMapping(path = "/listAllBook")
	public ModelAndView listAllBook(@RequestParam String searchBy, @RequestParam String val) {
		ModelAndView model = new ModelAndView("listBook");
		model.addObject("listAllBook", service.listAllBook(searchBy, val));
		return model;
	}
}
