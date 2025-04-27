package br.com.luan.mk1.INFRASTRUCTURE.SECURITY;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import br.com.luan.mk1.APPLICATION.USER.GetUserInfoService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http, GetUserInfoService authService) throws Exception {
		http
			.csrf(csrf ->
				csrf.csrfTokenRepository(new HttpSessionCsrfTokenRepository())
			)
			.authorizeHttpRequests(auth ->
				auth.requestMatchers(
						"/css/**", 
						"/js/**", 
						"/images/**", 
						"/login",
						"/logout",
						"/form/user/create",
						"/user/store"
						)
				.permitAll()
				.requestMatchers(
						"/form/brand/create",
						"/form/brand/update",
						"/form/brand/delete",
						"/brand/store",
						"/brand/update",
						"/brand/delete",
						"/carModel/store",
						"/carModel/update",
						"/carModel/delete",
						"/form/carModel/create",
						"/form/carModel/update",
						"/form/carModel/delete",
						"/carUnit/store",
						"/carUnit/update",
						"/carUnit/delete",
						"/form/carUnit/create",
						"/form/carUnit/update",
						"/form/carUnit/delete",
						"/purchases"
						).hasAuthority("Employee")
				.requestMatchers(
						"/purchase/store",
						"/purchase/delete",
						"/form/purchase/create",
						"/form/purchase/delete"
						).hasAuthority("Customer")
				.requestMatchers(
						"/form/logout",
						"/home",
						"/brands",
						"/carModel",
						"/carUnit",
						"/user/update",
						"/user/delete",
						"/form/user/update",
						"/form/user/delete"
						).hasAnyAuthority("Employee","Customer")
			)
			.userDetailsService(authService)
			.formLogin(form ->
					form.loginPage("/login")
					.defaultSuccessUrl("/home", true)
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
	
//	@Bean
//	GetUserInfoService authenticateCustomerService(CustomerRepository customerRepo, EmployeeRepository employeeRepo) {
//		return new GetUserInfoService(customerRepo, employeeRepo);
//	}
}
