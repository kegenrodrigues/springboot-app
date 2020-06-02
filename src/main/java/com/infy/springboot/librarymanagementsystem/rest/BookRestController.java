package com.infy.springboot.librarymanagementsystem.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.infy.springboot.librarymanagementsystem.dao.BookDAO;
import com.infy.springboot.librarymanagementsystem.entity.Book;
import com.infy.springboot.librarymanagementsystem.service.BookService;

@RestController
@RequestMapping("/api")
public class BookRestController {

	private BookService bookService;
	
	@Autowired
	private BookRestController(BookService theBookService){
		bookService = theBookService;
	}
	
	@GetMapping("/books")
	public List<Book> findAll(){
		return bookService.findAll();
	}
	
	@GetMapping("/books/{bookId}")
	public Book getBook(@PathVariable String bookId){
		Book theBook = bookService.findById(bookId);
		return theBook;
	} 
	
	@PostMapping("/books")
	public void save(@RequestBody Book theBook) {
		bookService.save(theBook);
	}
}
