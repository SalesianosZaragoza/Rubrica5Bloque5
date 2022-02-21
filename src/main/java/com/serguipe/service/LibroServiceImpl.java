package com.serguipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serguipe.entities.Libro;
import com.serguipe.repositories.LibrosReposService;

@Service
public class LibroServiceImpl implements LibrosService{
	
	@Autowired
	private LibrosReposService repo;

	@Override
	public void insert(Libro libro) {
		repo.insert(libro);
	}

	@Override
	public void delete(Integer id) {

	}
  @Override
	public List<Libro> findAll() {
		return repo.findAll();
	}

	@Override
	public List<Libro> findByIsbn(String isbn) {

		return repo.getLibroByIsbn(isbn);
	}

	@Override
	public List<Libro> findByAutor(String nombreAutor) {

		return repo.getLibrosAutor(nombreAutor);
	}

	@Override
	public List<Libro> findByTitulo(String titulo) {
		return repo.getLibroByTitulo(titulo);
	}

}
