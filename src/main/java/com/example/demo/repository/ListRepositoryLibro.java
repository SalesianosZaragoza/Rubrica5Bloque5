package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Libro;
import com.example.demo.service.ServiceAutor;


@Repository("listLibro")
public class ListRepositoryLibro implements RepositoryLibro {

	public List<Libro> list = new ArrayList<>();

	@Autowired
	ServiceAutor serviceAutor;

	@Override
	public void save(Libro libro) {
		list.add(libro);
		serviceAutor.findAutorById(libro.getAutor_id()).getLibros().add(libro);
	}

	@Override
	public List<Libro> findAllLibros() {
		return list;
	}

	@Override
	public List<Libro> findLibroByTitulo(String titulo) {
		List<Libro> listaDeLibrosQueCoincidenConElTitulo = new ArrayList<>();
		for (Libro libro : list) {
			if (libro.getTitulo().equals(titulo)) {
				listaDeLibrosQueCoincidenConElTitulo.add(libro);
			}
		}
		return listaDeLibrosQueCoincidenConElTitulo;
	}

	@Override
	public List<Libro> findLibroByIsbn(Integer isbn) {
		List<Libro> listaDeLibrosQueCoincidenConElIsbn = new ArrayList<>();
		for (Libro libro : list) {
			if (libro.getIsbn() == isbn) {
				listaDeLibrosQueCoincidenConElIsbn.add(libro);
			}
		}
		return listaDeLibrosQueCoincidenConElIsbn;
	}

	@Override
	public List<Libro> findLibroByAutorId(Integer autor_id) {
		List<Libro> listaDeLibrosQueCoincidenConElAutor = new ArrayList<>();
		for (Libro libro : list) {
			if (libro.getAutor_id() == autor_id) {
				listaDeLibrosQueCoincidenConElAutor.add(libro);
			}
		}
		return listaDeLibrosQueCoincidenConElAutor;
	}



}
