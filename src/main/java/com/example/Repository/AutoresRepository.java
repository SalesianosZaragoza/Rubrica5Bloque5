package com.example.Repository;

import java.sql.Date;
import java.util.List;

import com.example.Model.Autor;

public interface AutoresRepository extends RepositoryService<Autor> {
    List<Autor> findAll();

    List<Autor> findByNombre(String nombreAutor);

    List<Autor> findByDate(Date fNac);
}
