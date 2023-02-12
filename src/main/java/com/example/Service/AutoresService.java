package com.example.Service;

import java.sql.Date;
import java.util.List;

import com.example.Model.Autor;

public interface AutoresService extends DataBaseService<Autor> {

    List<Autor> findByNombre(String nombre);

    List<Autor> findByDate(Date fNac);
}