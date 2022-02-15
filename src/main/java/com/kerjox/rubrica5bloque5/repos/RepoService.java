package com.kerjox.rubrica5bloque5.repos;

import java.util.List;

public interface RepoService<T> {

	void insert(T t);
	void delete(T t);
	List<T> findAll();
}
