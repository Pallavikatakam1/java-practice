package com.questk2.main;

import java.util.*;

public class EmployeeClass<Department> implements Comparable<EmployeeClass> {
	private int empId;
	private String empName;
	private Department department;
	private double salary;
	private Date empJoinDate;

	public EmployeeClass(int empId, String empName, Department department, double salary, Date empJoinDate) {
		this.empId = empId;
		this.empName = empName;
		this.department = department;
		this.salary = salary;
		this.empJoinDate = empJoinDate;
	}

	public int getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public Department getDepartment() {
		return department;
	}

	public double getSalary() {
		return salary;
	}

	public Date getEmpJoinDate() {
		return empJoinDate;
	}

	@Override
	public int compareTo(EmployeeClass o) {
		return this.empName.compareTo(o.empName);
	}

	@Override
	public String toString() {
		return "Employee{" + "empId=" + empId + ", empName='" + empName + '\'' + ", department=" + department
				+ ", salary=" + salary + ", empJoinDate=" + empJoinDate + '}';
	}
}
