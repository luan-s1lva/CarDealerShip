package br.com.luan.mk1.INFRASTRUCTURE.EMPLOYEE;

import org.springframework.stereotype.Repository;

import br.com.luan.mk1.DOMAIN.EMPLOYEE.Employee;
import br.com.luan.mk1.DOMAIN.EMPLOYEE.EmployeeRepository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{

	private final JpaEmployeeRepository jpaEmployeeRepo;

	public EmployeeRepositoryImpl(JpaEmployeeRepository jpaEmployeeRepo) {
		super();
		this.jpaEmployeeRepo = jpaEmployeeRepo;
	}

	@Override
	public Employee findbyEmail(String email) {
		return jpaEmployeeRepo.findByEmailIgnoreCase(email);
	}

	@Override
	public Employee findbyId(Long id) {
		return jpaEmployeeRepo.findById(id).get();
	}

	@Override
	public Employee save(Employee employee) {
		return jpaEmployeeRepo.save(employee);
	}

	@Override
	public boolean update(Employee employee) {
		Employee emp = jpaEmployeeRepo.save(employee);
		
		if (emp != null) return true;
		else return false;
	}

	@Override
	public void remove(Long id) {
		jpaEmployeeRepo.deleteById(id);
	}
}
