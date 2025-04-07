package br.com.luan.mk1.INFRASTRUCTURE.CARUNIT.SEARCHBYDTO;

import java.util.List;

import br.com.luan.mk1.APPLICATION.DTO.SearchCarUnitDTO;
import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnit;

public interface CarUnitSearchByDTORepository {

	List<CarUnit> searchByDTO(SearchCarUnitDTO searchDTO);
}
