package br.com.luan.mk1.APPLICATION.PURCHASE.IMPL;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.luan.mk1.APPLICATION.DTO.CustomerSearchDTO;
import br.com.luan.mk1.APPLICATION.DTO.SearchCarUnitDTO;
import br.com.luan.mk1.APPLICATION.PURCHASE.ReturnPurchaseByFilter;
import br.com.luan.mk1.DOMAIN.PURCHASE.Purchase;
import br.com.luan.mk1.DOMAIN.PURCHASE.PurchaseRepository;

@Service
public class ReturnPurchaseByFilterService implements ReturnPurchaseByFilter {

	private final PurchaseRepository purchaseRepo;
	
	public ReturnPurchaseByFilterService(PurchaseRepository purchaseRepo) {
		super();
		this.purchaseRepo = purchaseRepo;
	}

	@Override
	public List<Purchase> returnByFilter(CustomerSearchDTO customerDTO, SearchCarUnitDTO carUnitDTO) {
		return purchaseRepo.returnByFilter(customerDTO, carUnitDTO);
	}

}
