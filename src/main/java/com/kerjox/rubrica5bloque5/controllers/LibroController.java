package com.kerjox.rubrica5bloque5.controllers;

import com.kerjox.rubrica5bloque5.entities.Libro;
import com.kerjox.rubrica5bloque5.services.DataBaseService;
import com.kerjox.rubrica5bloque5.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LibroController {

	@Autowired()
	//@Qualifier("libroService")
	private LibroService service;

	@GetMapping("libro/list")
	public ModelAndView list() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("libro/list");
		mv.addObject("libros", service.findAll());

		return mv;
	}

	@GetMapping("libro/create")
	public String create() {

		return "lobro/create";
	}

	@PostMapping("libro/create")
	public String create(Libro libro) {

		service.insert(libro);
		return "redirect:libro/list";
	}

	@PostMapping("libro/find")
	public ModelAndView find(String isbn, String nombreAutor) {

		List<Libro> libros = service.findAll();

		if (isbn != null) {

			libros = service.findByIsbn(isbn);
		}

		if (nombreAutor != null) {

			libros = service.findByAutor(nombreAutor);
		}

		ModelAndView mv = new ModelAndView();

		mv.setViewName("libro/list");
		mv.addObject("libros", libros);

		return mv;
	}
}
