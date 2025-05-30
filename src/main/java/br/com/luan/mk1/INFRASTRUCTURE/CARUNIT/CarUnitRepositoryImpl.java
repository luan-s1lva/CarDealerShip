package br.com.luan.mk1.INFRASTRUCTURE.CARUNIT;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.luan.mk1.APPLICATION.DTO.SearchCarUnitDTO;
import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnit;
import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnitRepository;

@Repository
public class CarUnitRepositoryImpl implements CarUnitRepository{

	private final JpaCarUnitRepository jpaCarUnitRepo;

	public CarUnitRepositoryImpl(JpaCarUnitRepository jpaCarUnitRepo) {
		this.jpaCarUnitRepo = jpaCarUnitRepo;
	}

	@Override
	public List<CarUnit> retrieveAll() {
		return jpaCarUnitRepo.findAll();
	}

	@Override
	public List<CarUnit> retrieveByFilter(SearchCarUnitDTO searchCarUnitDTO) {
		return jpaCarUnitRepo.searchByDTO(searchCarUnitDTO);
	}

	@Override
	public CarUnit save(CarUnit carUnit) {
		carUnit.setStatus(true);
		return jpaCarUnitRepo.save(carUnit);
	}

	@Override
	public boolean update(CarUnit carUnit) {
		CarUnit car = jpaCarUnitRepo.save(carUnit);
		
		if (car != null) return true;
		else return false;
	}

	@Override
	public void remove(Long carUnitId) {
		jpaCarUnitRepo.deleteById(carUnitId);
	}

	@Override
	public CarUnit retrieveById(Long id) {
		return jpaCarUnitRepo.findById(id).get();
	}
}
