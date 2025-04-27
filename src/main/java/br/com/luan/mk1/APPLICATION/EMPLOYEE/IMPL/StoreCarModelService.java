package br.com.luan.mk1.APPLICATION.EMPLOYEE.IMPL;

import org.springframework.stereotype.Service;

import br.com.luan.mk1.APPLICATION.EMPLOYEE.StoreCarModel;
import br.com.luan.mk1.DOMAIN.CARMODEL.CarModel;
import br.com.luan.mk1.DOMAIN.CARMODEL.CarModelRepository;

@Service
public class StoreCarModelService implements StoreCarModel{

	private final CarModelRepository carModelRepo;

	public StoreCarModelService(CarModelRepository carModelRepo) {
		super();
		this.carModelRepo = carModelRepo;
	}

	@Override
	public CarModel storeCarModel(CarModel carModel) {
		return carModelRepo.save(carModel);
	}
	
}
