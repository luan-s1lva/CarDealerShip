package br.com.luan.mk1.APPLICATION.CONTROLLER.PURCHASE;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnit;
import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnitRepository;
import br.com.luan.mk1.DOMAIN.CUSTOMER.Customer;
import br.com.luan.mk1.DOMAIN.CUSTOMER.CustomerRepository;
import br.com.luan.mk1.DOMAIN.PURCHASE.Purchase;
import br.com.luan.mk1.DOMAIN.PURCHASE.PurchaseRepository;


@RestController
public class PurchaseController {

	private final PurchaseRepository purchaseRepo;
	private final CustomerRepository customerRepo;
	private final CarUnitRepository carUnitRepo;
	
	public PurchaseController(PurchaseRepository purchaseRepo, CustomerRepository customerRepo,
			CarUnitRepository carUnitRepo) {
		super();
		this.purchaseRepo = purchaseRepo;
		this.customerRepo = customerRepo;
		this.carUnitRepo = carUnitRepo;
	}
	
	@GetMapping("/purchases")
	public List<Purchase> retrieveAll() {
		return purchaseRepo.returnAll();
	}

	@PostMapping("/purchase/store")
	public Purchase store(@RequestParam String customerId, @RequestParam String carUnitId) {
		Customer customer = customerRepo.retrieveById(Long.parseLong(customerId));
		CarUnit carUnit = carUnitRepo.retrieveById(Long.parseLong(carUnitId));

		Purchase purchase = new Purchase(carUnit, customer, new Date());
		
		Purchase novaPurchase = purchaseRepo.save(purchase);
		if (novaPurchase != null) {
			carUnit.setStatus(false);
			
			return novaPurchase;
		} else {
			return new Purchase();
		}
	}
	
	@DeleteMapping("/purchase/delete")
	public void delete(@RequestParam String purchaseId) {
		purchaseRepo.remove(Long.parseLong(purchaseId));
	}
}






