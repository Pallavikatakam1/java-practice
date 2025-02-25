package com.questk2.main;

import java.util.*;

public class Employee { // creating a new class employee
	private int empId; // giving employee id
	private String empName; // emp name
	private Department department; // emp dept
	private int salary; // emp salary
	private Date empJoinDate; // emp join date

	public Employee(int empId, String empName, Department department, int salary, Date empJoinDate) { // giving the
																										// information
																										// for the
																										// employee
		this.empId = empId; // giving emp ID
		this.empName = empName; // emp name
		this.department = department; // emp dept
		this.salary = salary; // emp salary
		this.empJoinDate = empJoinDate; // emp joindate
	}

	public int getEmpId() { // gets the employee id
		return empId; // returns to emp id
	}

	public String getEmpName() { // gets the emp name and return it
		return empName;
	}

	public Department getDepartment() { // gets the dept name and return to dept name
		return department;
	}

	public int getSalary() { // gets the employee salary and return it to emp salary
		return salary;
	}

	public Date getEmpJoinDate() { // gets the emp joindate and return it to emp join date
		return empJoinDate;
	}

	/*
	 * If new employee joins the details of the new employee was updated The details
	 * updated are name , salary, joindate
	 */

	public void updateEmployee(String name, int salary, Date joinDate) {
		this.empName = name;
		this.salary = salary;
		this.empJoinDate = joinDate;
	}

	/* Checks if two employees are equal based on their employee ID. */

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Employee employee = (Employee) obj;
		return empId == employee.empId;
	}

	/* Generates a hash code for the employee based on their ID. */

	public int hashCode() {
		return Objects.hash(empId);
	}

	/* Returns a string representation of the employee details. */

	public String toString() {
		return "EmpId: " + empId + ", Name: " + empName + ", Salary: " + salary + ", Joining Date: " + empJoinDate;
	}
}
