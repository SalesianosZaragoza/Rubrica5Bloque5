package es.salesianos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.Autor;
import es.salesianos.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository repository;

	public void insert(Autor autor) {
		repository.Insert(autor);
	}

	public List<Autor> buscarTodo() {
		return repository.buscarTodo();
	}

	public List<Autor> buscarPorNombre(Autor autor) {
		return repository.buscarPorNombre(autor.getNombre());
	}

	public List<Autor> buscarPorFecha(Autor autor) {
		return repository.buscarPorFecha(autor.getFechaNac());
	}
}
