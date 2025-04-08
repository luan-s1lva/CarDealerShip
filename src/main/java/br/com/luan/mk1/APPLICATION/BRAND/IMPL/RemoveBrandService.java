package br.com.luan.mk1.APPLICATION.BRAND.IMPL;

import org.springframework.stereotype.Service;

import br.com.luan.mk1.APPLICATION.BRAND.RemoveBrand;
import br.com.luan.mk1.DOMAIN.BRAND.BrandRepository;

@Service
public class RemoveBrandService implements RemoveBrand{
	
	private final BrandRepository brandRepo;

	public RemoveBrandService(BrandRepository brandRepo) {
		this.brandRepo = brandRepo;
	}

	@Override
	public boolean removeBrand(Long brandId) {
		return brandRepo.remove(brandId);
	}
}
