package br.com.luan.mk1.APPLICATION.DTO;

public class SearchBrandDTO {

	private Long id;
	private String brandName;
	
	public SearchBrandDTO() {
		super();
	}

	public SearchBrandDTO(Long id, String brandName) {
		super();
		this.id = id;
		this.brandName = brandName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

}
