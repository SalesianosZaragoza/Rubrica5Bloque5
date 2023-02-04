package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.demo.model.Libro;
import com.example.demo.repository.RepositoryLibro;


@Profile("ProLibro")
@Service("serviceLibroPro")
public class serviceLibroPro implements ServiceLibro{

	List<Libro> listLibros = new ArrayList<>();

	@Autowired
	@Qualifier("listLibro")
	public RepositoryLibro repository;


	@Override
	public List<Libro> findAllLibros() {
		listLibros = repository.findAllLibros();
		return listLibros;
	}

	@Override
	public void guardarLibro(Libro libro) {
		repository.save(libro);
	}

	@Override
	public List<Libro> findLibroByTitulo(String titulo) {
		listLibros = repository.findLibroByTitulo(titulo);
		return listLibros;
	}

	@Override
	public List<Libro> findLibroByIsbn(Integer isbn) {
		listLibros = repository.findLibroByIsbn(isbn);
		return listLibros;
	}

	@Override
	public List<Libro> findLibroByAutor(String autor) {
		listLibros = repository.findLibroByAutor(autor);
		return listLibros;
	}

	

}

