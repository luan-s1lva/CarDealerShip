package br.com.luan.mk1.APPLICATION.EMPLOYEE.IMPL;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.luan.mk1.APPLICATION.EMPLOYEE.RetrieveAllCarUnit;
import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnit;
import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnitRepository;

@Service
public class RetrieveAllCarUnitService implements RetrieveAllCarUnit{

	private final CarUnitRepository carUnitRepo;

	public RetrieveAllCarUnitService(CarUnitRepository carUnitRepo) {
		super();
		this.carUnitRepo = carUnitRepo;
	}

	@Override
	public List<CarUnit> retrieveAllCarUnit() {
		return carUnitRepo.retrieveAll();
	}
}
