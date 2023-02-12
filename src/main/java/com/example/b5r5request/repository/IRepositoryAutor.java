package com.example.b5r5request.repository;

import java.sql.Date;
import java.util.List;

import com.example.b5r5request.model.Autor;

public interface IRepositoryAutor {
    
    void insert(Autor autor);
    List<Autor> findAll();
    List<Autor> findByNombre(String nombre);
    List<Autor> findByFnac(Date fnac);
}
