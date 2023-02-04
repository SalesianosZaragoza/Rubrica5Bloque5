package com.kerjox.rubrica5bloque5.entities;

import java.sql.Date;
import java.util.List;

public class Autor {

	private int ID;
	private String nombre;
	private Date fNac;
	private List<Libro> libros;

	public Autor() {
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public java.sql.Date getfNac() {
		return fNac;
	}

	public void setfNac(Date fNac) {
		this.fNac = fNac;
	}
}
