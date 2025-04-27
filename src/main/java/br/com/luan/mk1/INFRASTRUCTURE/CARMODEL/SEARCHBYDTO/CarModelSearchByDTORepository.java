package br.com.luan.mk1.INFRASTRUCTURE.CARMODEL.SEARCHBYDTO;

import java.util.List;

import br.com.luan.mk1.APPLICATION.DTO.SearchCarModelDTO;
import br.com.luan.mk1.DOMAIN.CARMODEL.CarModel;

public interface CarModelSearchByDTORepository {

	List<CarModel> retrieveByFilter(SearchCarModelDTO car);
}
