package br.com.luan.mk1.INFRASTRUCTURE.BRAND;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.luan.mk1.DOMAIN.BRAND.Brand;

public interface JpaBrandRepository extends JpaRepository<Brand, Long>{
	List<Brand> findByNameContainingIgnoreCase(String name);
}
