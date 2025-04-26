package br.com.luan.mk1.APPLICATION.EMPLOYEE.IMPL;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.luan.mk1.APPLICATION.DTO.SearchCarModelDTO;
import br.com.luan.mk1.APPLICATION.EMPLOYEE.RetrieveCarModelByDTO;
import br.com.luan.mk1.DOMAIN.CARMODEL.CarModel;
import br.com.luan.mk1.DOMAIN.CARMODEL.CarModelRepository;

@Service
public class RetrieveCarModelByDTOService implements RetrieveCarModelByDTO{

	private final CarModelRepository carModelRepo;

	public RetrieveCarModelByDTOService(CarModelRepository carModelRepo) {
		super();
		this.carModelRepo = carModelRepo;
	}

	@Override
	public List<CarModel> retrieveCarModelByDTO(SearchCarModelDTO carModelDTO) {
		return carModelRepo.retrieveByFilter(carModelDTO);
	}
}
