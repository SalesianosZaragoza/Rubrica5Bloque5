package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Libro;


@Repository("listLibro")
public class ListRepositoryLibro implements RepositoryLibro {

	public List<Libro> list = new ArrayList<>();

	@Override
	public void save(Libro libro) {
		list.add(libro);
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
	public List<Libro> findLibroByAutor(String autor) {
		List<Libro> listaDeLibrosQueCoincidenConElAutor = new ArrayList<>();
		for (Libro libro : list) {
			if (libro.getAutor().equals(autor)) {
				listaDeLibrosQueCoincidenConElAutor.add(libro);
			}
		}
		return listaDeLibrosQueCoincidenConElAutor;
	}


}
