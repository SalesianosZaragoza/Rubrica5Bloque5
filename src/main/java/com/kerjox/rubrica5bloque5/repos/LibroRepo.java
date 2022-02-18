package com.kerjox.rubrica5bloque5.repos;

import com.kerjox.rubrica5bloque5.entities.Libro;

import java.util.List;

public interface LibroRepo extends RepoService<Libro> {
	List<Libro> getLibrosAutor(String nombreAutor);

	List<Libro> getLibroByIsbn(String isbn);

	List<Libro> getLibroByTitulo(String titulo);
}
