package com.serguipe.service;

import java.util.List;

import com.serguipe.entities.Libro;

public interface LibrosService extends DBService<Libro> {

	List<Libro> findByIsbn(String isbn);

	List<Libro> findByAutor(String nombreAutor);

	List<Libro> findByTitulo(String titulo);
}
