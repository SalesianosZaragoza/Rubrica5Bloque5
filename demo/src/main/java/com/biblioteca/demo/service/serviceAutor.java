package com.biblioteca.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.biblioteca.demo.model.autor;
@Service
public class serviceAutor {
    static List<autor> list = new ArrayList<>();
    static{
        list.add(new autor(1, "Juan", "Perez", "12/12/12"));
        list.add(new autor(2, "Pedro", "Gomez", "12/12/12"));
        list.add(new autor(3, "Maria", "Gonzalez", "12/12/12"));
    }

    public List<autor> getAllAutores() {
        return list;
    }

    public void crearAutor(autor autor) {
        list.add(autor);
    }

    public List<autor> buscarAutor(String fechaNac, String nombre) {
        List<autor> AutoresBuscados = new ArrayList<>();
        for (autor autor : list) {
            if (autor.getFechaNacimiento().equals(fechaNac)) {
                AutoresBuscados.add(autor);
            }
        }
        for (autor autor : list) {
            if (autor.getNombre().equals(nombre)) {
                AutoresBuscados.add(autor);
            }
        }
        return AutoresBuscados;
    }
}
