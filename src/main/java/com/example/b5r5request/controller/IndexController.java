package com.example.b5r5request.controller;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.b5r5request.model.Autor;
import com.example.b5r5request.model.Libro;
import com.example.b5r5request.service.IServiceAutor;
import com.example.b5r5request.service.IServiceLibro;

@Controller
public class IndexController {
    
    
    public IServiceAutor serviceAutor;
    public IServiceLibro serviceLibro;

    @Autowired
    public IndexController(IServiceAutor serviceAutor, IServiceLibro serviceLibro) {
        this.serviceAutor = serviceAutor;
        this.serviceLibro = serviceLibro;
    }
    

    @GetMapping("/")
    public ModelAndView goToIndexPage(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }


    // INSERTAR AUTOR

    @GetMapping("goFormInsertarAutor")
    public ModelAndView goToFormInsertarAutor(){
        ModelAndView modelAndView = new ModelAndView("insertarAutor");

        Autor autor = new Autor();
        modelAndView.addObject("autor", autor);
        return modelAndView;
    }

    @PostMapping("addAutor")
    public ModelAndView InsertAutor(@ModelAttribute("autor") Autor autor){
        serviceAutor.insert(autor);
        ModelAndView modelAndView = new ModelAndView("verificar");
        return modelAndView;
    } 


    
    // INSERTAR LIBRO

    @GetMapping("goFormInsertarLibro")
    public ModelAndView goToFormInsertarLibro(){
        ModelAndView modelAndView = new ModelAndView("insertarLibro");
        List<Autor> listaAutores = serviceAutor.findAll();
        modelAndView.addObject("listaAutores", listaAutores);

        return modelAndView;
    }
    
    @PostMapping("addLibro")
    public ModelAndView InsertLibro(String titulo, String isbn, int autorID){  // atributos individuales para crear libro
        Autor autor = new Autor();
        autor.setID(autorID);
        
        Libro libro = new Libro();
        libro.setTitulo(titulo);
        libro.setIsbn(isbn);
        libro.setAutor(autor);

        serviceLibro.insert(libro);
        ModelAndView modelAndView = new ModelAndView("verificar");
        return modelAndView;
    }


    // LISTADO AUTORES

    @GetMapping("goListAutores")
    public ModelAndView goToListAutores(){
        ModelAndView modelAndView = new ModelAndView("listAutores");
        List<Autor> listaAutores = serviceAutor.findAll();
        modelAndView.addObject("listaAutores", listaAutores);
        return modelAndView;
    }

    @PostMapping("buscarAutores")
    public ModelAndView buscarAutores(@RequestParam(value="nombre", required = false) String nombre, @RequestParam(value="fNac", required = false) String fNac ){
        List<Autor> listaAutores = serviceAutor.findAll();

        if(!Objects.equals(nombre, "")){
            listaAutores = serviceAutor.findByNombre(nombre);
        } else if (!Objects.equals(fNac, "")){
            listaAutores = serviceAutor.findByFnac(Date.valueOf(fNac));
        }

        ModelAndView modelAndView = new ModelAndView("listAutores");
        modelAndView.addObject("listaAutores", listaAutores);

        return modelAndView;
    }

    // LISTADO LIBROS

    @GetMapping("goListLibros")
    public ModelAndView goToListLibros(){
        ModelAndView modelAndView = new ModelAndView("listLibros");
        List<Libro> listaLibros = serviceLibro.findAll();
        modelAndView.addObject("listaLibros", listaLibros);
        return modelAndView;
    }

    @PostMapping("buscarLibros")
    public ModelAndView buscarLibros(@RequestParam(value="titulo", required = false) String titulo, @RequestParam(value="isbn", required = false) String isbn, @RequestParam(value="nombreAutor", required = false) String nombreAutor){
        List<Libro> listaLibros = serviceLibro.findAll();

        if(!Objects.equals(titulo, "")){
            listaLibros = serviceLibro.findbyTitulo(titulo);
        } else if (!Objects.equals(isbn, "")){
            listaLibros = serviceLibro.findByIsbn(isbn);
        } else if(!Objects.equals(nombreAutor, "")){
            listaLibros = serviceLibro.findByAutor(nombreAutor);
        }

        ModelAndView modelAndView = new ModelAndView("listLibros");
        modelAndView.addObject("listaLibros", listaLibros);

        return modelAndView;
    }

}
