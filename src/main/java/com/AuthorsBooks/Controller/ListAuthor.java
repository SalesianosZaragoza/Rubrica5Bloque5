package com.AuthorsBooks.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.AuthorsBooks.Model.AuthorModel;
import com.AuthorsBooks.Service.AuthorInterface;

@Controller
public class ListAuthor {

	@Autowired
	@Qualifier("AuthorService")
	AuthorInterface service;

	@PostMapping(path = "/listAuthor")
	public ModelAndView addAuthor() {
		List<AuthorModel> author = service.listAllA();
		System.out.println(author);
		ModelAndView model = new ModelAndView("listAuthor");
		model.addObject("listAllA", author);
		return model;
	}

}
