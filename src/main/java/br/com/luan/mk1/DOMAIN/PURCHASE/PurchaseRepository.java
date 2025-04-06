package br.com.luan.mk1.DOMAIN.PURCHASE;

import java.util.List;

import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnit;
import br.com.luan.mk1.DOMAIN.CUSTOMER.Customer;

public interface PurchaseRepository {

	Purchase save(Purchase purchase);
	
	List<Purchase> returnAll();
	
	List<Purchase> returnByFilter(Customer customer, CarUnit carUnit);
}
