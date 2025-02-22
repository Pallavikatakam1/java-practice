package com.questk2.main;

public class WebApplication {
	private String name;
	private String education;
	private String RollNum;

	public WebApplication(String name, String preference, String status) {
		this.setName(name);
		this.setEducation(education);
		this.setRollNum(RollNum);
	}

	public String toString() {
		return "Name : " + name + ",Education : " + education + ",RollNum" + RollNum;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public void setRollNum(String RollNum) {
		this.RollNum = RollNum;
	}

}
