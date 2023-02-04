package com.example.demo.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Autor;


@Repository("listAutor")
public class ListRepositoryAutor implements RepositoryAutor {

	public List<Autor> listAutors = new ArrayList<>();

	@Override
	public void save(Autor autor) {
		listAutors.add(autor);
	}

	@Override
	public List<Autor> findAllAutors() {
		return listAutors;
	}

	@Override
	public List<Autor> findAutorByNombre(String nombre){
		// recorrer la lista, y si coincide el nombre con el nombre de la lista devolver la lista de autores
		List<Autor> autoresQueCoinciden = new ArrayList<>();
		for (Autor autor : listAutors) {
			if(autor.getNombre().equals(nombre)) {
				autoresQueCoinciden.add(autor);
			}
		}
		return autoresQueCoinciden;
	}

	@Override
	public List<Autor> findAutorByFechaNacimiento(Date fecha){
		// recorrer la lista, y si coincide la fecha con la fecha de la lista devolver la lista de autores
		List<Autor> autoresQueCoinciden = new ArrayList<>();
		for (Autor autor : listAutors) {
			if(autor.getFecha_nacimiento().equals(fecha)) {
				autoresQueCoinciden.add(autor);
			}else {
				System.out.println("No hay autores con esa fecha");
			}
		}
		return autoresQueCoinciden;
	}
	

	

}
