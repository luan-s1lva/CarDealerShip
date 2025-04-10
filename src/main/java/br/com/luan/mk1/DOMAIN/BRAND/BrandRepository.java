package br.com.luan.mk1.DOMAIN.BRAND;

import java.util.List;
import java.util.Optional;

public interface BrandRepository {

	List<Brand> retrieveAll();
	
	List<Brand> findByName(String name);
	
	Optional<Brand> findById(Long id);
	
	Brand save(Brand brand);
	
	boolean update(Brand brand);
	
	boolean remove(Long brandId);
}
