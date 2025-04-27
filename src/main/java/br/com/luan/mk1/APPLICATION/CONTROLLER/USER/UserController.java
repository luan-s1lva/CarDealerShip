package br.com.luan.mk1.APPLICATION.CONTROLLER.USER;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.luan.mk1.DOMAIN.CUSTOMER.Customer;
import br.com.luan.mk1.DOMAIN.CUSTOMER.CustomerRepository;
import br.com.luan.mk1.DOMAIN.EMPLOYEE.Employee;
import br.com.luan.mk1.DOMAIN.EMPLOYEE.EmployeeRepository;
import br.com.luan.mk1.DOMAIN.ROLE.RoleRepository;

@RestController
public class UserController {

	private final PasswordEncoder passEncoder;
	private final CustomerRepository customerRepo;
	private final EmployeeRepository employeeRepo;
	private final RoleRepository roleRepo;

	public UserController(PasswordEncoder passEncoder, CustomerRepository customerRepo, EmployeeRepository employeeRepo,
			RoleRepository roleRepo) {
		super();
		this.passEncoder = passEncoder;
		this.customerRepo = customerRepo;
		this.employeeRepo = employeeRepo;
		this.roleRepo = roleRepo;
	}
	
	public boolean isEmailNotInUse(String email) {
		Customer customer = customerRepo.retrieveByEmail(email);
		Employee empl = employeeRepo.findbyEmail(email);
		
		if (empl == null && customer == null) return true;
		else return false;
	}

	@PostMapping("/user/store")
	public void store(@RequestParam String role, @RequestParam String name, @RequestParam String email, @RequestParam String password) {
		if (isEmailNotInUse(email)) {
			if (role.equalsIgnoreCase("customer")) {
				storeCustomer(role, name, email, password);
			} else if (role.equalsIgnoreCase("employee")) {
				storeEmployee(role, name, email, password);
			}
		} else {
			throw new DuplicateKeyException("Email já está em uso");
		}
	}
	
	public Customer storeCustomer(String role, String name, String email, String password) {
		Customer customer = new Customer();
		
		customer.setName(name);
		customer.setEmail(email);
		customer.setPassword(passEncoder.encode(password));
		customer.setRole(roleRepo.findByName(role));
		
		return customerRepo.save(customer);
	}
	
	public Employee storeEmployee(String role, String name, String email, String password) {
		Employee employee = new Employee();
		
		employee.setName(name);
		employee.setEmail(email);
		employee.setPassword(passEncoder.encode(password));
		employee.setRole(roleRepo.findByName(role));
		
		return employeeRepo.save(employee);
	}
	
	@PutMapping("/user/update")	
	public void update(@RequestParam String role, @RequestParam String userId, @RequestParam String name, @RequestParam String email, @RequestParam String password) {
		if (role.equalsIgnoreCase("customer")) {
			updateCustomer(role, userId, name, email, password);
		} else if (role.equalsIgnoreCase("employee")) {
			updateEmployee(role, userId, name, email, password);
		}
	}
	
	public Employee updateEmployee(String role, String userId, String name, String email, String password) {
		Employee empl = employeeRepo.findbyId(Long.parseLong(userId));
		
		if (empl != null) {
			empl.setName(name);
			empl.setEmail(email);
			empl.setPassword(passEncoder.encode(password));
			
			return employeeRepo.save(empl);			
		} else {
			throw new RuntimeException("Empregado não encontrado");
		}
	}
	
	public Customer updateCustomer(String role, String userId, String name, String email, String password) {
		Customer customer = customerRepo.retrieveById(Long.parseLong(userId));
		
		if (customer != null) {
			customer.setName(name);
			customer.setEmail(email);
			customer.setPassword(passEncoder.encode(password));
			
			return customerRepo.save(customer);			
		} else {
			throw new RuntimeException("Cliente não encontrado");
		}
		
	}

	@DeleteMapping("/user/delete")
	public void delete(@RequestParam String role, @RequestParam String userId) {
		if (role.equalsIgnoreCase("customer")) {
			customerRepo.remove(Long.parseLong(userId));
		}
		
		if (role.equalsIgnoreCase("employee")) {
			employeeRepo.remove(Long.parseLong(userId));
		}
	}
}
