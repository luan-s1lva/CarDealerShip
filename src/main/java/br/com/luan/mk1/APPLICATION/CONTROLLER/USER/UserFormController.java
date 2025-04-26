package br.com.luan.mk1.APPLICATION.CONTROLLER.USER;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserFormController {

	@GetMapping("/form/user/create")
	public String showFormCreate() {
		return "user/formInsertUser";
	}
	
	@GetMapping("/form/user/delete")
	public String showFormDelete() {
		return "user/formDeleteUser";
	}
	
	@GetMapping("/form/user/update")
	public String showFormUpdate() {
		return "user/formUpdateUser";
	}
	
	@GetMapping("/form/logout")
	public String logout() {
		return "logout/logout";
	}
}
