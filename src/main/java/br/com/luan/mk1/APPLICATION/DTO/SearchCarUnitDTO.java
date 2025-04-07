package br.com.luan.mk1.APPLICATION.DTO;

public class SearchCarUnitDTO {

	private Long carUnitId;
	private Double minPrice;
	private Double maxPrice;
	private String color;
	private Integer minYear;
	private Integer maxYear;
	private Boolean isAvailable;
	
	public SearchCarUnitDTO() {}

	public SearchCarUnitDTO(Long carUnitId, Double minPrice, Double maxPrice, String color, Integer minYear,
			Integer maxYear, Boolean isAvailable) {
		this.carUnitId = carUnitId;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.color = color;
		this.minYear = minYear;
		this.maxYear = maxYear;
		this.isAvailable = isAvailable;
	}

	public Long getCarUnitId() {
		return carUnitId;
	}

	public Double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}

	public Double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getMinYear() {
		return minYear;
	}

	public void setMinYear(Integer minYear) {
		this.minYear = minYear;
	}

	public Integer getMaxYear() {
		return maxYear;
	}

	public void setMaxYear(Integer maxYear) {
		this.maxYear = maxYear;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
		
}
