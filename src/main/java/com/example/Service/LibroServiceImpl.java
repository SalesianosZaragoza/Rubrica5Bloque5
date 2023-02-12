package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Model.Libro;
import com.example.Repository.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService {
    @Autowired
    private LibroRepository repo;

    @Override
    public void insert(Libro libro) {
        repo.insert(libro);
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Libro> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Libro> findByIsbn(String isbn) {

        return repo.getLibroByIsbn(isbn);
    }

    @Override
    public List<Libro> findByAutor(String nombreAutor) {

        return repo.getLibrosAutor(nombreAutor);
    }

    @Override
    public List<Libro> findByTitulo(String titulo) {
        return repo.getLibroByTitulo(titulo);
    }
}
