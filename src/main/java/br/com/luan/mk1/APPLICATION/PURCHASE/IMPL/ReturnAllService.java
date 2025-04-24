package br.com.luan.mk1.APPLICATION.PURCHASE.IMPL;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.luan.mk1.APPLICATION.PURCHASE.ReturnAllPurchases;
import br.com.luan.mk1.DOMAIN.PURCHASE.Purchase;
import br.com.luan.mk1.DOMAIN.PURCHASE.PurchaseRepository;

@Service
public class ReturnAllService implements ReturnAllPurchases{

	private final PurchaseRepository purchaseRepo;

	public ReturnAllService(PurchaseRepository purchaseRepo) {
		super();
		this.purchaseRepo = purchaseRepo;
	}

	@Override
	public List<Purchase> returnAll() {
		return purchaseRepo.returnAll();
	}
}
