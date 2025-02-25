package com.questk2.main;

interface LibraryInterface{
	void booksearch(String category);
    void borrowbook(int bookId, int memberId);
    void returnbook(int bookId, int memberId);
    void addbook(Book book);
    void updateBook(int bookId, Book updatedBook);
    void deleteBook(int bookId);
}


