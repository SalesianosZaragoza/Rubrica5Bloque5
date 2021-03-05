package com.AuthorsBooks.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.AuthorsBooks.Model.BooksModel;
import com.AuthorsBooks.Service.BooksInterface;

@Controller
public class BookController {
	
	@Autowired
	private BooksInterface LibrosInterfaz;
	
	@PostMapping(path="/formularioLibro")
	public String saveBook(@ModelAttribute(name = "book") BooksModel book) {
		System.out.println(book.toString());
		return "libroSaved";
	}
	@GetMapping(path="formularioLibro")
	public ModelAndView getAddBookPage() {
		ModelAndView model = new ModelAndView("formularioLibro");
		model.addObject(new BooksModel());
		return model;
	}

	@GetMapping(path = "listBook")
	public String getListBookPage() {
		return "listBook";
	}
}
