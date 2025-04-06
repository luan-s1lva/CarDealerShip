package br.com.luan.mk1.DOMAIN.CARMODEL;

import java.util.List;

public interface CarModelRepository {

	List<CarModel> retrieveAll();
	
	List<CarModel> retrieveByFilter(String name, String type);
	
	CarModel save(CarModel carModel);
	
	boolean update(CarModel carModel);
	
	boolean remove(Long carModelId);
}
