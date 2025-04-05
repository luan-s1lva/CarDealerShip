package br.com.luan.mk1.DOMAIN;

import jakarta.persistence.*;

@Entity
public class Brand {

	@Id 
	@GeneratedValue 
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	public Brand() {}
	
	public Brand(Long id, String name) {
		super();
		this.id = id;
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
}
