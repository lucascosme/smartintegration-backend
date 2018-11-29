package com.lcsolution.smartIntegration.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="workshop")
public class Workshop extends DomainModel{

	private static final long serialVersionUID = -8488565064239207881L;
	
	@Column
	private String name;
	
	@Column
	private String cnpj;
	
	@ManyToMany
    @JoinTable(name="workshop_has_customer", joinColumns=
    {@JoinColumn(name="workshop_id")}, inverseJoinColumns=
      {@JoinColumn(name="customer_id")})
	private List<Customer> customers;
	
	//@OneToMany(mappedBy = "workshop")
	//private List<User> users;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	/*public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}*/
}
