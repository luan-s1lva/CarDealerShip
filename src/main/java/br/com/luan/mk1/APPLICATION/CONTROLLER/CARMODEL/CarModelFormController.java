package br.com.luan.mk1.APPLICATION.CONTROLLER.CARMODEL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarModelFormController {

	@GetMapping("/form/carModel/create")
	public String showFormCreate() {
		return "carModel/formInsertCarModel";
	}
	
	@GetMapping("/form/carModel/delete")
	public String showFormDelete() {
		return "carModel/formDeleteCarModel";
	}
	
	@GetMapping("/form/carModel/update")
	public String showFormUpdate() {
		return "carModel/formUpdateCarModel";
	}
}
