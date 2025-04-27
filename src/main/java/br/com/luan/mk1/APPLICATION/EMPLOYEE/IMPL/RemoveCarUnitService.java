package br.com.luan.mk1.APPLICATION.EMPLOYEE.IMPL;

import org.springframework.stereotype.Service;

import br.com.luan.mk1.APPLICATION.EMPLOYEE.RemoveCarUnit;
import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnitRepository;

@Service
public class RemoveCarUnitService implements RemoveCarUnit{

	private final CarUnitRepository carUnitRepo;

	public RemoveCarUnitService(CarUnitRepository carUnitRepo) {
		super();
		this.carUnitRepo = carUnitRepo;
	}

	@Override
	public void removeCarUnit(Long id) {
		carUnitRepo.remove(id);
	}
}
