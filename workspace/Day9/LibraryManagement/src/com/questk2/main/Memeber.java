package com.questk2.main;

public class Memeber<Book> implements LibraryInterface
{
	public void searchbook(String category)
	{
		System.out.println("Member is searching books in category: " + category);
	}
	
	public void borrowbook(int bookId,int memberId)
	{
		System.out.println("Member" + memberId + "borrowed  book with Id: " +bookId);
	}
	
	public void  returnbook(int bookId, int memberId)
	{
		System.out.println("Member" + memberId + "returned book with Id : " +bookId);
	}
	
	public void addbook(Book book)
	{
		System.out.println("members cannot add books to the catalog.");
	}
	
	public void updateBook(int bookId, Book updateBook)
	{
		System.out.println("members cannot update books in the catalog.");
	}
	
	public void deleteBook(int bookId)
	{
		System.out.println("Members cannot delete books from the catalog.");
	}
}
