package br.com.luan.mk1.INFRASTRUCTURE.ROLE;

import org.springframework.stereotype.Repository;

import br.com.luan.mk1.DOMAIN.ROLE.Role;
import br.com.luan.mk1.DOMAIN.ROLE.RoleRepository;

@Repository
public class RoleRepositoryImpl implements RoleRepository{

	private final JpaRoleRepository jpaRoleRepo;
	
	public RoleRepositoryImpl(JpaRoleRepository jpaRoleRepo) {
		super();
		this.jpaRoleRepo = jpaRoleRepo;
	}

	@Override
	public Role store(Role role) {
		return jpaRoleRepo.save(role);
	}

	@Override
	public long count() {
		return jpaRoleRepo.count();
	}

	@Override
	public Role findByName(String name) {
		return jpaRoleRepo.findByNameIgnoreCase(name);
	}

}
