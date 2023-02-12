package com.example.b5r5request.model;

import java.sql.Date;
import java.util.List;

public class Autor {

    private int ID;     // para bbdd
	private String nombre;
	private Date fNac;
	private List<Libro> libros;

    public Autor() {
    }

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
