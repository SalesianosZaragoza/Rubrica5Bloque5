package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Libro {

    private String titulo;
    private Integer isbn;
    private int autor_id;

    

    

    

    public int getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(int autor_id) {
        this.autor_id = autor_id;
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
