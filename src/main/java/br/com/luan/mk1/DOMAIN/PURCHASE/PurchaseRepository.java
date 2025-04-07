package br.com.luan.mk1.DOMAIN.PURCHASE;

import java.util.List;

import br.com.luan.mk1.APPLICATION.DTO.CustomerSearchDTO;
import br.com.luan.mk1.APPLICATION.DTO.SearchCarUnitDTO;

public interface PurchaseRepository {

	Purchase save(Purchase purchase);
	
	List<Purchase> returnAll();
	
	List<Purchase> returnByFilter(CustomerSearchDTO customerDTO, SearchCarUnitDTO carUnitDTO);
}
