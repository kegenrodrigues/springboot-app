package com.infy.springboot.librarymanagementsystem.service;

import java.util.List;

import com.infy.springboot.librarymanagementsystem.entity.Book;

public interface BookService {

	public List<Book> findAll();
	public Book findById(String bookId);
	public void save(Book book);
	//public void deleteById(String bookId);
	
}
