package br.com.luan.mk1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
@RestController
public class Dealership {
	public static void main(String[] args) {
        SpringApplication.run(Dealership.class, args);
    }
	
	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
	    return new HiddenHttpMethodFilter();
	}

}