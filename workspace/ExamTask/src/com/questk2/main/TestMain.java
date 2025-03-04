package com.questk2.main;

import java.util.*;

public class TestMain {

	/*
	 * Creating a new scanner class for the user input
	 */

	private static final Scanner scanner = null;

	public static void main(String[] args) throws InvalidPriceException {
		Scanner scanner = new Scanner(System.in);
		List books = new ArrayList();

		System.out.println("Enter number of books");
		int number = scanner.nextInt();
	

	/*
	 * Categorizing the books like books are 1 and latestBooks are 2
	 * 
	 * now user have to select the type , book id, title, author, price, category
	 * 
	 * so it asks user to give input of the required field
	 */

	for(int book = 0;book<number;book++)
	{
		System.out.println("Enter the type you want 1 for Book and 2 fro LatestBook");
		int type = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter the bookId");
		int bookId = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter book title");
		String bookTitle;
		scanner.nextLine();

		System.out.println("Enter book author");
		String bookAuthor;
		scanner.nextLine();

		System.out.println("Enter book price");
		int bookPrice = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter book category");
		String bookCategory;
		scanner.nextLine();
		
		/*
		 * if the price is less than 100 it will shows the exception
		 */
		
		if (bookPrice < 100) {
            throw new InvalidPriceException("Price cannot be below 100.");
        }
		

	}

}
}
