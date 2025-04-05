package br.com.luan.mk1.DOMAIN;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchases")
public class Purchase {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "car_unit_id",nullable = false)
	private CarUnit carUnit;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "csutomer_id",nullable = false)
	private Customer customer;
	
	@Column(nullable = false)
	private Date purchaseDate;

	public Purchase() {}

	public Purchase(CarUnit carUnit, Customer customer, Date purchaseDate) {
		this.carUnit = carUnit;
		this.customer = customer;
		this.purchaseDate = purchaseDate;
	}

	public Long getId() {
		return id;
	}

	public CarUnit getCarUnit() {
		return carUnit;
	}

	public void setCarUnit(CarUnit carUnit) {
		this.carUnit = carUnit;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	
}
