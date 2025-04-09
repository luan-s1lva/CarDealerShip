package br.com.luan.mk1.APPLICATION.CARMODEL.IMPL;

import br.com.luan.mk1.APPLICATION.CARMODEL.StoreCarModel;
import br.com.luan.mk1.DOMAIN.CARMODEL.CarModel;
import br.com.luan.mk1.DOMAIN.CARMODEL.CarModelRepository;

public class StoreCarModelService implements StoreCarModel{

	private final CarModelRepository carModelRepo;
	
	public StoreCarModelService(CarModelRepository carModelRepo) {
		this.carModelRepo = carModelRepo;
	}

	@Override
	public CarModel store(CarModel carModel) {
		return carModelRepo.save(carModel);
	}

}
