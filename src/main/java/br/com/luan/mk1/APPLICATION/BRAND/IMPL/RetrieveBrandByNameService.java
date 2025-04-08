package br.com.luan.mk1.APPLICATION.BRAND.IMPL;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.luan.mk1.APPLICATION.BRAND.RetrieveBrandByName;
import br.com.luan.mk1.DOMAIN.BRAND.Brand;
import br.com.luan.mk1.DOMAIN.BRAND.BrandRepository;

@Service
public class RetrieveBrandByNameService implements RetrieveBrandByName {

	private final BrandRepository brandRepo;

	public RetrieveBrandByNameService(BrandRepository brandRepo) {
		this.brandRepo = brandRepo;
	}

	@Override
	public List<Brand> retrieveByName(String name) {
		return brandRepo.findByName(name);
	}
}
