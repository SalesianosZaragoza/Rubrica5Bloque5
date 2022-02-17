package com.kerjox.rubrica5bloque5.repos;

import java.util.List;

public interface RepoService<T> {

	void insert(T t);
	void delete(int id);
	List<T> findAll();
}
