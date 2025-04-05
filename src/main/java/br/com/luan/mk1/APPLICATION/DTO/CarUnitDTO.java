package br.com.luan.mk1.APPLICATION.DTO;

public class CarUnitDTO {

	private Long carUnitId;
	private CarModelDTO carModel;
	private double price;
	private String color;
	private int year;
	private boolean status;
	
	public CarUnitDTO() {}

	public CarUnitDTO(Long carUnitId, CarModelDTO carModel, double price, String color, int year, boolean status) {
		this.carUnitId = carUnitId;
		this.carModel = carModel;
		this.price = price;
		this.color = color;
		this.year = year;
		this.status = status;
	}

	public Long getCarUnitId() {
		return carUnitId;
	}

	public CarModelDTO getCarModel() {
		return carModel;
	}

	public double getPrice() {
		return price;
	}

	public String getColor() {
		return color;
	}

	public int getYear() {
		return year;
	}

	public boolean isStatus() {
		return status;
	}
	
	
}
