package AuthorsBooks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AuthorsBooks.model.Author;
import AuthorsBooks.repository.AuthorRepository;

@Service("authorService")
public class AuthorService {

	@Autowired
	private AuthorRepository repository;

	public void addAuthor(Author author) {
		repository.insert(author);
	}

	public List<Author> listAllAuthor(String searchBy, String val) {
		return repository.getAuthors(searchBy, val);
	}
}