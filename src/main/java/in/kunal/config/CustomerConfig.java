package in.kunal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import in.kunal.Service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class CustomerConfig {

	@Autowired
	private MyUserDetailsService userDtl;

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain chain(HttpSecurity http) throws Exception {
		return http.csrf().disable().authorizeRequests().anyRequest().permitAll().and().build();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() throws Exception {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setPasswordEncoder(encoder());
		authenticationProvider.setUserDetailsService(userDtl);
		return authenticationProvider;
	}
     
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
}
