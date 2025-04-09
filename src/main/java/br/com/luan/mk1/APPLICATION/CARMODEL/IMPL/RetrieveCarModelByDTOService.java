package br.com.luan.mk1.APPLICATION.CARMODEL.IMPL;

import java.util.List;

import br.com.luan.mk1.APPLICATION.CARMODEL.RetrieveCarModelByDTO;
import br.com.luan.mk1.APPLICATION.DTO.CarModelSearchDTO;
import br.com.luan.mk1.DOMAIN.CARMODEL.CarModel;
import br.com.luan.mk1.DOMAIN.CARMODEL.CarModelRepository;

public class RetrieveCarModelByDTOService implements RetrieveCarModelByDTO{

	private final CarModelRepository carModelRepo;

	public RetrieveCarModelByDTOService(CarModelRepository carModelRepo) {
		this.carModelRepo = carModelRepo;
	}

	@Override
	public List<CarModel> retrieveByDTO(CarModelSearchDTO car) {
		return carModelRepo.retrieveByFilter(car);
	}
	
}
