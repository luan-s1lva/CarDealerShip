package br.com.luan.mk1.APPLICATION.CONTROLLER.HOME;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String homePage() {
		return "home/home";
	}
}
