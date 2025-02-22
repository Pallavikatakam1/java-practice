package com.questk2.main;

public class InventoryTracker {
	private String name;
	private int stock;

	public InventoryTracker(String name, int stock) {
		this.name = name;
		this.stock = stock;
	}

	public String toString() {
		return " Name : " + name + " Stock count : " + stock;
	}

	public String getName() {
		return name;
	}

	public int getStock() {
		return stock;
	}

}
