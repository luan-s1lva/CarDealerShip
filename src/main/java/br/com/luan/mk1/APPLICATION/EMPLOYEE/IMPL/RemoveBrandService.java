package br.com.luan.mk1.APPLICATION.EMPLOYEE.IMPL;

import org.springframework.stereotype.Service;

import br.com.luan.mk1.APPLICATION.EMPLOYEE.RemoveBrand;
import br.com.luan.mk1.DOMAIN.BRAND.BrandRepository;

@Service
public class RemoveBrandService implements RemoveBrand {

	private final BrandRepository brandRepo;

	public RemoveBrandService(BrandRepository brandRepo) {
		super();
		this.brandRepo = brandRepo;
	}

	@Override
	public void removeBrand(Long brandId) {
		brandRepo.remove(brandId);
	}
}
