package br.com.luan.mk1.APPLICATION.CUSTOMER;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.luan.mk1.DOMAIN.CUSTOMER.Customer;
import br.com.luan.mk1.DOMAIN.CUSTOMER.CustomerRepository;

@Service
public class AuthenticateCustomerService implements UserDetailsService{

	private final CustomerRepository customerRepo;
	
	public AuthenticateCustomerService(CustomerRepository customerRepo) {
		super();
		this.customerRepo = customerRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer = customerRepo.retrieveByEmail(username);
		
		return org.springframework.security.core.userdetails.User
				.withUsername(customer.getEmail())
				.password(customer.getPassword())
				.build();
	}

}
