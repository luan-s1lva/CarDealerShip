package br.com.luan.mk1.APPLICATION.CONTROLLER.BRAND;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.luan.mk1.DOMAIN.BRAND.Brand;
import br.com.luan.mk1.DOMAIN.BRAND.BrandRepository;

@RestController
public class BrandController {

	private final BrandRepository brandRepo;

	public BrandController(BrandRepository brandRepo) {
		this.brandRepo = brandRepo;
	}

	@GetMapping("/brands")
	public List<Brand> getAllBrands() {
		return brandRepo.retrieveAll();
	}
	
	@PostMapping("/brand/store")
	public Brand create(Brand brand) {
        Brand saved = brandRepo.save(brand);
        
        return saved;
    }
	
	@PostMapping("/brand/delete")
	public void delete(Long brandId) {
		brandRepo.remove(brandId);
	}

	@PutMapping("brand/update")
	public boolean update(@RequestParam Long brandId, @RequestParam String name) {
		Brand b = brandRepo.findById(brandId);
		
		b.setName(name);
		
		return brandRepo.update(b);
	}
}
