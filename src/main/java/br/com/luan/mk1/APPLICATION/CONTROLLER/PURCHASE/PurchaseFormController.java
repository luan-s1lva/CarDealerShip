package br.com.luan.mk1.APPLICATION.CONTROLLER.PURCHASE;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PurchaseFormController {

	@GetMapping("/form/purchase/create")
	public String showFormCreate() {
		return "purchase/purchase";
	}
}
