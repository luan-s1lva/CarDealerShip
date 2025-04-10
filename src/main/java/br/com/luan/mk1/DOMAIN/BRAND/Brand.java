package br.com.luan.mk1.DOMAIN.BRAND;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.luan.mk1.DOMAIN.CARMODEL.CarModel;

import java.util.ArrayList;

import jakarta.persistence.*;

@Entity
@Table(name = "brands")
public class Brand {

	@Id 
	@GeneratedValue 
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@OneToMany(mappedBy = "brand")
	@JsonManagedReference
	private List<CarModel> models = new ArrayList<>();
	
	public Brand() {}
	
	public Brand(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CarModel> getModels() {
		return models;
	}

	public void setModels(List<CarModel> models) {
		this.models = models;
	}
	
}
