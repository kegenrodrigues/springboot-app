package com.infy.springboot.librarymanagementsystem.dao;

import java.util.List;

import com.infy.springboot.librarymanagementsystem.entity.Book;

public interface BookDAO {
	
	public List<Book> findAll();
	public Book findById(String bookId);
	public void save(Book book);
	//public void deleteById(String bookId);
}
