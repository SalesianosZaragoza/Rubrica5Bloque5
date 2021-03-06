package es.salesianos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Autor;
import es.salesianos.service.AutorService;

@Controller
public class AutorController {

	@Autowired
	private AutorService service;

	@GetMapping("/autores")
	public ModelAndView getAutores() {
		List<Autor> autores = service.buscarTodo();

		ModelAndView modelAndView = new ModelAndView("autores");
		modelAndView.addObject("list", autores);
		modelAndView.addObject("autor", new Autor());
		return modelAndView;
	}

	@GetMapping("/insertAutor")
	public ModelAndView getInsertAutor() {
		ModelAndView modelAndView = new ModelAndView("insertAutor");
		modelAndView.addObject("autor", new Autor());
		return modelAndView;
	}

	@PostMapping("/insertAuthor")
	public ModelAndView insertAuthor(Autor autor) {
		service.insert(autor);
		List<Autor> autores = service.buscarTodo();
		ModelAndView modelAndView = new ModelAndView("autores");
		modelAndView.addObject("list", autores);
		modelAndView.addObject("autor", new Autor());
		return modelAndView;

	}

	@PostMapping("/buscarAutorPorNombre")
	public ModelAndView buscarAutorPorNombre(Autor autor) {
		List<Autor> autores = service.buscarPorNombre(autor);

		ModelAndView modelAndView = new ModelAndView("autores");
		modelAndView.addObject("list", autores);
		modelAndView.addObject("autor", new Autor());
		return modelAndView;
	}

	@PostMapping("/buscarAutorPorFecha")
	public ModelAndView buscarAutorPorFecha(Autor autor) {
		List<Autor> autores = service.buscarPorFecha(autor);

		ModelAndView modelAndView = new ModelAndView("autores");
		modelAndView.addObject("list", autores);
		modelAndView.addObject("autor", new Autor());
		return modelAndView;
	}
}