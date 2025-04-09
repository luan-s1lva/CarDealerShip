package br.com.luan.mk1.APPLICATION.CARMODEL.IMPL;

import br.com.luan.mk1.APPLICATION.CARMODEL.UpdateCarModel;
import br.com.luan.mk1.DOMAIN.CARMODEL.CarModel;
import br.com.luan.mk1.DOMAIN.CARMODEL.CarModelRepository;

public class UpdateCarModelService implements UpdateCarModel{

	private final CarModelRepository carModelRepo;

	public UpdateCarModelService(CarModelRepository carModelRepo) {
		super();
		this.carModelRepo = carModelRepo;
	}

	@Override
	public CarModel updateCarModel(CarModel car) {
		return carModelRepo.save(car);
	}
}
