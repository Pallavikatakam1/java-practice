package com.questk2.main;

import java.text.SimpleDateFormat;
import java.util.*;

public class TestMain {

	/*
	 * Declaring a Scanner object to take user input and a placeholder array for
	 * books
	 */
	private static final Scanner scanner = null;
	private static final Book[] book = null;

	// Main method that throws InvalidPriceException

	public static void main(String[] args) throws InvalidPriceException {
		// Initializing the scanner to take input from the user
		Scanner scanner = new Scanner(System.in);
		List books = new ArrayList(); // List to store books (of type Book or LatestBook)

		// Ask the user to input the number of books they want to enter
		System.out.println("Enter number of books");
		Integer number = scanner.nextInt(); // Number of books to be entered

		/*
		 * Categorizing the books as either regular books (1) or latest books (2). For
		 * each book, the user must enter the necessary information such as type, book
		 * id, title, author, price, and category.
		 */
		for (Integer book = 0; book < number; book++) {
			// Ask user for the type of book (1 for regular, 2 for latest book)
			System.out.println("Enter the type you want 1 for Book and 2 for LatestBook");
			Integer type = scanner.nextInt();
			scanner.nextLine(); // Consume newline left over by nextInt()

			// Ask user for bookId (an integer identifier for the book)
			System.out.println("Enter the bookId");
			Integer bookId = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			// Ask user for the book title (a string)
			System.out.println("Enter book title");
			String bookTitle = "";
			scanner.nextLine(); // Consume newline

			// Ask user for the book author (a string)
			System.out.println("Enter book author");
			String bookAuthor = "";
			scanner.nextLine(); // Consume newline

			// Ask user for the book price (an integer)
			System.out.println("Enter book price");
			Integer bookPrice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			// Ask user for the book category (a string)
			System.out.println("Enter book category");
			String bookCategory = "";
			scanner.nextLine(); // Consume newline

			/*
			 * Check if the entered price is less than 100. If the price is below 100, an
			 * exception (InvalidPriceException) will be thrown.
			 */
			try {
				if (bookPrice < 100) {
					throw new InvalidPriceException("Price cannot be below 100.");
				}
			} catch (InvalidPriceException e) {
				System.out.println(e.getMessage()); // Display the exception message
				bookId--; // Decrement bookId to retry for the same book (retry mechanism)
				continue; // Skip to the next iteration to re-enter details
			}

			/*
			 * Create either a regular Book or a LatestBook object based on the user's input
			 * (type 1 or 2)
			 */
			Book book1 = null;
			if (type == 2) {

				/*
				 * If it's a LatestBook Ask user for the publish date (formatted as yyyy-MM-dd)
				 */
				System.out.println("Enter the publish date (yyyy-MM-dd):");
				String publishDateStr = scanner.nextLine();
				try {
					// Try to parse the provided date string
					Date publishDate = new SimpleDateFormat("yyyy-MM-dd").parse(publishDateStr);
					// If the date is valid, create a LatestBook object
					book1 = new LatestBook(bookId, bookTitle, bookAuthor, bookPrice, bookCategory, publishDate);
				} catch (Exception e) {
					// If parsing the date fails, show an error and retry the input
					System.out.println("Invalid date format.");
					bookId--; // Decrement bookId to retry for the same book
					continue;
				}
			} else { // If it's a regular Book
				book1 = new Book(bookId, bookTitle, bookAuthor, bookPrice, bookCategory);
			}

			// Add the created book object to the list of books
			books.add(book1);
		}

		// Sort the list of books by price in ascending order
		books.sort(Comparator.comparingLong(Book::bookPrice));

		// Display the sorted list of books by price
		System.out.println("\nBooks sorted by price:");
		for (Book book : book) {
			System.out.println(book); // Print each book's details
		}

		// Optionally, group books by their category for easier search
		Map<String, List<Book>> categoryMap = new HashMap<>();

		// Add books to a map where key is the category and value is the list of books
		// in that category

		for (Book book : book) {
			categoryMap.computeIfAbsent(book.bookCategory(), k -> new ArrayList<>()).add(book);
		}

		// Allow the user to search for books by category
		System.out.println("\nEnter category to search for books:");
		String searchCategory = scanner.nextLine();

		// Fetch books by the given category

		List<Book> searchedBooks = categoryMap.get(searchCategory);
		if (searchedBooks != null && !searchedBooks.isEmpty()) {
			// If there are books in the given category, print them
			System.out.println("\nBooks in category " + searchCategory + ":");
			for (Book book : searchedBooks) {
				System.out.println(book); // Print the details of each book in the category
			}
		} else {
			// If no books are found in the category, display a message
			System.out.println("No books found in this category.");
		}

	}

}
