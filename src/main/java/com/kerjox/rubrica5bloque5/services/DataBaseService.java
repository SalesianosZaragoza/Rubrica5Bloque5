package com.kerjox.rubrica5bloque5.services;

import java.util.List;

public interface DataBaseService<T> {

	List<T> findAll();
	void insert(T t);
	void delete(Integer id);
}
