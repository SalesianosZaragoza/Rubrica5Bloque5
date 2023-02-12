package com.example.Service;

import java.util.List;

import com.example.Model.Libro;

public interface LibroService extends DataBaseService<Libro> {
    List<Libro> findByIsbn(String isbn);

    List<Libro> findByAutor(String nombreAutor);

    List<Libro> findByTitulo(String titulo);
}
