package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Libro {

    private String titulo;
    private Integer isbn;
    private String autor;

    

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    

    
	
	
}
