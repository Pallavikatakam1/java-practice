package com.questk2.model;

public class Employee {
	private int id;
	private String name;
	private int salary;
	private String shift;

	public Employee() {
	}

	public Employee(int id, String name, int salary, String shift) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.shift = shift;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	@Override
	public String toString() {
		return "Student{" + "id=" + id + ", name='" + name + '\'' + ", age=" + salary + ", email='" + shift + '\''
				+ '}';
	}
}
