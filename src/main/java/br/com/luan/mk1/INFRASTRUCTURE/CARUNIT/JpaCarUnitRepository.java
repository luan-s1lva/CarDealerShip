package br.com.luan.mk1.INFRASTRUCTURE.CARUNIT;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnit;
import br.com.luan.mk1.INFRASTRUCTURE.CARUNIT.SEARCHBYDTO.CarUnitSearchByDTORepository;

public interface JpaCarUnitRepository extends JpaRepository<CarUnit, Long>, CarUnitSearchByDTORepository {

}
