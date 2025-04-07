package br.com.luan.mk1.INFRASTRUCTURE.CARUNIT;

import java.util.List;
import java.util.Optional;

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
		return jpaCarUnitRepo.save(carUnit);
	}

	@Override
	public boolean update(CarUnit carUnit) {
		CarUnit car = jpaCarUnitRepo.save(carUnit);
		
		if (car != null) return true;
		else return false;
	}

	@Override
	public boolean remove(Long carUnitId) {
		jpaCarUnitRepo.deleteById(carUnitId);
		Optional<CarUnit> car = jpaCarUnitRepo.findById(carUnitId);
		
		if (car.isEmpty() == true) return true;
		else return false;
	}
}
