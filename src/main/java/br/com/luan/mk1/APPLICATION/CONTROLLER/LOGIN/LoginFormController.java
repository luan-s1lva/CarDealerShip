package br.com.luan.mk1.APPLICATION.CONTROLLER.LOGIN;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginFormController {

	@GetMapping("/login")
	public String showLoginForm() {
		return "login/login";
	}
}
