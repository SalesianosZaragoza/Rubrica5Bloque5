package AuthorsBooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import AuthorsBooks.model.Book;
import AuthorsBooks.service.BookService;

@Controller
public class AddBook {

	@Autowired
	private BookService bookservice;

	@PostMapping(path = "addBook")
	public String saveAuthor(@ModelAttribute(name = "Book") Book book) {
		bookservice.addBook(book);
		System.out.println(book.toString());
		return "bookSaved";
	}
}
