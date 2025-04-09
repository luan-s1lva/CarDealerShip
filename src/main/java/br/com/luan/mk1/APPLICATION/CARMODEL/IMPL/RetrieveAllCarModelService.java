package br.com.luan.mk1.APPLICATION.CARMODEL.IMPL;

import java.util.List;

import br.com.luan.mk1.APPLICATION.CARMODEL.RetrieveAllCarModel;
import br.com.luan.mk1.DOMAIN.CARMODEL.CarModel;
import br.com.luan.mk1.DOMAIN.CARMODEL.CarModelRepository;

public class RetrieveAllCarModelService implements RetrieveAllCarModel{

	private final CarModelRepository carModelRepo;

	public RetrieveAllCarModelService(CarModelRepository carModelRepo) {
		this.carModelRepo = carModelRepo;
	}

	@Override
	public List<CarModel> retrieveAll() {
		return carModelRepo.retrieveAll();
	}
}
