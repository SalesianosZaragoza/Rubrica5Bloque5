package com.example.b5r5request.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.b5r5request.model.Libro;
import com.example.b5r5request.repository.IRepositoryLibro;

@Service
public class ServiceLibro implements IServiceLibro {

    @Autowired
    public IRepositoryLibro repositoryLibro;


    @Override
    public void insert(Libro libro) {
        repositoryLibro.insert(libro);
    }

    @Override
    public List<Libro> findAll() {
        return repositoryLibro.findAll();
    }

    @Override
    public List<Libro> findByAutor(String nomAutor) {
        return repositoryLibro.findByAutor(nomAutor);
    }

    @Override
    public List<Libro> findByIsbn(String isbn) {
        return repositoryLibro.findByIsbn(isbn);
    }

    @Override
    public List<Libro> findbyTitulo(String titulo) {
        return repositoryLibro.findbyTitulo(titulo);
    }
    
}
