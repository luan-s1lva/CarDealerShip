package br.com.luan.mk1.APPLICATION.CARMODEL.IMPL;

import br.com.luan.mk1.APPLICATION.CARMODEL.RemoveCarModel;
import br.com.luan.mk1.DOMAIN.CARMODEL.CarModelRepository;

public class RemoveCarModelService implements RemoveCarModel{

	private final CarModelRepository carModelRepo;
	
	public RemoveCarModelService(CarModelRepository carModelRepo) {
		this.carModelRepo = carModelRepo;
	}

	@Override
	public boolean remove(Long carModelId) {
		return carModelRepo.remove(carModelId);
	}

}
