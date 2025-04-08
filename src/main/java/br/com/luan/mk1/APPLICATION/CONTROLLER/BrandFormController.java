package br.com.luan.mk1.APPLICATION.CONTROLLER;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BrandFormController {

	@GetMapping("/form/brand/create")
	public String showFormCreate() {
		return "formInsertBrand";
	}
	
	@GetMapping("/form/brand/delete")
	public String showFormDelete() {
		return "formDeleteBrand";
	}
	
	@GetMapping("/form/brand/update")
	public String showFormUpdate() {
		return "formUpdateBrand";
	}
}
