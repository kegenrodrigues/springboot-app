package com.infy.springboot.librarymanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import com.infy.springboot.librarymanagementsystem.entity.Book;

@Repository
public class BookDAOImpl implements BookDAO {

	private EntityManager entityManager;
	
	@Autowired
	public BookDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Book> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		//To fetch books where issuable is true
		//Query<Book> theQuery = currentSession.createQuery("from Book b where issuable = true",Book.class);
		
		Query<Book> theQuery = currentSession.createQuery("from Book",Book.class);
		List<Book> books = theQuery.getResultList();
		return books;
	}


	@Override
	public Book findById(String bookId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		Book theBook = currentSession.get(Book.class, bookId);
		return theBook;
	}


	@Override
	public void save(Book book) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(book);
		
		
	}


//	@Override
//	public void deleteById(String bookId) {
//		
//		Session currentSession = entityManager.unwrap(Session.class);
//		
//		Book theBook = currentSession.get(Book.class, bookId);
//		currentSession.delete(theBook);
//	}

	
	
}
