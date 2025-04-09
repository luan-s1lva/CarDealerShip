package br.com.luan.mk1.APPLICATION.CARMODEL;

import java.util.List;

import br.com.luan.mk1.APPLICATION.DTO.CarModelSearchDTO;
import br.com.luan.mk1.DOMAIN.CARMODEL.CarModel;

public interface RetrieveCarModelByDTO {

	List<CarModel> retrieveByDTO(CarModelSearchDTO car);
}
