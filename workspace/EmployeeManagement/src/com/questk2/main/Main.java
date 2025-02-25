package com.questk2.main;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main { //main method
	public static void main(String[] args) {
		try {
			// Creating departments
			Department dept1 = new Department(1, "EEE");
			Department dept2 = new Department(2, "EEE");

			// Formatting dates
			SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
			Date joinDate1 = sdf.parse("01-10-2021");
			Date joinDate2 = sdf.parse("10-10-2021");
		

			// Creating employee objects
			Employee emp1 = new Employee(1, "Pallavi", dept1,60000, joinDate1);
			Employee emp2 = new Employee(2, "Mahija", dept1,50000, joinDate2);
			
			// Creating operations instance
			Operations operations = new Operations();

			// Adding employees
			operations.addEmployee(emp1);
			operations.addEmployee(emp2);

			// Updating an employee's details
			System.out.println("\nUpdated Employee:");
			operations.updateEmployee(1, "EEE", "Pallavi", 80000, sdf.parse("01-10-2021"));

			// Retrieving employees from CSE department
			System.out.println("\nGet Data:");
			operations.getEmployee("EEE");

			// Deleting an employee
			System.out.println("\nDelete Employee:");
			operations.deleteEmployee(1, "EE E");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
