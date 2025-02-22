package com.questk2.main;

import java.util.*;

public class InventoryMain {
	public static void main(String[] args) {
		Map<Integer, List<InventoryTracker>> stocklevel = new HashMap<>();

		List<InventoryTracker> product1 = new ArrayList<>();
		product1.add(new InventoryTracker("Lenovo", 20));
		product1.add(new InventoryTracker("HP", 10));

		List<InventoryTracker> product2 = new ArrayList<>();
		product2.add(new InventoryTracker("MacBook", 15));
		product2.add(new InventoryTracker("Dell", 5));

		stocklevel.put(001, product1);
		stocklevel.put(002, product2);

		Iterator<Map.Entry<Integer, List<InventoryTracker>>> iterator = stocklevel.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, List<InventoryTracker>> entry = iterator.next();
			List<InventoryTracker> productList = entry.getValue();
			Iterator<InventoryTracker> productIterator = productList.iterator();
			while (productIterator.hasNext()) {
				InventoryTracker product = productIterator.next();
				if (product.getStock() == 0) {
					productIterator.remove();
				}
			}
			if (productList.isEmpty()) {
				iterator.remove();
			}
		}
		printStock(stocklevel);
	}

	public static void printStock(Map<Integer, List<InventoryTracker>> stocklevel) {
		for (Map.Entry<Integer, List<InventoryTracker>> entry : stocklevel.entrySet()) {
			System.out.println("Product ID: " + entry.getKey());
			for (InventoryTracker product : entry.getValue()) {
				System.out.println("  " + product);
			}
		}
	}
}
