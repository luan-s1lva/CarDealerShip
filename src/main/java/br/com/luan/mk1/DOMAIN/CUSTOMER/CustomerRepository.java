package br.com.luan.mk1.DOMAIN.CUSTOMER;

import java.util.Optional;

public interface CustomerRepository {
	
	Customer save(Customer customer);
	
	boolean update(Customer customer);
	
	boolean remove(Long customerId);
	
	Optional<Customer> retrieveById(Long customerId);
	
	Customer retrieveByEmail(String email);
}
