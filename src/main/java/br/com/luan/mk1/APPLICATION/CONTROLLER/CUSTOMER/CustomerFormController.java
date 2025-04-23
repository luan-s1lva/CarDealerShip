package br.com.luan.mk1.APPLICATION.CONTROLLER.CUSTOMER;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerFormController {

	@GetMapping("/form/customer/create")
	public String showFormCreate() {
		return "customer/formInsertCustomer";
	}
	
	@GetMapping("/form/customer/delete")
	public String showFormDelete() {
		return "customer/formDeleteCustomer";
	}
	
	@GetMapping("/form/customer/update")
	public String showFormUpdate() {
		return "customer/formUpdateCustomer";
	}
	
	@GetMapping("/form/logout")
	public String logout() {
		return "logout/logout";
	}
}
