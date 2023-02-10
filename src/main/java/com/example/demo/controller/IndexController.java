package com.example.demo.controller;


import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Autor;
import com.example.demo.model.Libro;
import com.example.demo.service.ServiceLibro;
import com.example.demo.service.ServiceAutor;

@Controller
public class IndexController {

	@Autowired
	public Autor autor;
	@Autowired
	public Libro libro;
	@Autowired
	@Qualifier("serviceAutorPro")
	ServiceAutor serviceAutor;
	@Autowired
	@Qualifier("serviceLibroPro")
	ServiceLibro serviceLibro;

	public IndexController(Autor autor, ServiceAutor serviceAutor, Libro libro, ServiceLibro serviceLibro) {
		this.autor = autor;
		this.serviceAutor = serviceAutor;
		this.libro = libro;
		this.serviceLibro = serviceLibro;
	}

	@GetMapping("/")
	public ModelAndView index2() {
		ModelAndView modelAndView = new ModelAndView("inicio");
		return modelAndView;
	}
	

	@GetMapping("index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("autor", this.autor);
		return modelAndView;
	}

	@PostMapping("addAutorForm")
	public ModelAndView autorInsert(Autor autorForm) {
		ModelAndView modelAndView = new ModelAndView("listAutor");
		serviceAutor.guardarAutor(autorForm);
		var listAutor = serviceAutor.findAllAutors();
		modelAndView.addObject("listAutor", listAutor);
		return modelAndView;
	}

	@GetMapping("/libro")
	public ModelAndView libro() {
		ModelAndView modelAndView = new ModelAndView("libro");
		modelAndView.addObject("listAutor", serviceAutor.findAllAutors());
		modelAndView.addObject("libro", this.libro);
		return modelAndView;
	}
	@PostMapping("addLibroForm")
	public ModelAndView libroInsert(Libro libroForm) {
		ModelAndView modelAndView = new ModelAndView("listLibro");
		serviceLibro.guardarLibro(libroForm);
		var listLibro = serviceLibro.findAllLibros();
		modelAndView.addObject("listLibro", listLibro);
		return modelAndView;
	}

	//metodo post para obtener las busqueda de autores por el nombre
	@PostMapping("SearchNombre")
	public ModelAndView searchAutorNombre(String nombre) {
		ModelAndView modelAndView = new ModelAndView("listAutor");
		var listAutor = serviceAutor.findAutorByNombre(nombre);
		modelAndView.addObject("listAutor", listAutor);
		return modelAndView;
	}

	@PostMapping("SearchNacimiento")
	public ModelAndView searchAutorFechaNacimiento(Date fecha) {
		ModelAndView modelAndView = new ModelAndView("listAutor");
		var listAutor = serviceAutor.findAutorByFechaNacimiento(fecha);
		modelAndView.addObject("listAutor", listAutor);
		return modelAndView;
	}
	
	// crear metodo get para recargar la pagina de listAutor
	@GetMapping("reloadListAutor")
	public ModelAndView listAutor() {
		ModelAndView modelAndView = new ModelAndView("listAutor");
		var listAutor = serviceAutor.findAllAutors();
		modelAndView.addObject("listAutor", listAutor);
		return modelAndView;
	}

	// crear metodo post para obtener la busqueda de libros por el titulo
	@PostMapping("SearchTitulo")
	public ModelAndView searchLibroTitulo(String titulo) {
		ModelAndView modelAndView = new ModelAndView("listLibro");
		var listLibro = serviceLibro.findLibroByTitulo(titulo);
		modelAndView.addObject("listLibro", listLibro);
		return modelAndView;
	}

	@PostMapping("SearchIsbn")
	public ModelAndView searchLibroIsbn(Integer isbn) {
		ModelAndView modelAndView = new ModelAndView("listLibro");
		var listLibro = serviceLibro.findLibroByIsbn(isbn);
		modelAndView.addObject("listLibro", listLibro);
		return modelAndView;
	}

	@PostMapping("SearchAutor")
	public ModelAndView searchLibroAutor(Integer autor_id) {
		ModelAndView modelAndView = new ModelAndView("listLibro");
		var listLibro = serviceLibro.findLibroByAutor(autor_id);
		modelAndView.addObject("listLibro", listLibro);
		return modelAndView;
	}

	// crear metodo get para recargar la pagina de listLibro
	@GetMapping("reloadListLibro")
	public ModelAndView listLibro() {
		ModelAndView modelAndView = new ModelAndView("listLibro");
		var listLibro = serviceLibro.findAllLibros();
		modelAndView.addObject("listLibro", listLibro);
		return modelAndView;
	}

}
