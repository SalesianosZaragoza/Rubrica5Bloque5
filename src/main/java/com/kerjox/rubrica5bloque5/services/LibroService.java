package com.kerjox.rubrica5bloque5.services;

import com.kerjox.rubrica5bloque5.entities.Libro;
import com.kerjox.rubrica5bloque5.repos.LibroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("libroService")
public class LibroService implements DataBaseService<Libro>{

	@Autowired
	private LibroRepo repo;

	@Override
	public void insert(Libro libro) {

	}

	@Override
	public void delete(Integer id) {

	}
  @Override
	public List<Libro> findAll() {
		return null;
	}

	public List<Libro> findByIsbn(String isbn) {

		return repo.getLibroByIsbn(isbn);
	}

	public List<Libro> findByAutor(String nombreAutor) {

		return repo.getLibrosAutor(nombreAutor);
	}
}
