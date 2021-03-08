package rubrica5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import rubrica5.model.Book;
import rubrica5.service.AuthorService;
import rubrica5.service.BookService;

@Controller
public class BookController {
	
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
	
	
	@GetMapping("/insertBook")
	public ModelAndView insertBook() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("insertBook");
		modelAndView.addObject("book", new Book());
		modelAndView.addObject("listAuthors", authorService.searchAll());
		return modelAndView;
	}
	
	@PostMapping("/insertBook")
	public ModelAndView insertBook(@ModelAttribute("book")Book book) {
		bookService.insert(book);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", bookService.searchAll());
		modelAndView.addObject("book", new Book());
		modelAndView.setViewName("listBooks");
		return modelAndView;
	}
	
	@PostMapping("/searchBook")
	public ModelAndView searchBook(@ModelAttribute("book")Book book) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", bookService.search(book));
		modelAndView.addObject("book", new Book());
		modelAndView.setViewName("listBooks");
		return modelAndView;
	}
}