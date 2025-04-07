package br.com.luan.mk1.APPLICATION.CARUNIT.IMPL;

import org.springframework.stereotype.Service;

import br.com.luan.mk1.APPLICATION.CARUNIT.RemoveCarUnit;
import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnitRepository;

@Service
public class RemoveCarUnitService implements RemoveCarUnit{

	private final CarUnitRepository carUnitRepository;

	public RemoveCarUnitService(CarUnitRepository carUnitRepository) {
		this.carUnitRepository = carUnitRepository;
	}

	@Override
	public boolean removeCarUnit(Long carUnitId) {
		boolean status = carUnitRepository.remove(carUnitId);
		
		return status;
	}
}
