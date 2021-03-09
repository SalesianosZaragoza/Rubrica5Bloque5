package AuthorsBooks.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import AuthorsBooks.model.Book;
import AuthorsBooks.service.BookService;

@Controller
public class AddBookServlet {
	
	@Autowired
	private BookService service;
	
	@PostMapping(path = "addBook")
	public String saveAuthor(@ModelAttribute(name = "Book") Book book) {
		service.addBook(book);
		System.out.println(book.toString());
		return "bookSaved";
	}
}