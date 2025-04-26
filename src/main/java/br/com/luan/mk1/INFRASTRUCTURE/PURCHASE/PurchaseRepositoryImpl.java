package br.com.luan.mk1.INFRASTRUCTURE.PURCHASE;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.luan.mk1.APPLICATION.DTO.CustomerSearchDTO;
import br.com.luan.mk1.APPLICATION.DTO.SearchCarUnitDTO;
import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnit;
import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnitRepository;
import br.com.luan.mk1.DOMAIN.CUSTOMER.Customer;
import br.com.luan.mk1.DOMAIN.CUSTOMER.CustomerRepository;
import br.com.luan.mk1.DOMAIN.PURCHASE.Purchase;
import br.com.luan.mk1.DOMAIN.PURCHASE.PurchaseRepository;

@Repository
public class PurchaseRepositoryImpl implements PurchaseRepository{

	private final JpaPurchaseRepository jpaPurchaseRepo;
	private final CarUnitRepository carUnitRepo;
	private final CustomerRepository customerRepo;

	public PurchaseRepositoryImpl(JpaPurchaseRepository jpaPurchaseRepo, CarUnitRepository carUnitRepo,
			CustomerRepository customerRepo) {
		super();
		this.jpaPurchaseRepo = jpaPurchaseRepo;
		this.carUnitRepo = carUnitRepo;
		this.customerRepo = customerRepo;
	}

	@Override
	public Purchase save(Purchase purchase) {
		Customer customer = customerRepo.retrieveById(purchase.getCustomer().getId());

		CarUnit carUnit = carUnitRepo.retrieveById(purchase.getCarUnit().getId());
		
		purchase.setCustomer(customer);
		purchase.setCarUnit(carUnit);

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

	@Override
	public void remove(Long purchaseId) {
		jpaPurchaseRepo.deleteById(purchaseId);
	}

}
