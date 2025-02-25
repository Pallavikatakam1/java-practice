package com.questk2.main;

public class Department {
	private int deptId; // Giving the data about the department and the organization
	private String deptName;

	public Department(int deptId, String deptName) { // creating a department object
		this.deptId = deptId; // Identifying the department
		this.deptName = deptName; // Naming the department
	}

	public int getDeptId() { // Retrieve the department
		return deptId; // returns to identifying the department
	}

	public String getDeptName() { // retrieve the dept name
		return deptName; // returns to name of dept
	}
}
