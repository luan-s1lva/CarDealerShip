package br.com.luan.mk1.APPLICATION.CARUNIT.IMPL;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.luan.mk1.APPLICATION.CARUNIT.PurchaseCarUnit;
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
		Customer customer = customerRepository.retrieveById(customerId);
		
		if ((carUnitRepository.retrieveByFilter(carUnitId, null, null, null, null)).size() == 1) {
			CarUnit carUnit = (CarUnit) carUnitRepository.retrieveByFilter(carUnitId, null, null, null, null);
			Purchase purchase = new Purchase(carUnit,customer,new Date());
			
			purchaseRepository.save(purchase);
			return true;
		}
		
		return false;
	}
	
	
}
