package es.salesianos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Autor;
import es.salesianos.model.Libros;
import es.salesianos.service.AutorService;
import es.salesianos.service.LibroService;

@Controller
public class LibroController {

	@Autowired
	private LibroService libroService;

	@Autowired
	private AutorService autorService;

	@GetMapping("/libros")
	public ModelAndView getLibros() {
		List<Libros> libros = libroService.buscarTodo();
		ModelAndView modelAndView = new ModelAndView("libros");
		modelAndView.addObject("list", libros);
		modelAndView.addObject("libro", new Libros());
		return modelAndView;
	}

	@GetMapping("/insertLibro")
	public ModelAndView getInsertLibros() {
		List<Autor> autores = autorService.buscarTodo();
		ModelAndView modelAndView = new ModelAndView("insertLibro");
		modelAndView.addObject("libro", new Libros());
		modelAndView.addObject("autores", autores);
		return modelAndView;
	}

	@PostMapping("/insertLibro")
	public ModelAndView insertLibro(Libros libro) {
		libroService.insert(libro);
		List<Libros> libros = libroService.buscarTodo();
		ModelAndView modelAndView = new ModelAndView("libros");
		modelAndView.addObject("list", libros);
		modelAndView.addObject("libro", new Libros());
		return modelAndView;

	}

	@PostMapping("/buscarLibroPorTitulo")
	public ModelAndView buscarLibroPorTitulo(Libros libro) {
		List<Libros> libros = libroService.buscarPorTitulo(libro);

		ModelAndView modelAndView = new ModelAndView("libros");
		modelAndView.addObject("list", libros);
		modelAndView.addObject("libro", new Libros());
		return modelAndView;
	}

	@PostMapping("/buscarLibroPorIsbn")
	public ModelAndView buscarLibroPorIsbn(Libros libro) {
		List<Libros> libros = libroService.buscarPorIsbn(libro);

		ModelAndView modelAndView = new ModelAndView("libros");
		modelAndView.addObject("list", libros);
		modelAndView.addObject("libro", new Libros());
		return modelAndView;
	}

	@PostMapping("/buscarLibroPorAutor")
	public ModelAndView buscarLibroPorAutor(Libros libro) {
		List<Libros> libros = libroService.buscarPorAutor(libro);

		ModelAndView modelAndView = new ModelAndView("libros");
		modelAndView.addObject("list", libros);
		modelAndView.addObject("libro", new Libros());
		return modelAndView;
	}
}
