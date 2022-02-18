package com.kerjox.rubrica5bloque5.controllers;

import com.kerjox.rubrica5bloque5.entities.Autor;
import com.kerjox.rubrica5bloque5.entities.Libro;
import com.kerjox.rubrica5bloque5.repos.AutoresRepo;
import com.kerjox.rubrica5bloque5.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller
public class LibroController {

	@Autowired
	private LibroService service;

	@Autowired
	private AutoresRepo autoresRepo;

	@GetMapping("libro/list")
	public ModelAndView list() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("libro/list");
		mv.addObject("libros", service.findAll());

		return mv;
	}

	@GetMapping("libro/create")
	public ModelAndView create() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("libro/create");
		mv.addObject("autores", autoresRepo.findAll());

		return mv;
	}

	@PostMapping("libro/create")
	public String create(String titulo, String isbn, Integer autorID) {

		Autor autor = new Autor();
		autor.setID(autorID);

		Libro libro = new Libro();
		libro.setTitulo(titulo);
		libro.setIsbn(isbn);
		libro.setAutor(autor);

		service.insert(libro);
		return "redirect:list";
	}

	@PostMapping("libro/find")
	public ModelAndView find(@RequestParam("titulo") String titulo, @RequestParam("isbn") String isbn, @RequestParam("nombreAutor") String nombreAutor) {

		List<Libro> libros = service.findAll();

		if (!Objects.equals(titulo, "")) {

			libros = service.findByTitulo(titulo);
		}

		if (!Objects.equals(isbn, "")) {

			libros = service.findByIsbn(isbn);
		}

		if (!Objects.equals(nombreAutor, "")) {

			libros = service.findByAutor(nombreAutor);
		}

		ModelAndView mv = new ModelAndView();

		mv.setViewName("libro/list");
		mv.addObject("libros", libros);

		return mv;
	}
}
