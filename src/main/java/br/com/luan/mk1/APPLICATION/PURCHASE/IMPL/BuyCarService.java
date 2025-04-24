package br.com.luan.mk1.APPLICATION.PURCHASE.IMPL;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.luan.mk1.APPLICATION.PURCHASE.BuyCarUnit;
import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnit;
import br.com.luan.mk1.DOMAIN.CUSTOMER.Customer;
import br.com.luan.mk1.DOMAIN.PURCHASE.Purchase;
import br.com.luan.mk1.DOMAIN.PURCHASE.PurchaseRepository;

@Service
public class BuyCarService implements BuyCarUnit{

	private final PurchaseRepository purchaseRepo;
	
	public BuyCarService(PurchaseRepository purchaseRepo) {
		super();
		this.purchaseRepo = purchaseRepo;
	}

	@Override
	public Purchase buy(CarUnit carUnit, Customer customer) {
		Purchase purchase = new Purchase(carUnit, customer, new Date());
		
		return purchaseRepo.save(purchase);
	}

}
