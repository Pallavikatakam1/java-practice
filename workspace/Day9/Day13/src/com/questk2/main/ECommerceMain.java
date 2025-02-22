package com.questk2.main;

import java.util.*;

public class ECommerceMain {
	public static void main(String[] args) {
		List<ECommerce> list = new LinkedList<>();
		list.add(new ECommerce("Q_1", "Pallavi", true));
		list.add(new ECommerce("Q_2", "Mahija", false));
		list.add(new ECommerce("Q_3", "Indhu", true));

		Iterator<ECommerce> iterator = list.iterator();
		while (iterator.hasNext()) {
			ECommerce order = iterator.next();
			if (!order.getProcessed()) {
				order.orderProcessed();
				iterator.remove();
			}
		}
		System.out.println("Processed Orders : ");
		for (ECommerce order : list) {
			System.out.println(order);
		}
	}

}
