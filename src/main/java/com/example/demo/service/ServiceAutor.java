package com.example.demo.service;
import java.sql.Date;
import java.util.List;

import com.example.demo.model.Autor;
public interface ServiceAutor {
	List<Autor> findAllAutors();
	void guardarAutor(Autor autor);
	List<Autor> findAutorByNombre(String nombre);
	List<Autor> findAutorByFechaNacimiento(Date fecha);
	Autor findAutorById(int id);

}
