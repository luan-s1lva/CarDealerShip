package br.com.luan.mk1.APPLICATION.EMPLOYEE;

import java.util.List;

import br.com.luan.mk1.APPLICATION.DTO.SearchCarUnitDTO;
import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnit;

public interface RetrieveCarUnitByDTO {

	List<CarUnit> retrieveCarUnitByDTO(SearchCarUnitDTO carUnitDTO);
}
