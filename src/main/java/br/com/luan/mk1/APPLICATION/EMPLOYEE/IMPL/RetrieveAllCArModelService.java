package br.com.luan.mk1.APPLICATION.EMPLOYEE.IMPL;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.luan.mk1.APPLICATION.EMPLOYEE.RetrieveAllCarModel;
import br.com.luan.mk1.DOMAIN.CARMODEL.CarModel;
import br.com.luan.mk1.DOMAIN.CARMODEL.CarModelRepository;

@Service
public class RetrieveAllCArModelService implements RetrieveAllCarModel{

	private final CarModelRepository carModelRepo;

	public RetrieveAllCArModelService(CarModelRepository carModelRepo) {
		super();
		this.carModelRepo = carModelRepo;
	}

	@Override
	public List<CarModel> retrieveAllCarModel() {
		return carModelRepo.retrieveAll();
	}
	
	
}
