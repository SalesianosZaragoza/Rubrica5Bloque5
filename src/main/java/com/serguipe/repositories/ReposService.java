package com.serguipe.repositories;

import java.util.List;

public interface ReposService<T> {


	void insert(T t);
	void delete(int id);
	List<T> findAll();
}
