package br.com.luan.mk1.DOMAIN.EMPLOYEE;

public interface EmployeeRepository {

	Employee findbyEmail(String email);
	
	Employee findbyId(Long id);
	
	Employee save(Employee employee);
	
	boolean update(Employee employee);
	
	void remove(Long id);
}
