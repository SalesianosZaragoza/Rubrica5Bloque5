package com.AuthorsBooks.Service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.AuthorsBooks.Model.BooksModel;
import com.AuthorsBooks.Repository.BookRepository;

@Service("BookService")
@Profile("Libro")
public class BookService implements BooksInterface{
	
	@Autowired
	private BookRepository repositoryB;
	
	private static final Logger LOGGER = LogManager.getLogger(BookService.class);

	public void saveB(BooksModel BoookFormulario) {
		BooksModel BookInDatabase = repositoryB.searchB(BoookFormulario);
		if (null == BookInDatabase) {
			repositoryB.insertB(BoookFormulario);
		} else {
			repositoryB.updateB(BoookFormulario);
		}
	}

	@Override
	public void addB(BooksModel Book) {
		repositoryB.insertB(Book);
		
	}
	public BookRepository getRepository() {
		return repositoryB;
	}

	public void setRepository(BookRepository repository) {
		this.repositoryB = repository;
	}
	@Override
	public void insertOrUpdateB(BooksModel Book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BooksModel> listAllB() {
		LOGGER.info("ESTAS EN EL ListBooks");
		return repositoryB.searchAllB();
	}

	@Override
	public void deleteBook(Integer BookID) {
		repositoryB.deleteB(BookID);
		
	}

}
