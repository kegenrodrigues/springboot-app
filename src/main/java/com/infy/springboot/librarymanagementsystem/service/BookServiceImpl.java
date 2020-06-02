package com.infy.springboot.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.springboot.librarymanagementsystem.dao.BookDAO;
import com.infy.springboot.librarymanagementsystem.entity.Book;
import com.infy.springboot.librarymanagementsystem.utility.BooleanStringHandler;

@Service
public class BookServiceImpl implements BookService {

	private BookDAO bookDAO;
	
	@Autowired
	public BookServiceImpl(BookDAO theBookDAO) {
		bookDAO = theBookDAO;
	}
	
	@Override
	@Transactional
	public List<Book> findAll() {
		List<Book> books = bookDAO.findAll();
		for(Book book:books) {
			if(book.isIssuable()) {
				System.out.println("BookId: "+book.getBookId());
				System.out.println("Title: "+book.getTitle());
				System.out.println("Category: "+book.getCategory());
				System.out.println("Author: "+book.getAuthor());
				System.out.println("Availability:"+book.isAvailability());
				System.out.println("No of copies"+book.getNoOfCopies());
				System.out.println("Issuable :"+"Yes");
				System.out.println("\n\n\n");
			}
		}
		return books;
	}

	@Override
	@Transactional
	public Book findById(String bookId) {
		Book theBook = bookDAO.findById(bookId);
		if(theBook!=null) {
			System.out.println("BookId: "+theBook.getBookId());
			System.out.println("Title: "+theBook.getTitle());
			System.out.println("Category: "+theBook.getCategory());
			System.out.println("Author: "+theBook.getAuthor());
			System.out.println("Availability:"+theBook.isAvailability());
			System.out.println("No of copies"+theBook.getNoOfCopies());
			System.out.println("Issuable :"+BooleanStringHandler.booleanToString(theBook.isIssuable()));
		}
		else {
			System.out.println("Book with this ID not found");
		}
		return theBook;
	}

	@Override
	@Transactional
	public void save(Book book) {
		bookDAO.save(book);

	}

//	@Override
//	@Transactional
//	public void deleteById(String bookId) {
//		bookDAO.deleteById(bookId);
//
//	}

}
