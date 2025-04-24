package br.com.luan.mk1.DOMAIN.CUSTOMER;

public interface CustomerRepository {
	
	Customer save(Customer customer);
	
	boolean update(Customer customer);
	
	boolean remove(Long customerId);
	
	Customer retrieveById(Long customerId);
	
	Customer retrieveByEmail(String email);
}
