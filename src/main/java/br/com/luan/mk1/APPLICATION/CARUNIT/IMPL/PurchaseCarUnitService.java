package br.com.luan.mk1.APPLICATION.CARUNIT.IMPL;

import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.luan.mk1.APPLICATION.CARUNIT.PurchaseCarUnit;
import br.com.luan.mk1.APPLICATION.DTO.SearchCarUnitDTO;
import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnit;
import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnitRepository;
import br.com.luan.mk1.DOMAIN.CUSTOMER.Customer;
import br.com.luan.mk1.DOMAIN.CUSTOMER.CustomerRepository;
import br.com.luan.mk1.DOMAIN.PURCHASE.Purchase;
import br.com.luan.mk1.DOMAIN.PURCHASE.PurchaseRepository;

@Service
public class PurchaseCarUnitService implements PurchaseCarUnit {

	private final CarUnitRepository carUnitRepository;
	private final CustomerRepository customerRepository;
	private final PurchaseRepository purchaseRepository;

	public PurchaseCarUnitService(CarUnitRepository carUnitRepository, CustomerRepository customerRepository,
			PurchaseRepository purchaseRepository) {
		this.carUnitRepository = carUnitRepository;
		this.customerRepository = customerRepository;
		this.purchaseRepository = purchaseRepository;
	}

	@Override
	public boolean purchaseCarUnit(Long customerId, Long carUnitId) {
		Optional<Customer> cust = customerRepository.retrieveById(customerId);
		
		if (cust.isPresent() == true) { 
			Customer customer = cust.get();	
			SearchCarUnitDTO searchCarUnitDTO = new SearchCarUnitDTO(carUnitId,null,null,null,null,null,null);
			
			if ((carUnitRepository.retrieveByFilter(searchCarUnitDTO)).size() == 1) {
				CarUnit carUnit = (CarUnit) carUnitRepository.retrieveByFilter(searchCarUnitDTO);
				Purchase purchase = new Purchase(carUnit,customer,new Date());
				
				purchaseRepository.save(purchase);
				return true;
			}
		}
		
		return false;
	}
	
	
}
