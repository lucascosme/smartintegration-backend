package com.lcsolution.smartIntegration.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car extends DomainModel {

	private static final long serialVersionUID = -2841378342704977392L;

	@Column(nullable = false)
	private String board;

	@Column
	private String brand;

	@Column
	private String model;

	@Column
	private String color;

	@Column
	private String version;

	@Column
	private String chassis;
	
	@ManyToMany(mappedBy = "cars") //Relacionamento bidirecional sendo carro o lado fraco da ligação
	private List<Customer> customers;

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getChassis() {
		return chassis;
	}

	public void setChassis(String chassis) {
		this.chassis = chassis;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
}
