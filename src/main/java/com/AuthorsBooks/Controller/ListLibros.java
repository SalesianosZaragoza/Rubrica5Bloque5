package com.AuthorsBooks.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.AuthorsBooks.Model.BooksModel;
import com.AuthorsBooks.Service.BooksInterface;

@Controller
public class ListLibros {

	@Autowired
	@Qualifier("BookService")
	BooksInterface service;

	@PostMapping(path = "/listBooks")
	public ModelAndView addBook() {
		List<BooksModel> book = service.listAllB();
		System.out.println(book);
		ModelAndView model = new ModelAndView("listBook");
		model.addObject("listAllB", book);
		return model;
	}

}
