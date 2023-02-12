package com.example.b5r5request.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.b5r5request.model.Autor;
import com.example.b5r5request.repository.IRepositoryAutor;

@Service
public class ServiceAutor implements IServiceAutor {

    @Autowired
    public IRepositoryAutor repositoryAutor;

    @Override
    public void insert(Autor autor) {
        repositoryAutor.insert(autor);
    }

    @Override
    public List<Autor> findAll() {
        return repositoryAutor.findAll();
    }

    @Override
    public List<Autor> findByFnac(Date fnac) {
        return repositoryAutor.findByFnac(fnac);
    }

    @Override
    public List<Autor> findByNombre(String nombre) {
        return repositoryAutor.findByNombre(nombre);
    }
    
}
