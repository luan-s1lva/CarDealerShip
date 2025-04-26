package br.com.luan.mk1.APPLICATION.EMPLOYEE;

import java.util.List;

import br.com.luan.mk1.APPLICATION.DTO.SearchCarModelDTO;
import br.com.luan.mk1.DOMAIN.CARMODEL.CarModel;

public interface RetrieveCarModelByDTO {

	List<CarModel> retrieveCarModelByDTO(SearchCarModelDTO carModelDTO);
}
