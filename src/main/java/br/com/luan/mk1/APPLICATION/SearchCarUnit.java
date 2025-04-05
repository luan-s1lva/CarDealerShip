package br.com.luan.mk1.APPLICATION;

import java.util.List;

import br.com.luan.mk1.APPLICATION.DTO.SearchCarUnitDTO;
import br.com.luan.mk1.DOMAIN.CarUnit;

public interface SearchCarUnit {
	List<CarUnit> searchCarUnit(SearchCarUnitDTO searchCarUnitDTO);
}
