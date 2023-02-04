package com.kerjox.rubrica5bloque5.services;

import com.kerjox.rubrica5bloque5.entities.Libro;

import java.util.List;

public interface LibroService extends DataBaseService<Libro> {
	List<Libro> findByIsbn(String isbn);

	List<Libro> findByAutor(String nombreAutor);

	List<Libro> findByTitulo(String titulo);
}
