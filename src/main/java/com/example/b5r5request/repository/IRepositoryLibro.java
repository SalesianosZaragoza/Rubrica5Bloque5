package com.example.b5r5request.repository;

import java.util.List;

import com.example.b5r5request.model.Libro;

public interface IRepositoryLibro {
    
    void insert(Libro libro);
    List<Libro> findAll();
    List<Libro> findbyTitulo(String titulo);
    List<Libro> findByIsbn(String isbn);
    List<Libro> findByAutor(String nomAutor);
}
