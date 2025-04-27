package br.com.luan.mk1.APPLICATION.EMPLOYEE.IMPL;

import org.springframework.stereotype.Service;

import br.com.luan.mk1.APPLICATION.EMPLOYEE.StoreCarUnit;
import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnit;
import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnitRepository;

@Service
public class StoreCarUnitService implements StoreCarUnit{

	private final CarUnitRepository carUnitRepo;

	public StoreCarUnitService(CarUnitRepository carUnitRepo) {
		super();
		this.carUnitRepo = carUnitRepo;
	}

	@Override
	public CarUnit store(CarUnit carUnit) {
		return carUnitRepo.save(carUnit);
	}
	
	
}
