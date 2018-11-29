package com.lcsolution.smartIntegration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User extends DomainModel {

	private static final long serialVersionUID = -1576358000551864878L;
	
	@Column
	private String name;
	
	@Column
	private String username;
	
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	@Column
	private String password;
	
	@ManyToOne
    @JoinColumn(name = "workshop_id")
	private Workshop workshop;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public Workshop getWorkshop() {
		return workshop;
	}

	public void setWorkshop(Workshop workshop) {
		this.workshop = workshop;
	}
}