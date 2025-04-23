package br.com.luan.mk1.CONFIG;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import br.com.luan.mk1.APPLICATION.CUSTOMER.AuthenticateCustomerService;
import br.com.luan.mk1.DOMAIN.CUSTOMER.CustomerRepository;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticateCustomerService authService) throws Exception {
		http
			.csrf(csrf ->
				csrf.csrfTokenRepository(new HttpSessionCsrfTokenRepository())
			)
			.authorizeHttpRequests(auth ->
				auth.requestMatchers("/css/**", 
						"/js/**", 
						"/images/**", 
						"/login",
						"/logout",
						"/form/customer/create",
						"/customer/store")
				.permitAll()
				.anyRequest().authenticated()
			)
			.userDetailsService(authService)
			.formLogin(form ->
					form.loginPage("/login")
					.defaultSuccessUrl("/brands", true)
	                .failureUrl("/login?error")
					.permitAll()
			)
			.logout(logout ->
					logout.logoutUrl("/logout")
					.logoutSuccessUrl("/login?logout")
			        .invalidateHttpSession(true)      
			        .deleteCookies("JSESSIONID")
					.permitAll()
			);
		
		return http.build();
	}
	
	@Bean
	public AuthenticateCustomerService authenticateCustomerService(CustomerRepository repo) {
		return new AuthenticateCustomerService(repo);
	}
}
