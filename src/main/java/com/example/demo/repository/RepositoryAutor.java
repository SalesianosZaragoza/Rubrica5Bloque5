package com.example.demo.repository;

import java.sql.Date;
import java.util.List;

import com.example.demo.model.Autor;

public interface RepositoryAutor {

	void save(Autor autor);
	List<Autor> findAllAutors();
	List<Autor> findAutorByNombre(String nombre);
	List<Autor> findAutorByFechaNacimiento(Date fecha);
	Autor findAutorById(int id);
	int generarId();
}
