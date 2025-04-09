package br.com.luan.mk1.APPLICATION.CONTROLLER.BRAND;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BrandFormController {

	@GetMapping("/form/brand/create")
	public String showFormCreate() {
		return "brand/formInsertBrand";
	}
	
	@GetMapping("/form/brand/delete")
	public String showFormDelete() {
		return "brand/formDeleteBrand";
	}
	
	@GetMapping("/form/brand/update")
	public String showFormUpdate() {
		return "brand/formUpdateBrand";
	}
}
