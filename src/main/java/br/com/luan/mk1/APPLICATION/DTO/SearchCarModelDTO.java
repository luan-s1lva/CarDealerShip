package br.com.luan.mk1.APPLICATION.DTO;

public class SearchCarModelDTO {

	private Long brandId;
	private String brandName;
	private String name;
	private String type;
	
	public SearchCarModelDTO() {
		super();
	}

	public SearchCarModelDTO(Long brandId, String brandName, String name, String type) {
		super();
		this.brandId = brandId;
		this.brandName = brandName;
		this.name = name;
		this.type = type;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
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
}
