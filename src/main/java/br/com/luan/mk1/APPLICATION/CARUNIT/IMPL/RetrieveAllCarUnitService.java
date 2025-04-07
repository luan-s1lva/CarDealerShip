package br.com.luan.mk1.APPLICATION.CARUNIT.IMPL;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.luan.mk1.APPLICATION.CARUNIT.RetrieveAllCarUnit;
import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnit;
import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnitRepository;

@Service
public class RetrieveAllCarUnitService implements RetrieveAllCarUnit{

	private final CarUnitRepository carUnitRepository;

	public RetrieveAllCarUnitService(CarUnitRepository carUnitRepository) {
		this.carUnitRepository = carUnitRepository;
	}

	@Override
	public List<CarUnit> returnAllCarUnit() {
		List<CarUnit> cars = carUnitRepository.retrieveAll();
		
		return cars;
	}
	
}
