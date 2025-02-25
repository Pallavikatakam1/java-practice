package com.questk2.main;

public class Library {
	public Book[] booksCatalog = new Book[50];
	public int bookCount = 0;

	public void presentbooks() {
		addBook(new Book(1, "Fiction book 1", Categories.fiction));
		addBook(new Book(2, "Science book 1", Categories.science));
	}

	public void addBook(Book book) {
		booksCatalog[bookCount++] = book;
		System.out.println("Book added to catalog: " + book);
	}

	public void updateBook(int bookId, Book updatedBook) {
		for (int i = 0; i < bookCount; i++) {
			if (booksCatalog[i].getId() == bookId) {
				booksCatalog[i] = updatedBook;
				System.out.println("Updated book: " + updatedBook);
				break;
			}
		}
	}

	public void deleteBook(int bookId) {
		for (int i = 0; i < bookCount; i++) {
			if (booksCatalog[i].getId() == bookId) {
				booksCatalog[i] = booksCatalog[bookCount - 1];
				bookCount--;
				System.out.println("Deleted book with ID: " + bookId);
				break;
			}
		}
	}

	public void showCatalog() {
		System.out.println("Library Catalog:");
		for (int i = 0; i < bookCount; i++) {
			System.out.println(booksCatalog[i]);
		}
	}

}
