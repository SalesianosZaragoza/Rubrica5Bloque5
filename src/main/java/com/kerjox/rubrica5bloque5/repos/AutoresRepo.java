package com.kerjox.rubrica5bloque5.repos;

import com.kerjox.rubrica5bloque5.entities.Autor;

import java.sql.Date;
import java.util.List;

public interface AutoresRepo extends RepoService<Autor> {
	List<Autor> findAll();

	List<Autor> findByNombre(String nombreAutor);

	List<Autor> findByDate(Date fNac);
}
