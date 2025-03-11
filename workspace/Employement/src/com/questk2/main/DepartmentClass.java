package com.questk2.main;

public class DepartmentClass {
	private int deptId;
	private String deptName;

	public DepartmentClass(int deptId, String deptName) {
		this.deptId = deptId;
		this.deptName = deptName;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String toString() {
		return "Department{" + "deptId = " + deptId + ",deptName = '" + deptName + '\'' + '}';
	}

}
