package com.kerjox.rubrica5bloque5.services;


import com.kerjox.rubrica5bloque5.entities.Autor;
import com.kerjox.rubrica5bloque5.repos.AutoresRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class AutoresServiceImpl implements AutoresService {

	@Autowired
	private AutoresRepo repo;

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
