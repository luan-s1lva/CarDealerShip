package br.com.luan.mk1.APPLICATION.PURCHASE;

import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnit;
import br.com.luan.mk1.DOMAIN.CUSTOMER.Customer;
import br.com.luan.mk1.DOMAIN.PURCHASE.Purchase;

public interface BuyCarUnit {

	Purchase buy(CarUnit carUnit, Customer customer);
}
