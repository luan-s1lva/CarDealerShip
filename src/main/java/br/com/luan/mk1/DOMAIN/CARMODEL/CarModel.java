package br.com.luan.mk1.DOMAIN.CARMODEL;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.luan.mk1.DOMAIN.BRAND.Brand;
import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "car_models")
public class CarModel {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "brandId")
	@JsonBackReference
	private Brand brand;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String type;
	
	@OneToMany(mappedBy = "carModel")
	private List<CarUnit> units = new ArrayList<>();

	public CarModel() {}

	public CarModel(Long id, Brand brand, String name, String type) {
		this.id = id;
		this.brand = brand;
		this.name = name;
		this.type = type;
	}

	public Long getId() {
		return id;
	}
	
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<CarUnit> getUnits() {
		return units;
	}

	public void setUnits(List<CarUnit> units) {
		this.units = units;
	}
}
