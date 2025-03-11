package com.questk2.main;

public enum Role {
	Admin(1, true), Manager(2, true), Developer(3, true), Guest(4, false);

	private int level;
	private boolean hasPermissions;

	// Constructor to initialize fields
	Role(int level, boolean hasPermissions) {
		this.level = level;
		this.hasPermissions = hasPermissions;
	}

	// Method to perform task based on role
	public void performTask() {
		switch (this) {
		case Admin:
			System.out.println("Managing users...");
			break;
		case Manager:
			System.out.println("Managing projects...");
			break;
		case Developer:
			System.out.println("Developing features...");
			break;
		case Guest:
			System.out.println("Viewing public information...");
			break;
		}
	}

	// Getters
	public int getLevel() {
		return level;
	}

	public boolean hasPermissions() {
		return hasPermissions;
	}

	// Static method to get Role by level
	public static Role getRoleByLevel(int level) {
		for (Role role : Role.values()) {
			if (role.getLevel() == level) {
				return role;
			}
		}
		throw new IllegalArgumentException("No role found with level: " + level);
	}

	// Static method to display all roles
	public static void displayAllRoles() {
		for (Role role : Role.values()) {
			System.out.println(
					"Role: " + role + ", Level: " + role.getLevel() + ", Has Permissions: " + role.hasPermissions());
			role.performTask();
		}
	}

	public static void main(String[] args) {
		// Display information about all roles
		Role.displayAllRoles();
	}
}
