package br.com.luan.mk1.DOMAIN.ROLE;

public interface RoleRepository {

	Role store(Role role);
	
	long count();
	
	Role findByName(String name);
}
