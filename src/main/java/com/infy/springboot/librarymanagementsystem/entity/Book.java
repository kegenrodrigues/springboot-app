package com.infy.springboot.librarymanagementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.Type;

@Entity
@Table(name = "book_details")
public class Book {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "book_Id", unique = true,length = 36)
	private String bookId;	
	
	@Pattern(regexp="^[a-zA-Z]*$")  
	@Column(name = "book_title")
	private String title;
	
	@Pattern(regexp="^[a-zA-Z]*$") 
	@Column(name = "category")
	private String category;
	
	@Pattern(regexp="^[a-zA-Z]*$") 
	@Column(name = "author")
	private String author;
	
	@Column(name = "availability")
	private boolean availability;

	@Column(name = "no_of_copies")
	private int noOfCopies;
	
	@Column(name = "issuable")
	private boolean issuable;
	
	public Book() {
		this.bookId = "";
		this.title = "";
		this.category = "";
		this.author = "";
		this.availability = false;
		this.noOfCopies = 0;
		this.issuable = false;
	}

	public Book(String bookId, String title, String category, String author, boolean availability, int noOfCopies,
			boolean issuable) {
		this.bookId = bookId;
		this.title = title;
		this.category = category;
		this.author = author;
		this.availability = availability;
		this.noOfCopies = noOfCopies;
		this.issuable = issuable;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
	public int getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

	public boolean isIssuable() {
		return issuable;
	}

	public void setIssuable(boolean issuable) {
		this.issuable = issuable;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", category=" + category + ", author=" + author
				+ ", availability=" + availability + ", noOfCopies=" + noOfCopies + ", issuable=" + issuable + "]";
	}

	
	
}
