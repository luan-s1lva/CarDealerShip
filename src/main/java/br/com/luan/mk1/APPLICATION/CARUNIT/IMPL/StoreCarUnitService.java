package br.com.luan.mk1.APPLICATION.CARUNIT.IMPL;

import org.springframework.stereotype.Service;

import br.com.luan.mk1.APPLICATION.CARUNIT.StoreCarUnit;
import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnit;
import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnitRepository;

@Service
public class StoreCarUnitService implements StoreCarUnit{

	private final CarUnitRepository carUnitRepository;

	public StoreCarUnitService(CarUnitRepository carUnitRepository) {
		this.carUnitRepository = carUnitRepository;
	}

	@Override
	public boolean storeCarUnit(CarUnit car) {
		CarUnit carUnit = carUnitRepository.save(car);
		
		if (carUnit != null) return true;
		else return false;
	}
	
	
}
