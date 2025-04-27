package br.com.luan.mk1.INFRASTRUCTURE.CARMODEL;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.luan.mk1.APPLICATION.DTO.SearchCarModelDTO;
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
	public CarModel save(CarModel carModel) {
		return jpaCarModelRepo.save(carModel);
	}

	@Override
	public boolean update(CarModel carModel) {
		CarModel model = jpaCarModelRepo.save(carModel);
		
		if (model != null) return true;
		else return false;
	}

	@Override
	public void remove(Long carModelId) {
		jpaCarModelRepo.deleteById(carModelId);
	}

	@Override
	public List<CarModel> retrieveByFilter(SearchCarModelDTO car) {
		return jpaCarModelRepo.retrieveByFilter(car);
	}

	@Override
	public CarModel retrieveById(Long id) {
		return jpaCarModelRepo.findById(id).get();
	}	
	
}
