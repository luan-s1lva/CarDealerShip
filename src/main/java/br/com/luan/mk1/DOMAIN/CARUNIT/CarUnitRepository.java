package br.com.luan.mk1.DOMAIN.CARUNIT;

import java.util.List;

import br.com.luan.mk1.APPLICATION.DTO.SearchCarUnitDTO;

public interface CarUnitRepository {

	List<CarUnit> retrieveAll();
	
	List<CarUnit> retrieveByFilter(SearchCarUnitDTO searchCarUnitDTO);
	
	CarUnit save(CarUnit carUnit);
	
	boolean update(CarUnit carUnit);
	
	boolean remove(Long carUnitId);
}
