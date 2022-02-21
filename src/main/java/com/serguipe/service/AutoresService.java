package com.serguipe.service;

import java.sql.Date;
import java.util.List;

import com.serguipe.entities.Autor;

public interface AutoresService extends DBService<Autor>{
	
	List<Autor> findByNombre(String nombre);

	List<Autor> findByDate(Date fNac);

}
