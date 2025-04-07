package br.com.luan.mk1.APPLICATION.CARUNIT.IMPL;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.luan.mk1.APPLICATION.CARUNIT.SearchCarUnit;
import br.com.luan.mk1.APPLICATION.DTO.SearchCarUnitDTO;
import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnit;
import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnitRepository;

@Service
public class SearchCarUnitService implements SearchCarUnit{

	private final CarUnitRepository carUnitRepository;

	public SearchCarUnitService(CarUnitRepository carUnitRepository) {
		this.carUnitRepository = carUnitRepository;
	}

	@Override
	public List<CarUnit> searchCarUnit(SearchCarUnitDTO searchCarUnitDTO) {
		List<CarUnit> cars = carUnitRepository.retrieveByFilter(searchCarUnitDTO);
		
		return cars;
	}
	
	
}
