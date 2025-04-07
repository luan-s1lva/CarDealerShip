package br.com.luan.mk1.INFRASTRUCTURE.PURCHASE.SEARCHBYDTO;

import java.util.List;

import br.com.luan.mk1.APPLICATION.DTO.CustomerSearchDTO;
import br.com.luan.mk1.APPLICATION.DTO.SearchCarUnitDTO;
import br.com.luan.mk1.DOMAIN.PURCHASE.Purchase;

public interface PurchaseSearchByDTORepository {

	List<Purchase> searchByFilter(CustomerSearchDTO customerDTO, SearchCarUnitDTO carUnitDTO);
}
