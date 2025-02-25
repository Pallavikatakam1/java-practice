package com.questk2.main;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String type = scanner.next();
		Library librarymanagement = new Library();
		librarymanagement.presentbooks();
		librarymanagement.addBook(new Book(3, "History Book 1", Categories.history));
		if (type.contentEquals("member")) {
			Member member = new Member();
			member.borrowbook(1, 101);
		} else if (type.contentEquals("librarian")) {
			Librarian librarian = new Librarian();
			librarian.booksearch(Categories.fiction);
			librarian.updateBook(2, new Book(2, "Book-2", Categories.nonfiction));
			librarian.deleteBook(2);
		}

		TrackingSystem trackingSystem = new TrackingSystem();
		trackingSystem.trackBorrowedBooks(1, 101);

		LateFee latefee = new LateFee();
		latefee.makePayment(1, 101, 3);

		librarymanagement.showCatalog();
		scanner.close();
	}

}