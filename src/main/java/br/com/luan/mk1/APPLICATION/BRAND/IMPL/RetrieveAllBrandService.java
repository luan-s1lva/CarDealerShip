package br.com.luan.mk1.APPLICATION.BRAND.IMPL;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.luan.mk1.APPLICATION.BRAND.RetrieveAllBrand;
import br.com.luan.mk1.DOMAIN.BRAND.Brand;
import br.com.luan.mk1.DOMAIN.BRAND.BrandRepository;

@Service
public class RetrieveAllBrandService implements RetrieveAllBrand{

	private final BrandRepository brandRepo;

	public RetrieveAllBrandService(BrandRepository brandRepo) {
		this.brandRepo = brandRepo;
	}

	@Override
	public List<Brand> retrieveAll() {
		return brandRepo.retrieveAll();
	}
	
	
}
