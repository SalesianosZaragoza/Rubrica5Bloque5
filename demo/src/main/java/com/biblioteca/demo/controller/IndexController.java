package com.biblioteca.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.biblioteca.demo.service.serviceAutor;
import com.biblioteca.demo.service.serviceLibro;
import com.biblioteca.demo.model.autor;
import com.biblioteca.demo.model.libro;

@Controller
public class IndexController {
    @Autowired
    private serviceAutor autorRepository;
    @Autowired
    private serviceLibro libroRepository;

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index.jsp");
        modelAndView.addObject("autor", autorRepository.getAllAutores());
        modelAndView.addObject("libro", libroRepository.getAllLibros());
        return modelAndView;
    }

    @PostMapping("/insertAutor")
    public ModelAndView insertAutor(autor autor){
        autorRepository.crearAutor(autor);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("autor", autorRepository.getAllAutores());
        return modelAndView;
    }
    @PostMapping("/insertLibro")
    public ModelAndView insertLibro(libro libro){
        libroRepository.crearLibro(libro);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("libro", libroRepository.getAllLibros());
        return modelAndView;
    }

    @PostMapping("/deleteLibro")
    public ModelAndView deleteLibro(libro libro){
        libroRepository.eliminarLibro(libro.getId());
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("libro", libroRepository.getAllLibros());
        return modelAndView;
    }
    @PostMapping("/buscarLibro")
    public ModelAndView buscarLibro(libro libro){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("libro", libroRepository.buscarLibro(libro.getTitulo(), libro.getIsbn()));
        return modelAndView;
    }

    @PostMapping("/buscarAutor")
    public ModelAndView buscarAutor(autor autor){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("autor", autorRepository.buscarAutor(autor.getNombre(), autor.getFechaNacimiento()));
        return modelAndView;
    }
    
    
}
