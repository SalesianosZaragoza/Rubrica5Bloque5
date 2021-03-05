package es.salesianos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.Libros;
import es.salesianos.repository.LibroRepository;

@Service
public class LibroService {

	@Autowired
	private LibroRepository repository;

	public void insert(Libros libros) {
		repository.insert(libros);
	}

	public List<Libros> buscarTodo() {
		return repository.buscarTodo();
	}

	public List<Libros> buscarPorTitulo(Libros libro) {
		return repository.buscarPorTitulo(libro.getTitulo());
	}

	public List<Libros> buscarPorIsbn(Libros libro) {
		return repository.buscarPorIsbn(libro.getIsbn());
	}

	public List<Libros> buscarPorAutor(Libros libro) {
		return repository.buscarPorAutor(libro.getNombreAutor());
	}
}
