package com.serguipe.repositories;

import java.sql.Date;
import java.util.List;

import com.serguipe.entities.Autor;

public interface AutoresRepoService extends ReposService<Autor>{

	List<Autor> findAll();

	List<Autor> findByNombre(String nombreAutor);

	List<Autor> findByDate(Date fNac);
}
