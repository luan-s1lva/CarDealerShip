package br.com.luan.mk1.INFRASTRUCTURE.ROLE;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.luan.mk1.DOMAIN.ROLE.Role;

public interface JpaRoleRepository extends JpaRepository<Role, Long>{
	Role findByNameIgnoreCase(String name);
}
