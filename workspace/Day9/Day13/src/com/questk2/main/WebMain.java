package com.questk2.main;
import java.util.*;

public class WebMain {
	public static void main(String[] args) {
		System.out.println("User Sessions: ");

		Map<String, WebApplication> map = new HashMap<String, WebApplication>();
		map.put("1", new WebApplication("Pallavi", "EEE", "111"));
		map.put("2", new WebApplication("Jyoshna", "CSE", "222"));
		map.put("3", new WebApplication("Lahari", "IT", "333"));
		map.put("4", new WebApplication("Vaishnavi", "ECE", "444"));

		Iterator<Map.Entry<String, WebApplication>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, WebApplication> entry = iterator.next();

			if (entry.getKey().equals("2")) {
				iterator.remove();
			}
			if (entry.getKey().equals("3")) {
				map.put("3", new WebApplication("Mahija", "EEE", " 555"));
			}

		}
		for (Map.Entry<String, WebApplication> entry : map.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}

	}

}
