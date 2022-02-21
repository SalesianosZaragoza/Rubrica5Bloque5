package com.serguipe.repositories;

import java.util.List;

import com.serguipe.entities.Libro;

public interface LibrosReposService extends ReposService<Libro> {

	List<Libro> getLibrosAutor(String nombreAutor);

	List<Libro> getLibroByIsbn(String isbn);

	List<Libro> getLibroByTitulo(String titulo);
}
