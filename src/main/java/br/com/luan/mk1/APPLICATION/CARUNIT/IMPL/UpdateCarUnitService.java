package br.com.luan.mk1.APPLICATION.CARUNIT.IMPL;

import org.springframework.stereotype.Service;

import br.com.luan.mk1.APPLICATION.CARUNIT.UpdateCarUnit;
import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnit;
import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnitRepository;

@Service
public class UpdateCarUnitService implements UpdateCarUnit{

	private final CarUnitRepository carUnitRepository;

	public UpdateCarUnitService(CarUnitRepository carUnitRepository) {
		this.carUnitRepository = carUnitRepository;
	}

	@Override
	public boolean updateCarUnit(CarUnit carUnit) {
		boolean status = carUnitRepository.update(carUnit);
		
		return status;
	}
	
	
}
