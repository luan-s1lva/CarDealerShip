package br.com.luan.mk1.INFRASTRUCTURE.PURCHASE.SEARCHBYDTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.luan.mk1.APPLICATION.DTO.CustomerSearchDTO;
import br.com.luan.mk1.APPLICATION.DTO.SearchCarUnitDTO;
import br.com.luan.mk1.DOMAIN.PURCHASE.Purchase;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class PurchaseSearchByDTORepositoryImpl implements PurchaseSearchByDTORepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Purchase> searchByFilter(CustomerSearchDTO customerDTO, SearchCarUnitDTO carUnitDTO) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Purchase> criteriaQuery = criteriaBuilder.createQuery(Purchase.class);
		Root<Purchase> purchase = criteriaQuery.from(Purchase.class);
		
		var customerData = purchase.join("customer", JoinType.INNER);
		var carUnitData = purchase.join("carUnit", JoinType.INNER);
		
		List<Predicate> logicConditions = new ArrayList<>();
		
		if (customerDTO != null) {
			if (customerDTO.getName().isBlank() == false && customerDTO.getName() != null) {
				logicConditions.add(criteriaBuilder.like(customerData.get("name"), "%" + customerDTO.getName() + "%"));
			}
			
			if (customerDTO.getEmail().isBlank() == false && customerDTO.getEmail() != null) {
				logicConditions.add(criteriaBuilder.like(customerData.get("email"), "%" + customerDTO.getEmail() + "%"));
			}
		}
		
		if (carUnitDTO != null) {
			if (carUnitDTO.getColor() != null && carUnitDTO.getColor().isBlank() == false) {
				logicConditions.add(criteriaBuilder.equal(carUnitData.get("color"), carUnitDTO.getColor()));
			}
			
			if (carUnitDTO.getMaxPrice() != null || carUnitDTO.getMinPrice() != null) {
				if (carUnitDTO.getMaxPrice() != null && carUnitDTO.getMinPrice() != null) {
					logicConditions.add(criteriaBuilder.ge(carUnitData.get("price"), carUnitDTO.getMinPrice()));
					logicConditions.add(criteriaBuilder.le(carUnitData.get("price"), carUnitDTO.getMaxPrice()));
				} else if (carUnitDTO.getMaxPrice() != null) {
					logicConditions.add(criteriaBuilder.ge(carUnitData.get("price"), carUnitDTO.getMinPrice()));
				} else if (carUnitDTO.getMinPrice() != null) {
					logicConditions.add(criteriaBuilder.le(carUnitData.get("price"), carUnitDTO.getMaxPrice()));
				}
			}
			
			if (carUnitDTO.getMinYear() != null || carUnitDTO.getMaxYear() != null) {
				if (carUnitDTO.getMinYear() != null && carUnitDTO.getMaxYear() != null) {
					logicConditions.add(criteriaBuilder.ge(carUnitData.get("year"), carUnitDTO.getMinYear()));
					logicConditions.add(criteriaBuilder.le(carUnitData.get("year"), carUnitDTO.getMaxYear()));
				} else if (carUnitDTO.getMinYear() != null) {
					logicConditions.add(criteriaBuilder.le(carUnitData.get("year"), carUnitDTO.getMaxYear()));
				} else if (carUnitDTO.getMaxYear() != null) {
					logicConditions.add(criteriaBuilder.ge(carUnitData.get("year"), carUnitDTO.getMinYear()));
				}
			}
			
			if (carUnitDTO.getIsAvailable() != null) {
				logicConditions.add(criteriaBuilder.equal(carUnitData.get("status"), carUnitDTO.getIsAvailable()));
			}
		}
		
		criteriaQuery.select(purchase).where(logicConditions.toArray(new Predicate[0]));
		
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

}
