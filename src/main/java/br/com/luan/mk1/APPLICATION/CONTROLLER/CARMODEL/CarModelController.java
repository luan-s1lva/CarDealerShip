package br.com.luan.mk1.APPLICATION.CONTROLLER.CARMODEL;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.luan.mk1.DOMAIN.BRAND.Brand;
import br.com.luan.mk1.DOMAIN.BRAND.BrandRepository;
import br.com.luan.mk1.DOMAIN.CARMODEL.CarModel;
import br.com.luan.mk1.DOMAIN.CARMODEL.CarModelRepository;

@RestController
public class CarModelController {

	private final CarModelRepository carModelRepo;
	private final BrandRepository brandRepo;
	
	public CarModelController(CarModelRepository carModelRepo, BrandRepository brandRepo) {
		this.carModelRepo = carModelRepo;
		this.brandRepo = brandRepo;
	}

	@GetMapping("/carModel")
	public List<CarModel> getAllModels() {
		return carModelRepo.retrieveAll();
	}
	
	@PostMapping("/carModel/store")
	public CarModel create(@RequestParam String brandName, @RequestParam String name, @RequestParam String type) {
		List<Brand> brands = brandRepo.findByName(brandName);
		
		if (brands.size() == 1) {
			Brand b = brands.getFirst();
			CarModel c = new CarModel();
			
			c.setBrand(b);
			c.setName(name);
			c.setType(type);
			
			return carModelRepo.save(c);
		}
		
		CarModel c = new CarModel();
		return c;
    }
	
	@DeleteMapping("/carModel/delete")
	public boolean delete(@RequestParam Long modelId) {
		return carModelRepo.remove(modelId);
	}

	@PutMapping("carModel/update")
	public boolean update(@RequestParam Long brandId, @RequestParam Long modelId, @RequestParam String name, @RequestParam String type) {
		Optional<Brand> brand = brandRepo.findById(brandId);
		
		if (brand.isPresent() == true) {
			Brand b = brand.get();
			
			CarModel c = new CarModel(modelId,b, name, type);
			
			CarModel carModel = carModelRepo.update(c);
			
			if (carModel != null) return true;
			else return false;
		} else {
			return false;
		}
		
	}
}
