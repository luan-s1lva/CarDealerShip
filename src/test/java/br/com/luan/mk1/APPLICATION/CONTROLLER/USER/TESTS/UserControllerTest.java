package br.com.luan.mk1.APPLICATION.CONTROLLER.USER.TESTS;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.luan.mk1.APPLICATION.CONTROLLER.USER.UserController;
import br.com.luan.mk1.DOMAIN.CUSTOMER.Customer;
import br.com.luan.mk1.DOMAIN.CUSTOMER.CustomerRepository;
import br.com.luan.mk1.DOMAIN.EMPLOYEE.Employee;
import br.com.luan.mk1.DOMAIN.EMPLOYEE.EmployeeRepository;
import br.com.luan.mk1.DOMAIN.ROLE.Role;
import br.com.luan.mk1.DOMAIN.ROLE.RoleRepository;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

	@Mock
	private PasswordEncoder passwordEncoder;
	
	@Mock
	private CustomerRepository customerRepo;
	
	@Mock
	private EmployeeRepository employeeRepo;
	
	@Mock
	private RoleRepository roleRepo;
	
	@InjectMocks
	private UserController userController;
	
	@Test
	void shouldReturnTrueIfEmailIsNotInUseByEmployeeOrCustomer() {
		String email = "luan@test.com";
		
		when(customerRepo.retrieveByEmail(email)).thenReturn(null);
		when(employeeRepo.findbyEmail(email)).thenReturn(null);
		
		boolean result = userController.isEmailNotInUse(email);
		
		assertTrue(result);
	}
	
	@Test
	void shouldReturnFalseIfAnyRepositoryContainsTheGivenEmail() {
		String email = "luan@test.com";
		
		when(customerRepo.retrieveByEmail(email)).thenReturn(new Customer());
		when(employeeRepo.findbyEmail(email)).thenReturn(null);
		
		boolean result = userController.isEmailNotInUse(email);
		
		assertFalse(result);
	}
	
	@Test
	void shouldReturnACustomer() {
		String role = "customer";
		String name = "Luan";
        String email = "luan@test.com";
        String password = "123";
        
        Customer expectedCustomer = new Customer();
        expectedCustomer.setName(name);
        expectedCustomer.setEmail(email);
        expectedCustomer.setPassword(password);  
        
        when(passwordEncoder.encode(password)).thenReturn(password);
        when(roleRepo.findByName(role)).thenReturn(new Role(Long.parseLong("1"),"Customer"));
        when(customerRepo.save(any(Customer.class))).thenReturn(expectedCustomer);
        
		Customer returnedCustomer = userController.storeCustomer(role, name, email, password);
		
		assertEquals(expectedCustomer.getName(), returnedCustomer.getName());
		assertEquals(expectedCustomer.getEmail(), returnedCustomer.getEmail());
		assertEquals(expectedCustomer.getPassword(), returnedCustomer.getPassword());
		
		ArgumentCaptor<Customer> captor = ArgumentCaptor.forClass(Customer.class);
		verify(customerRepo).save(captor.capture());
		
		Customer capturedCustomer = captor.getValue();
		
		assertEquals(expectedCustomer.getName(), capturedCustomer.getName());
		assertEquals(expectedCustomer.getEmail(), capturedCustomer.getEmail());
		assertEquals(expectedCustomer.getPassword(), capturedCustomer.getPassword());
	}
	
	@Test
	void shouldReturnAEmployee() {
		String role = "employee";
		String name = "empl";
		String email = "empl@test.com";
		String password = "123";
		
		Employee empl = new Employee(Long.parseLong("1"), new Role(Long.parseLong("1"), "Employee"), name, email, password);
		
		when(passwordEncoder.encode(password)).thenReturn(password);
		when(roleRepo.findByName(role)).thenReturn(new Role(Long.parseLong("1"), "Employee"));
		when(employeeRepo.save(any(Employee.class))).thenReturn(empl);
		
		Employee returnedEmployee = userController.storeEmployee(role, name, email, password);
		
		assertEquals(empl.getName(), returnedEmployee.getName());
		assertEquals(empl.getEmail(), returnedEmployee.getEmail());
		assertEquals(empl.getPassword(), returnedEmployee.getPassword());
		
		ArgumentCaptor<Employee> captor = ArgumentCaptor.forClass(Employee.class);
		
		verify(employeeRepo).save(captor.capture());
		
		Employee capturedEmployee = captor.getValue();
		
		assertEquals(empl.getName(), capturedEmployee.getName());
		assertEquals(empl.getEmail(), capturedEmployee.getEmail());
		assertEquals(empl.getPassword(), capturedEmployee.getPassword());
	}

}
