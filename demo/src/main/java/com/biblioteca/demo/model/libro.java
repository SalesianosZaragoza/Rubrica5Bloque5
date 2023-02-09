package com.biblioteca.demo.model;

import org.springframework.stereotype.Component;

@Component
public class libro {

    private int id;
    private String titulo;
    private String isbn;
    private int idAutor;

    public libro() {
    }

    public libro(int id, String titulo, String isbn, int idAutor) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.idAutor = idAutor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }   
    
}
