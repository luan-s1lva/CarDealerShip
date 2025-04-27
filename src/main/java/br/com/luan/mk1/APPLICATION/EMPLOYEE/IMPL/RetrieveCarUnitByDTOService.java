package br.com.luan.mk1.APPLICATION.EMPLOYEE.IMPL;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.luan.mk1.APPLICATION.DTO.SearchCarUnitDTO;
import br.com.luan.mk1.APPLICATION.EMPLOYEE.RetrieveCarUnitByDTO;
import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnit;
import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnitRepository;

@Service
public class RetrieveCarUnitByDTOService implements RetrieveCarUnitByDTO {

	private final CarUnitRepository carUnitRepo;

	public RetrieveCarUnitByDTOService(CarUnitRepository carUnitRepo) {
		super();
		this.carUnitRepo = carUnitRepo;
	}

	@Override
	public List<CarUnit> retrieveCarUnitByDTO(SearchCarUnitDTO carUnitDTO) {
		return carUnitRepo.retrieveByFilter(carUnitDTO);
	}
	
}
