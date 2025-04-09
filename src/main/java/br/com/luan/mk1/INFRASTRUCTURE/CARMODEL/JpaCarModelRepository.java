package br.com.luan.mk1.INFRASTRUCTURE.CARMODEL;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.luan.mk1.DOMAIN.CARMODEL.CarModel;
import br.com.luan.mk1.INFRASTRUCTURE.CARMODEL.SEARCHBYDTO.CarModelSearchByDTORepository;

public interface JpaCarModelRepository extends JpaRepository<CarModel, Long>, CarModelSearchByDTORepository{

}
