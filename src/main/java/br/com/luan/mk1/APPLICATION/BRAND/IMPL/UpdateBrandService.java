package br.com.luan.mk1.APPLICATION.BRAND.IMPL;

import org.springframework.stereotype.Service;

import br.com.luan.mk1.APPLICATION.BRAND.UpdateBrand;
import br.com.luan.mk1.DOMAIN.BRAND.Brand;
import br.com.luan.mk1.DOMAIN.BRAND.BrandRepository;

@Service
public class UpdateBrandService implements UpdateBrand {

	private final BrandRepository brandRepo;

	public UpdateBrandService(BrandRepository brandRepo) {
		this.brandRepo = brandRepo;
	}

	@Override
	public boolean updateBrand(Brand brand) {
		return brandRepo.update(brand);
	}
}
