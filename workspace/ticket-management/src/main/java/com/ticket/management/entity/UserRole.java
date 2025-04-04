package com.ticket.management.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "user_roles")
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Id for the User role")
	@NotBlank(message = "Id is auto generated")
	private Long id;
	
	@Schema(description = "User Id from the User table")
	@ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
	@JsonBackReference
    private User user;
	
	@Schema(description = "Role name for the User")
	private String roleName;
	
	public UserRole() {
		
	}

	public UserRole(User user, String roleName) {
		super();
		this.user = user;
		this.roleName = roleName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", user=" + user + ", roleName=" + roleName + "]";
	}

}
