package br.com.luan.mk1.DOMAIN.CARMODEL;

import java.util.List;

import br.com.luan.mk1.APPLICATION.DTO.SearchCarModelDTO;

public interface CarModelRepository {

	List<CarModel> retrieveAll();
	
	List<CarModel> retrieveByFilter(SearchCarModelDTO car);
	
	CarModel retrieveById(Long id);
	
	CarModel save(CarModel carModel);
	
	boolean update(CarModel carModel);
	
	void remove(Long carModelId);
}
