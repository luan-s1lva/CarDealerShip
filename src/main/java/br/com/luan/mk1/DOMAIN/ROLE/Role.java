package br.com.luan.mk1.DOMAIN.ROLE;

import java.util.List;

import br.com.luan.mk1.DOMAIN.CUSTOMER.Customer;
import br.com.luan.mk1.DOMAIN.EMPLOYEE.Employee;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(mappedBy = "role")
	private List<Customer> customers;
	
	@OneToMany(mappedBy = "role")
	private List<Employee> employees;
	
	@Column(nullable = false)
	private String name;
	
	public Role() {
		super();
	}

	public Role(Long id, String name) {
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
