package com.questk2.main;

import java.util.*;

/**
 * This class handles employee operations.
 */
public class Operations {
	Map<String, List<Employee>> departments = new HashMap<>();

	public void addEmployee(Employee employee) throws InvalidDataException { // adding an employee to the department
		List<Employee> employeeList = departments.get(employee.getDepartment().getDeptName());
		if (employeeList == null) {
			employeeList = new ArrayList<>(); // creating a new arraylist of the employees
		}

		/*
		 * adding new employees data to the list if the employee present in the list the
		 * exception was thrown like employee already exit
		 */

		if (!employeeList.contains(employee)) {
			employeeList.add(employee);
			Collections.sort(employeeList, Comparator.comparing(Employee::getEmpName));
			departments.put(employee.getDepartment().getDeptName(), employeeList);
			printEmployeeList(employee.getDepartment().getDeptName());
		} else {
			throw new InvalidDataException("Employee already exists");
		}
	}

	public void deleteEmployee(int empId, String deptName) throws InvalidDataException { // to delete the employee from
																							// the list
		List<Employee> employeeList = departments.get(deptName); // asking for the employee Id
		if (employeeList != null) {
			Employee empToDelete = null;
			for (Employee emp : employeeList) {
				if (emp.getEmpId() == empId) {
					empToDelete = emp;
					break;
				}
			}
			// the employee id is found the employee was deleted from the list
			if (empToDelete != null) {
				employeeList.remove(empToDelete);
				Collections.sort(employeeList, Comparator.comparing(Employee::getEmpName));
				printEmployeeList(deptName);
			} else { // if the id entered is not there in the list an invalid exception was thrown
				throw new InvalidDataException("Employee not found");
			}
		} else {
			throw new InvalidDataException("Department not found");
		}
	}

	// to join the new employee to the list asks for the employee name, id, salary,
	// joining date, and dept name
	public void updateEmployee(int empId, String deptName, String name, int salary, Date joinDate)
			throws InvalidDataException { // throws exception if the entered dept of id is not found
		List<Employee> employeeList = departments.get(deptName);
		if (employeeList != null) {
			boolean found = false;
			for (Employee emp : employeeList) { // if the entered data was correct the data will update
				if (emp.getEmpId() == empId) {
					emp.updateEmployee(name, salary, joinDate);
					found = true;
					break;
				}
			}
			if (found) {
				Collections.sort(employeeList, Comparator.comparing(Employee::getEmpName));
				printEmployeeList(deptName);
			} else {
				throw new InvalidDataException("Employee not found"); // otherwise throws an exception if employee not
																		// found or dept not found
			}
		} else {
			throw new InvalidDataException("Department not found");
		}
	}

	public void getEmployee(String deptName) throws InvalidDataException { // prints all employees in dept in descending
																			// order
		List<Employee> employeeList = departments.get(deptName);
		if (employeeList != null) {
			employeeList.sort(Comparator.comparing(Employee::getEmpJoinDate).reversed());
			printEmployeeList(deptName); // throws exception if dept not found
		} else {
			throw new InvalidDataException("Department not found");
		}
	}

	private void printEmployeeList(String deptName) { // Prints the list of employees in a specific department.
		List<Employee> employeeList = departments.get(deptName);
		if (employeeList != null) {
			System.out.println("Employees in department: " + deptName);
			for (Employee emp : employeeList) {
				System.out.println(emp);
			}
		}
	}
}
