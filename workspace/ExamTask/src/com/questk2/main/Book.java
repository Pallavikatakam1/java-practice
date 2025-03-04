package com.questk2.main;

import java.util.*;

/*
 *  we are creating a class of book . 
 * attributes are declared
 */

public class Book {
	private int bookId;
	private String bookTitle;
	private String bookAuthor;
	private int bookPrice;
	private String bookCategory;

	/*
	 * creating a constructor for the class and assigning the attribute values
	 */

	public Book(int bookId, String bookTitle, String bookAuthor, int bookPrice, String bookCategory){ 
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
		this.bookCategory = bookCategory;
	}

	/*
	 * inserting the getter and setter methods for the attributes
	 */

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String bookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public int bookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String bookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	/*
	 * @Overriding of the method
	 */
	public String toString() {
		return "bookId" + bookId + "bookTitle" + bookTitle + "bookAuthor" + bookAuthor + "bookPrice" + bookPrice
				+ "bookCategory" + bookCategory;

	}

}
