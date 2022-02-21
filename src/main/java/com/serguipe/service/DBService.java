package com.serguipe.service;

import java.util.List;

public interface DBService<T> {

	List<T> findAll();
	void insert(T t);
	void delete (Integer id);
}
