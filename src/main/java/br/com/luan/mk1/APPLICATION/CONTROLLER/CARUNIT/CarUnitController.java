package br.com.luan.mk1.APPLICATION.CONTROLLER.CARUNIT;

import org.springframework.web.bind.annotation.RestController;

import br.com.luan.mk1.APPLICATION.DTO.SearchCarUnitDTO;
import br.com.luan.mk1.DOMAIN.CARMODEL.CarModel;
import br.com.luan.mk1.DOMAIN.CARMODEL.CarModelRepository;
import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnit;
import br.com.luan.mk1.DOMAIN.CARUNIT.CarUnitRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class CarUnitController {

	private final CarUnitRepository carUnitRepo;
	private final CarModelRepository carModelRepo;
	
	public CarUnitController(CarUnitRepository carUnitRepo, CarModelRepository carModelRepo) {
		this.carUnitRepo = carUnitRepo;
		this.carModelRepo = carModelRepo;
	}

	@GetMapping("/carUnit")
	public List<CarUnit> retrieveAll() {
		return carUnitRepo.retrieveAll();
	}
	
	@GetMapping("/carUnit/{id}")
	public List<CarUnit> retrieveByDTO(SearchCarUnitDTO unitDTO) {
		return carUnitRepo.retrieveByFilter(unitDTO);
	}
	
	@PostMapping("/carUnit/store")
	public CarUnit store(@RequestParam String modelId, @RequestParam String price, @RequestParam String color, @RequestParam String year) {
		Optional<CarModel> model = carModelRepo.retrieveById(Long.parseLong(modelId));
		
		CarUnit carUnit = new CarUnit();
		
		carUnit.setColor(color);
		carUnit.setPrice(Double.parseDouble(price));
		carUnit.setCarModel(model.get());
		carUnit.setStatus(true);
		carUnit.setYear(Integer.parseInt(year));
		
		carUnitRepo.save(carUnit);
		
		return carUnit;
	}
	
	@PutMapping("/carUnit/update")
	public boolean update(@RequestParam String modelId, @RequestParam String unitId, @RequestParam String price, @RequestParam String color, @RequestParam String year, @RequestParam String status) {		
		Optional<CarModel> model = carModelRepo.retrieveById(Long.parseLong(modelId));
		
		CarUnit carUnit = new CarUnit();
		
		carUnit.setId(Long.parseLong(unitId));
		carUnit.setColor(color);
		carUnit.setPrice(Double.parseDouble(price));
		carUnit.setCarModel(model.get());
		carUnit.setStatus(Boolean.parseBoolean(status));
		carUnit.setYear(Integer.parseInt(year));
		
		return carUnitRepo.update(carUnit);
	}
	
	@DeleteMapping("/carUnit/delete")
	public boolean delete(@RequestParam String unitId) {		
		return carUnitRepo.remove(Long.parseLong(unitId));
	}
}
