package com.questk2.main;

public class Book {
	private int id;
	private String title;
	private String category;

	public Book(int id, String title, String category) {
		this.id = id;
		this.title = title;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public String getCategory() {
		return category;
	}

	public String toString() {
		return "Book ID: " + id + ", Title: " + title + ", Category: " + category;
	}
}