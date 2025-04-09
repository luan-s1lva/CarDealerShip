package br.com.luan.mk1.INFRASTRUCTURE.CARMODEL.SEARCHBYDTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.luan.mk1.APPLICATION.DTO.CarModelSearchDTO;
import br.com.luan.mk1.DOMAIN.CARMODEL.CarModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class CarModelSearchByDTORepositoryImpl implements CarModelSearchByDTORepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<CarModel> retrieveByFilter(CarModelSearchDTO car) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CarModel> criteriaQuery = criteriaBuilder.createQuery(CarModel.class);
		Root<CarModel> carModel = criteriaQuery.from(CarModel.class);
		
		var joinCarModelAndBrand = carModel.join("brand");
		
		List<Predicate> conditions = new ArrayList<>();
		
		if (car != null) {
			if (!car.getName().isBlank() && car.getName() != null) {
				conditions.add(criteriaBuilder.like(carModel.get("name"), "%" + car.getName() + "%"));
			}
			
			if (!car.getType().isBlank() && car.getType() != null) {
				conditions.add(criteriaBuilder.like(carModel.get("type"), "%" + car.getType() + "%"));
			}
			
			if (!car.getBrandName().isBlank() && car.getBrandName() != null) {
				conditions.add(criteriaBuilder.like(joinCarModelAndBrand.get("name"), "%" + car.getBrandName() + "%"));
			}
		}
		
		criteriaQuery.where(conditions.toArray(new Predicate[0]));
		
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

}
