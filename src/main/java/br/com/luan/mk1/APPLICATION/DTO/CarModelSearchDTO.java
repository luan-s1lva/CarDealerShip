package br.com.luan.mk1.APPLICATION.DTO;

public class CarModelSearchDTO {

	private Long carModelId;
	private String brandName;
	private String name;
	private String type;
	
	public CarModelSearchDTO() {}

	public CarModelSearchDTO(Long carModelId, String brandName, String name, String type) {
		this.carModelId = carModelId;
		this.brandName = brandName;
		this.name = name;
		this.type = type;
	}

	public Long getCarModelId() {
		return carModelId;
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
