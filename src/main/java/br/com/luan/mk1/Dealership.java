package br.com.luan.mk1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Dealership {
	public static void main(String[] args) {
        SpringApplication.run(Dealership.class, args);
    }

	@GetMapping("/home")
	public String hello() {
		return String.format("Hello Luan", null);
	}
}