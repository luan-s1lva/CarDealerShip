package br.com.luan.mk1.APPLICATION.CUSTOMER;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.luan.mk1.DOMAIN.CUSTOMER.Customer;
import br.com.luan.mk1.DOMAIN.CUSTOMER.CustomerRepository;
import br.com.luan.mk1.DOMAIN.EMPLOYEE.Employee;
import br.com.luan.mk1.DOMAIN.EMPLOYEE.EmployeeRepository;

@Service
public class AuthenticateCustomerService implements UserDetailsService{

	private final CustomerRepository customerRepo;
	private final EmployeeRepository employeeRepo;
	
	public AuthenticateCustomerService(CustomerRepository customerRepo, EmployeeRepository employeeRepo) {
		super();
		this.customerRepo = customerRepo;
		this.employeeRepo = employeeRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (customerRepo.retrieveByEmail(username) != null) {
			Customer customer = customerRepo.retrieveByEmail(username);
			
			return org.springframework.security.core.userdetails.User
					.withUsername(customer.getEmail())
					.password(customer.getPassword())
					.build();
		} else if (employeeRepo.findbyEmail(username) != null) {
			Employee empl = employeeRepo.findbyEmail(username);
			
			return org.springframework.security.core.userdetails.User
					.withUsername(empl.getEmail())
					.password(empl.getPassword())
					.build();
		}
		
		throw new UsernameNotFoundException("User not found with email: " + username);
	}

}
