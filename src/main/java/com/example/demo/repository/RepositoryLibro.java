package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Libro;


public interface RepositoryLibro {

	void save(Libro libro);
	List<Libro> findAllLibros();
	List<Libro> findLibroByTitulo(String titulo);
	List<Libro> findLibroByIsbn(Integer isbn);
	List<Libro> findLibroByAutor(String autor);
	
}
