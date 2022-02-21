package com.serguipe.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serguipe.entities.Autor;
import com.serguipe.repositories.AutoresRepoService;

@Service
public class AutoresServiceImpl implements AutoresService{

	@Autowired
	private AutoresRepoService repo;

	@Override
	public void insert(Autor autor) {

		repo.insert(autor);
	}

	@Override
	public void delete(Integer id) {

		repo.delete(id);
	}

	@Override
	public List<Autor> findAll() {

		return repo.findAll();
	}

	@Override
	public List<Autor> findByNombre(String nombre) {

		return repo.findByNombre(nombre);
	}

	@Override
	public List<Autor> findByDate(Date fNac) {

		return repo.findByDate(fNac);
	}

}

