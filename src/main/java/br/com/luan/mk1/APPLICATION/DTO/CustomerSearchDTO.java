package br.com.luan.mk1.APPLICATION.DTO;

public class CustomerSearchDTO {

	private String name;
	private String email;
	
	public CustomerSearchDTO() {}

	public CustomerSearchDTO(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
