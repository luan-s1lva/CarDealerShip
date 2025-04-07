package br.com.luan.mk1.INFRASTRUCTURE.PURCHASE;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.luan.mk1.APPLICATION.DTO.CustomerSearchDTO;
import br.com.luan.mk1.APPLICATION.DTO.SearchCarUnitDTO;
import br.com.luan.mk1.DOMAIN.PURCHASE.Purchase;
import br.com.luan.mk1.DOMAIN.PURCHASE.PurchaseRepository;

@Repository
public class PurchaseRepositoryImpl implements PurchaseRepository{

	private final JpaPurchaseRepository jpaPurchaseRepo;

	public PurchaseRepositoryImpl(JpaPurchaseRepository jpaPurchaseRepo) {
		this.jpaPurchaseRepo = jpaPurchaseRepo;
	}

	@Override
	public Purchase save(Purchase purchase) {
		Purchase purch = jpaPurchaseRepo.save(purchase);
		
		return purch;
	}

	@Override
	public List<Purchase> returnAll() {
		List<Purchase> purch = jpaPurchaseRepo.findAll();
		
		return purch;
	}

	@Override
	public List<Purchase> returnByFilter(CustomerSearchDTO customerDTO, SearchCarUnitDTO carUnitDTO) {
		List<Purchase> purch = jpaPurchaseRepo.searchByFilter(customerDTO, carUnitDTO);
		
		return purch;
	}

}
