package br.com.luan.mk1.APPLICATION.DTO;

public class SearchCarUnitDTO {

	private Long carUnitId;
	private Double  price;
	private String color;
	private Integer year;
	private Boolean status;
	
	public SearchCarUnitDTO() {}
	
	public SearchCarUnitDTO(Long carUnitId, double price, String color, int year, boolean status) {
		super();
		this.carUnitId = carUnitId;
		this.price = price;
		this.color = color;
		this.year = year;
		this.status = status;
	}
	
	public Long getCarUnitId() {
		return carUnitId;
	}
	public void setCarUnitId(Long carUnitId) {
		this.carUnitId = carUnitId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
