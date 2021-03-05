package com.AuthorsBooks.Service;

import java.util.List;

import com.AuthorsBooks.Model.BooksModel;

public interface BooksInterface {
	public void saveB(BooksModel BoookFormulario);

	void addB(BooksModel Book);

	public void insertOrUpdateB(BooksModel Book);

	public List<BooksModel> listAllB();

//	public Optional<AuthorModel> findByIdA(Integer authorID);

	public void deleteBook(Integer BookID);
	
}
