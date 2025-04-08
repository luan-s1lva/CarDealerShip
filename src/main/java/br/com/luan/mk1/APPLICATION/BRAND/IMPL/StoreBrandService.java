package br.com.luan.mk1.APPLICATION.BRAND.IMPL;

import org.springframework.stereotype.Service;

import br.com.luan.mk1.APPLICATION.BRAND.StoreBrand;
import br.com.luan.mk1.DOMAIN.BRAND.Brand;
import br.com.luan.mk1.DOMAIN.BRAND.BrandRepository;

@Service
public class StoreBrandService implements StoreBrand{

	private final BrandRepository brandRepo;

	public StoreBrandService(BrandRepository brandRepo) {
		this.brandRepo = brandRepo;
	}

	@Override
	public Brand storeBrand(Brand brand) {
		return brandRepo.save(brand);
	}
}
