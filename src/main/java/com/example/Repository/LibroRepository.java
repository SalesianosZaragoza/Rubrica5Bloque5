package com.example.Repository;

import java.util.List;

import com.example.Model.Libro;

public interface LibroRepository extends RepositoryService<Libro> {
    List<Libro> getLibrosAutor(String nombreAutor);

    List<Libro> getLibroByIsbn(String isbn);

    List<Libro> getLibroByTitulo(String titulo);
}
