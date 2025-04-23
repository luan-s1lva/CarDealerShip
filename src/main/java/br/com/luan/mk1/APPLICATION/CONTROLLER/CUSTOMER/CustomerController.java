package br.com.luan.mk1.APPLICATION.CONTROLLER.CUSTOMER;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.luan.mk1.DOMAIN.CUSTOMER.Customer;
import br.com.luan.mk1.DOMAIN.CUSTOMER.CustomerRepository;

@RestController
public class CustomerController {

	private final PasswordEncoder passEncoder;
	private final CustomerRepository customerRepo;
	
	public CustomerController(PasswordEncoder passEncoder, CustomerRepository customerRepo) {
		super();
		this.passEncoder = passEncoder;
		this.customerRepo = customerRepo;
	}

	@PostMapping("/customer/store")
	public Customer store(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
		Customer customer = new Customer();
		
		customer.setName(name);
		customer.setEmail(email);
		customer.setPassword(passEncoder.encode(password));
		
		return customerRepo.save(customer);
	}
	
	@PutMapping("/customer/update")	
	public Customer update(@RequestParam String customerId, @RequestParam String name, @RequestParam String email, @RequestParam String password) {
		Customer customer = new Customer();
		
		customer.setId(Long.parseLong(customerId));
		customer.setName(name);
		customer.setEmail(email);
		customer.setPassword(passEncoder.encode(password));
		
		return customerRepo.save(customer);
	}
	
	@DeleteMapping("/customer/delete")
	public boolean delete(@RequestParam String customerId) {
		return customerRepo.remove(Long.parseLong(customerId));
	}
}
