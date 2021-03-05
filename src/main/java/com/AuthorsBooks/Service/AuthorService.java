package com.AuthorsBooks.Service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.AuthorsBooks.Model.AuthorModel;

import com.AuthorsBooks.Repository.AuthorRepository;

@Service("AuthorService")
@Profile("Autor")
public class AuthorService implements AuthorInterface {

	@Autowired
	private AuthorRepository repositoryA;

	private static final Logger LOGGER = LogManager.getLogger(AuthorService.class);

	// Author
	public void saveA(AuthorModel AuthorFormulario) {
		AuthorModel AuthorInDatabase = repositoryA.searchA(AuthorFormulario);
		if (null == AuthorInDatabase) {
			repositoryA.insertA(AuthorFormulario);
		} else {
			repositoryA.updateA(AuthorFormulario);
		}

	}

	public void addA(AuthorModel author) {
		repositoryA.insertA(author);
	}

	public void deleteAuthor(Integer AuthorID) {
		repositoryA.deleteA(AuthorID);
	}

	public AuthorModel search(Integer AuthorID) {
		return repositoryA.searchByAuthorID(AuthorID);

	}

	public AuthorRepository getRepository() {
		return repositoryA;
	}

	public void setRepository(AuthorRepository repository) {
		this.repositoryA = repository;
	}

	@Override
	public void insertOrUpdateA(AuthorModel author) {
		repositoryA.updateA(author);
	}

	@Override
	public List<AuthorModel> listAllA() {
		LOGGER.info("ESTAS EN EL ListAuthor");
		return repositoryA.searchAllA();
	}

}