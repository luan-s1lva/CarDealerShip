package br.com.luan.mk1.INFRASTRUCTURE.CARMODEL;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.luan.mk1.APPLICATION.DTO.CarModelSearchDTO;
import br.com.luan.mk1.DOMAIN.CARMODEL.CarModel;
import br.com.luan.mk1.DOMAIN.CARMODEL.CarModelRepository;

@Repository
public class CarModelRepositoryImpl implements CarModelRepository{

	private final JpaCarModelRepository jpaCarModelRepo;

	public CarModelRepositoryImpl(JpaCarModelRepository jpaCarModelRepo) {
		this.jpaCarModelRepo = jpaCarModelRepo;
	}

	@Override
	public List<CarModel> retrieveAll() {
		return jpaCarModelRepo.findAll();
	}

	@Override
	public List<CarModel> retrieveByFilter(CarModelSearchDTO car) {
		return jpaCarModelRepo.retrieveByFilter(car);
	}

	@Override
	public CarModel save(CarModel carModel) {
		return jpaCarModelRepo.save(carModel);
	}

	@Override
	public CarModel update(CarModel carModel) {
		return jpaCarModelRepo.save(carModel);
	}

	@Override
	public boolean remove(Long carModelId) {
		jpaCarModelRepo.deleteById(carModelId);
		
		Optional<CarModel> car = jpaCarModelRepo.findById(carModelId);
		
		if (car.isEmpty() == true) return true;
		else return false;
	}

	@Override
	public Optional<CarModel> retrieveById(Long id) {
		return jpaCarModelRepo.findById(id);
	}
	
	
}
