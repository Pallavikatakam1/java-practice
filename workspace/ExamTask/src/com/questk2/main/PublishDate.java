package com.questk2.main;

import java.util.Date;

/*
 *  creating a subclass for latest book 
 */

class LatestBook extends Book {
	private Date PublishDate;

	/*
	 * Including date to the book attributes including the extra details to the
	 * Latest book
	 * using the super class to initialize the attributes from the parent class book to subclass LatestBook
	 */
	public LatestBook(Integer bookId, String bookTitle, String bookAuthor, Integer bookPrice, String bookCategory,
			Date publishDate) {
		super(bookId, bookTitle, bookAuthor, bookPrice, bookCategory);
		this.PublishDate = publishDate;
	}

	/*
	 * establishing the getter and setter method to establish the date
	 */

	public Date getPublishDate() {
		return PublishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.PublishDate = publishDate;
	}

	/*
	 * @Overriding the method
	 */
	public String toString() {
		return super.toString() + ", Publish Date: " + PublishDate;
	}
}