package com.serguipe.entities;

import java.sql.Date;
import java.util.List;

public class Autor {

	private int ID;
	private String nombre;
	private Date fNac;
	private List<Libro> libros;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getfNac() {
		return fNac;
	}
	public void setfNac(Date fNac) {
		this.fNac = fNac;
	}
	public List<Libro> getLibros() {
		return libros;
	}
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
    	
	
}
