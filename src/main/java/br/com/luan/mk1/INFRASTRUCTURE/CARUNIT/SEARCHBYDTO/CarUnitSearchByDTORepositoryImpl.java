package br.com.luan.mk1.INFRASTRUCTURE.CARUNIT.SEARCHBYDTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.luan.mk1.APPLICATION.DTO.SearchCarUnitDTO;
import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class CarUnitSearchByDTORepositoryImpl implements CarUnitSearchByDTORepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<CarUnit> searchByDTO(SearchCarUnitDTO searchDTO) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CarUnit> criteriaQuery = criteriaBuilder.createQuery(CarUnit.class);
		Root<CarUnit> car = criteriaQuery.from(CarUnit.class);
		
		List<Predicate> logicConditions = new ArrayList<>();
		
		if (searchDTO.getCarUnitId() != null) {
			if (searchDTO.getColor() != null) {
				logicConditions.add(criteriaBuilder.equal(car.get("color"), searchDTO.getColor()));
			}
			
			if (searchDTO.getMinPrice() != null || searchDTO.getMaxPrice() != null) {
				if (searchDTO.getMinPrice() != null && searchDTO.getMaxPrice() != null) {
					logicConditions.add(criteriaBuilder.ge(car.get("price"), searchDTO.getMinPrice()));
					logicConditions.add(criteriaBuilder.le(car.get("price"), searchDTO.getMaxPrice()));
				} else if (searchDTO.getMinPrice() != null) {
					logicConditions.add(criteriaBuilder.le(car.get("price"), searchDTO.getMaxPrice()));
				} else if (searchDTO.getMaxPrice() != null) {
					logicConditions.add(criteriaBuilder.ge(car.get("price"), searchDTO.getMinPrice()));
				}
			}
			
			if (searchDTO.getMinYear() != null || searchDTO.getMaxYear() != null) {
				if (searchDTO.getMinYear() != null && searchDTO.getMaxYear() != null) {
					logicConditions.add(criteriaBuilder.ge(car.get("year"), searchDTO.getMinYear()));
					logicConditions.add(criteriaBuilder.le(car.get("year"), searchDTO.getMaxYear()));
				} else if (searchDTO.getMinYear() != null) {
					logicConditions.add(criteriaBuilder.le(car.get("year"), searchDTO.getMaxYear()));
				} else if (searchDTO.getMaxYear() != null) {
					logicConditions.add(criteriaBuilder.ge(car.get("year"), searchDTO.getMinYear()));
				}
			}
			
			if (searchDTO.getIsAvailable() != null) {
				logicConditions.add(criteriaBuilder.equal(car.get("status"), searchDTO.getIsAvailable()));
			}
			
		}
		
		criteriaQuery.where(logicConditions.toArray(new Predicate[0]));
		
		TypedQuery<CarUnit> query = entityManager.createQuery(criteriaQuery);
		
		return query.getResultList();
	}

}
