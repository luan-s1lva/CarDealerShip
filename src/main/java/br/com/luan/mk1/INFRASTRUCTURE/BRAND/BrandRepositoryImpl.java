package br.com.luan.mk1.INFRASTRUCTURE.BRAND;

import java.util.List;

import org.springframework.stereotype.Repository;
import br.com.luan.mk1.DOMAIN.BRAND.Brand;
import br.com.luan.mk1.DOMAIN.BRAND.BrandRepository;

@Repository
public class BrandRepositoryImpl implements BrandRepository{

	private final JpaBrandRepository jpaBrandRepo;
	
	public BrandRepositoryImpl(JpaBrandRepository jpaBrandRepo) {
		this.jpaBrandRepo = jpaBrandRepo;
	}

	@Override
	public List<Brand> retrieveAll() {
		return jpaBrandRepo.findAll();
	}

	@Override
	public List<Brand> findByName(String name) {
		return jpaBrandRepo.findByNameContainingIgnoreCase(name);
	}
	
	@Override
	public Brand save(Brand brand) {
		return jpaBrandRepo.save(brand);
	}

	@Override
	public boolean update(Brand brand) {
		Brand b = jpaBrandRepo.save(brand);
		
		if (b != null) return true;
		else return false;
	}

	@Override
	public void remove(Long brandId) {
		jpaBrandRepo.deleteById(brandId);
	}

	@Override
	public Brand findById(Long id) {
		return jpaBrandRepo.findById(id).get();
	}
}
