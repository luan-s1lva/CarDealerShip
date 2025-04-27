package br.com.luan.mk1.APPLICATION.EMPLOYEE.IMPL;

import org.springframework.stereotype.Service;

import br.com.luan.mk1.APPLICATION.EMPLOYEE.RemoveCarModel;
import br.com.luan.mk1.DOMAIN.CARMODEL.CarModelRepository;

@Service
public class RemoveCarModelService implements RemoveCarModel{

	private final CarModelRepository carModelRepo;

	public RemoveCarModelService(CarModelRepository carModelRepo) {
		super();
		this.carModelRepo = carModelRepo;
	}

	@Override
	public void removeCarModel(Long id) {
		carModelRepo.remove(id);
	}
}
