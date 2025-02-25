package com.questk2.main;

public class Librarian implements LibraryInterface {

	public void booksearch(String category) {
		System.out.println("Librarian is searching books in category: " + category);
	}

	public void borrowbook(int bookId, int memberId) {
		System.out.println("Librarian allows Member " + memberId + " to borrow book with ID: " + bookId);
	}

	public void returnbook(int bookId, int memberId) {
		System.out.println("Librarian allows Member " + memberId + " to return book with ID: " + bookId);
	}

	public void addbook(Book book) {
		System.out.println("Librarian is adding new book: " + book);
	}

	public void updateBook(int bookId, Book updatedBook) {
		System.out.println("Librarian is updating book ID " + bookId + " with details: " + updatedBook);
	}

	public void deleteBook(int bookId) {
		System.out.println("Librarian is deleting book with ID: " + bookId);
	}
}
