package br.com.luan.mk1.DOMAIN.CARUNIT;

import br.com.luan.mk1.DOMAIN.CARMODEL.CarModel;
import br.com.luan.mk1.DOMAIN.PURCHASE.Purchase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "car_units")
public class CarUnit {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "modelId")
	private CarModel carModel;
	
	@OneToOne(mappedBy = "carUnit")
	private Purchase purchase;
	
	@Column(nullable = false)
	private double price;
	
	@Column(nullable = false)
	private String color;
	
	@Column(nullable = false)
	private int year;
	
	@Column(nullable = false)
	private boolean status;

	public CarUnit() {}

	public CarUnit(CarModel carModel, Purchase purchase, double price, String color, int year, boolean status) {
		this.carModel = carModel;
		this.purchase = purchase;
		this.price = price;
		this.color = color;
		this.year = year;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public CarModel getCarModel() {
		return carModel;
	}

	public void setCarModel(CarModel carModel) {
		this.carModel = carModel;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

		
}
