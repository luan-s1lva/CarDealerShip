package br.com.luan.mk1.APPLICATION.CONTROLLER.CARUNIT;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarUnitFormController {

	@GetMapping("/form/carUnit/create")
	public String showFormCreate() {
		return "carUnit/formInsertCarUnit";
	}
	
	@GetMapping("/form/carUnit/delete")
	public String showFormDelete() {
		return "carUnit/formDeleteCarUnit";
	}
	
	@GetMapping("/form/carUnit/update")
	public String showFormUpdate() {
		return "carUnit/formUpdateCarUnit";
	}
}
