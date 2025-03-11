package com.questk2.main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
	public static <EmployeeManager, Employee> void main(String[] args) {
		try {
			// Create departments
			DepartmentClass dept1 = new DepartmentClass(1, "HR");
			DepartmentClass dept2 = new DepartmentClass(2, "IT");

			// Create employees
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Employee emp1 = new Employee(1, "John Doe", dept1, 50000, sdf.parse("2020-01-15"));
			Employee emp2 = new Employee(2, "Jane Smith", dept1, 60000, sdf.parse("2019-03-10"));
			Employee emp3 = new Employee(3, "Alice Johnson", dept2, 70000, sdf.parse("2021-06-05"));
			Employee emp4 = new Employee(4, "Bob Brown", dept2, 80000, sdf.parse("2022-09-20"));

			// Create employee manager
			EmployeeManager manager = new EmployeeManager();

			// Add employees
			manager.addEmployee(emp1);
			manager.addEmployee(emp2);
			manager.addEmployee(emp3);
			manager.addEmployee(emp4);

			// Update an employee
			Employee updatedEmp2 = new Employee(2, "Jane Doe", dept1, 65000, sdf.parse("2019-03-10"));
			manager.updateEmployee(emp2, updatedEmp2);

			// Delete an employee
			manager.deleteEmployee(emp1);

			// Retrieve employees from a specific department by join date in reverse order
			manager.getEmployees("HR");

			// Trigger ConcurrentModificationException
			manager.raiseConcurrentModificationException();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
