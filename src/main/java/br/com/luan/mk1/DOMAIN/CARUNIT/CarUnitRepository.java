package br.com.luan.mk1.DOMAIN.CARUNIT;

import java.util.List;

import br.com.luan.mk1.APPLICATION.DTO.SearchCarUnitDTO;

public interface CarUnitRepository {

	List<CarUnit> retrieveAll();
	
	List<CarUnit> retrieveByFilter(SearchCarUnitDTO searchCarUnitDTO);
	
	CarUnit retrieveById(Long id);
	
	CarUnit save(CarUnit carUnit);
	
	boolean update(CarUnit carUnit);
	
	void remove(Long carUnitId);
}
