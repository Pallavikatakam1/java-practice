package com.questk2.main;

import java.util.*;

public class EmployeManagement<Employee> {
	private Map<String, List<Employee>> departmentEmployees = new HashMap<>();

	public void addEmployee(Employee employee) throws CustomException {
		departmentEmployees.putIfAbsent(employee.getDepartment().getDeptName(), new ArrayList<>());
		List<Employee> employees = departmentEmployees.get(employee.getDepartment().getDeptName());

		if (employees.contains(employee)) {
			throw new CustomException("Employee already exists.");
		}

		employees.add(employee);
		Collections.sort(employees);

		System.out.println("Employee added successfully. Employees in " + employee.getDepartment().getDeptName() + ":");
		printEmployees(employee.getDepartment().getDeptName());
	}

	public void deleteEmployee(Employee employee) throws CustomException {
		List<Employee> employees = departmentEmployees.get(employee.getDepartment().getDeptName());

		if (!employees.remove(employee)) {
			throw new CustomException("Employee not found.");
		}

		System.out
				.println("Employee deleted successfully. Employees in " + employee.getDepartment().getDeptName() + ":");
		printEmployees(employee.getDepartment().getDeptName());
	}

	public void updateEmployee(Employee oldEmployee, Employee newEmployee) throws CustomException {
		List<Employee> employees = departmentEmployees.get(oldEmployee.getDepartment().getDeptName());

		int index = employees.indexOf(oldEmployee);
		if (index == -1) {
			throw new CustomException("Employee not found.");
		}

		employees.set(index, newEmployee);
		Collections.sort(employees);

		System.out.println(
				"Employee updated successfully. Employees in " + oldEmployee.getDepartment().getDeptName() + ":");
		printEmployees(oldEmployee.getDepartment().getDeptName());
	}

	public void getEmployees(String deptName) {
		List<Employee> employees = departmentEmployees.get(deptName);
		if (employees != null) {
			employees.sort((e1, e2) -> e2.getEmpJoinDate().compareTo(e1.getEmpJoinDate()));
			System.out.println("Employees in " + deptName + " sorted by joining date:");
			printEmployees(deptName);
		} else {
			System.out.println("No employees found in " + deptName);
		}
	}

	public void printEmployees(String deptName) {
		List<Employee> employees = departmentEmployees.get(deptName);
		if (employees != null) {
			employees.forEach(System.out::println);
		} else {
			System.out.println("No employees found in " + deptName);
		}
	}

	public void raiseConcurrentModificationException() {
		List<Employee> employees = new ArrayList<>();
		try {
			for (Employee employee : employees) {
				employees.remove(employee);
			}
		} catch (ConcurrentModificationException e) {
			System.out.println("Caught ConcurrentModificationException: " + e.getMessage());
		}
	}
}
