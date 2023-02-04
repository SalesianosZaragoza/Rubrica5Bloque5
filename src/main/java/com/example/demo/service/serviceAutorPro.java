package com.example.demo.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.demo.model.Autor;
import com.example.demo.repository.RepositoryAutor;


@Profile("Pro")
@Service("serviceAutorPro")
public class serviceAutorPro implements ServiceAutor{

	List<Autor> listAutores = new ArrayList<>();

	@Autowired
	@Qualifier("listAutor")
	public RepositoryAutor repository;

	@Override
	public List<Autor> findAllAutors() {
		listAutores = repository.findAllAutors();
		return listAutores;
	}

	@Override
	public void guardarAutor(Autor autor) {
		repository.save(autor);
	}

	@Override
	public List<Autor> findAutorByNombre(String nombre) {
		listAutores = repository.findAutorByNombre(nombre);
		return listAutores;
	}

	@Override
	public List<Autor> findAutorByFechaNacimiento(Date fecha) {
		listAutores = repository.findAutorByFechaNacimiento(fecha);
		return listAutores;
	}

}

