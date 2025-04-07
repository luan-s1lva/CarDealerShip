package br.com.luan.mk1.INFRASTRUCTURE.CARUNIT;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnit;
import br.com.luan.mk1.INFRASTRUCTURE.CARUNIT.SEARCHBYDTO.CarUnitSearchByDTORepository;

@Repository
public interface JpaCarUnitRepository extends JpaRepository<CarUnit, Long>, CarUnitSearchByDTORepository {

}
