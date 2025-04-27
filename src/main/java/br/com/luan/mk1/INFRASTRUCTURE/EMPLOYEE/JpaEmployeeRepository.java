package br.com.luan.mk1.INFRASTRUCTURE.EMPLOYEE;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.luan.mk1.DOMAIN.EMPLOYEE.Employee;

public interface JpaEmployeeRepository extends JpaRepository<Employee, Long>{
	Employee findByEmailIgnoreCase(String email);
}
