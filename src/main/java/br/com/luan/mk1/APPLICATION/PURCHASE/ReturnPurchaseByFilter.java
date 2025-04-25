package br.com.luan.mk1.APPLICATION.PURCHASE;

import java.util.List;

import br.com.luan.mk1.APPLICATION.DTO.CustomerSearchDTO;
import br.com.luan.mk1.APPLICATION.DTO.SearchCarUnitDTO;
import br.com.luan.mk1.DOMAIN.PURCHASE.Purchase;

public interface ReturnPurchaseByFilter {

	List<Purchase> returnByFilter(CustomerSearchDTO customerDTO, SearchCarUnitDTO carUnitDTO);
}
