package es.salesianos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.Author;
import es.salesianos.repository.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired 
	private AuthorRepository repository;
	
	public void insert(Author author) {
		repository.insert(author);
	}
	
	public List<Author> searchAll() {
		return repository.searchAll();
	}
	
	public List<Author> searchByName(Author author) {
		return repository.searchByName(author.getName());
	}
	
	public List<Author> searchByDayOfBirth(Author author) {
		return repository.searchByDayOfBirth(author.getDayOfBirth());
	}
}