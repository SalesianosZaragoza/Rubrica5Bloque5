package com.kerjox.rubrica5bloque5.services;

import com.kerjox.rubrica5bloque5.entities.Autor;

import java.sql.Date;
import java.util.List;

public interface AutoresService extends DataBaseService<Autor> {

	List<Autor> findByNombre(String nombre);

	List<Autor> findByDate(Date fNac);
}
