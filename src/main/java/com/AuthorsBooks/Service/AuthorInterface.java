package com.AuthorsBooks.Service;

import java.util.List;


import com.AuthorsBooks.Model.AuthorModel;


public interface AuthorInterface {
	public void saveA(AuthorModel authorFormulario);

	void addA(AuthorModel autor);

	public void insertOrUpdateA(AuthorModel author);

	public List<AuthorModel> listAllA();

//	public Optional<AuthorModel> findByIdA(Integer authorID);

	public void deleteAuthor(Integer AuthorID);
	


}
