package br.com.luan.mk1.APPLICATION.BRAND;

import java.util.List;

import br.com.luan.mk1.DOMAIN.BRAND.Brand;

public interface RetrieveBrandByName {
	List<Brand>	retrieveByName(String name);
}
