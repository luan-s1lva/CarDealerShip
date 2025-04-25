package br.com.luan.mk1.INFRASTRUCTURE.CUSTOMER;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.luan.mk1.DOMAIN.CUSTOMER.Customer;
import br.com.luan.mk1.DOMAIN.CUSTOMER.CustomerRepository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{

	private final JpaCustomerRepository jpaCustomerRepo;

	public CustomerRepositoryImpl(JpaCustomerRepository jpaCustomerRepo) {
		this.jpaCustomerRepo = jpaCustomerRepo;
	}

	@Override
	public Customer save(Customer customer) {
		Customer cust = jpaCustomerRepo.save(customer);
		
		return cust;
	}

	@Override
	public boolean update(Customer customer) {
		Customer cust = jpaCustomerRepo.save(customer);
		
		if(cust != null) return true;
		else return false;
	}

	@Override
	public boolean remove(Long customerId) {
		jpaCustomerRepo.deleteById(customerId);
		Optional<Customer> cust = jpaCustomerRepo.findById(customerId);
		
		if (cust.isEmpty() == true) return true;
		else return false;
	}

	@Override
	public Customer retrieveById(Long customerId) {
		Customer customer = jpaCustomerRepo.findById(customerId).get();
		
		return customer;
	}

	@Override
	public Customer retrieveByEmail(String email) {
		return jpaCustomerRepo.findByEmail(email);
	}
}
