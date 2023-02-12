package com.example.Repository;

import java.util.List;

public interface RepositoryService<T> {

    void insert(T t);

    void delete(int id);

    List<T> findAll();
}
