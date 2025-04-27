package br.com.luan.mk1.CONFIG;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.luan.mk1.DOMAIN.ROLE.Role;
import br.com.luan.mk1.DOMAIN.ROLE.RoleRepository;
import jakarta.transaction.Transactional;

@Component
public class RoleDataInitializer implements CommandLineRunner{

	private final RoleRepository roleRepo;
	
	public RoleDataInitializer(RoleRepository roleRepo) {
		super();
		this.roleRepo = roleRepo;
	}
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		if (roleRepo.count() == 0) {
			Role employee = new Role(null, "Employee");
			Role customer = new Role(null, "Customer");
			
			roleRepo.store(customer);
			roleRepo.store(employee);
		}
		
	}

}
