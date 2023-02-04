package com.example.demo.service;
import java.util.List;

import com.example.demo.model.Libro;


public interface ServiceLibro {
	List<Libro> findAllLibros();
	void guardarLibro(Libro libro);
	List<Libro> findLibroByTitulo(String titulo);
	List<Libro> findLibroByIsbn(Integer isbn);
	List<Libro> findLibroByAutor(String autor);
	
}
