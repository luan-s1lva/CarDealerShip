package br.com.luan.mk1.DOMAIN.CARUNIT;

import java.util.List;

public interface CarUnitRepository {

	List<CarUnit> retrieveAll();
	
	List<CarUnit> retrieveByFilter(Long carUnitId, String color, Integer year, Boolean status, Double price);
	
	CarUnit save(CarUnit carUnit);
	
	boolean update(CarUnit carUnit);
	
	boolean remove(Long carUnitId);
}
