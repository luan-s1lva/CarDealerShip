package br.com.luan.mk1.APPLICATION.DTO;

public class CarModelDTO {

	private Long carModelId;
	private Long brandId;
	private String name;
	private String type;
	
	public CarModelDTO() {}

	public CarModelDTO(Long carModelId, Long brandId, String name, String type) {
		this.carModelId = carModelId;
		this.brandId = brandId;
		this.name = name;
		this.type = type;
	}

	public Long getCarModelId() {
		return carModelId;
	}

	public void setCarModelId(Long carModelId) {
		this.carModelId = carModelId;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
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
