package br.com.luan.mk1.INFRASTRUCTURE.CUSTOMER;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.luan.mk1.DOMAIN.CUSTOMER.Customer;

public interface JpaCustomerRepository extends JpaRepository<Customer, Long>{

	Customer findByEmail(String email);
}
