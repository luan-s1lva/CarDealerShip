package br.com.luan.mk1.DOMAIN.CARMODEL;

import java.util.List;

import br.com.luan.mk1.APPLICATION.DTO.CarModelSearchDTO;

public interface CarModelRepository {

	List<CarModel> retrieveAll();
	
	List<CarModel> retrieveByFilter(CarModelSearchDTO car);
	
	CarModel save(CarModel carModel);
	
	CarModel update(CarModel carModel);
	
	boolean remove(Long carModelId);
}
