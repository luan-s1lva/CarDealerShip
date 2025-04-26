package br.com.luan.mk1.DOMAIN.BRAND;

import java.util.List;

public interface BrandRepository {

	List<Brand> retrieveAll();
	
	List<Brand> findByName(String name);
	
	Brand findById(Long id);
	
	Brand save(Brand brand);
	
	boolean update(Brand brand);
	
	void remove(Long brandId);
}
