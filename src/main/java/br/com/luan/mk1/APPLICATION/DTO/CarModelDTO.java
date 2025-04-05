package br.com.luan.mk1.APPLICATION.DTO;

public class CarModelDTO {

	private Long carModelId;
	private String name;
	private String type;
	
	public CarModelDTO() {}

	public CarModelDTO(Long carModelId, String name, String type) {
		this.carModelId = carModelId;
		this.name = name;
		this.type = type;
	}

	public Long getCarModelId() {
		return carModelId;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}
}
