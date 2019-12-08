package ie.group23;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/css/**","/","/job/**","/h2/**").permitAll()
			.antMatchers("/newjob").hasRole("USER")
			.antMatchers("/actuator/**").hasRole("USER")
			.antMatchers("/console/**").permitAll()
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").permitAll()
			.defaultSuccessUrl("/", true)
			.usernameParameter("email")
		.and().exceptionHandling().accessDeniedPage("/403");
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	DataSource dataSource;

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("SELECT USERS.EMAIL, USERS.PASSWORD, USERS.USERENABLED FROM USERS WHERE USERS.EMAIL=?")
			.authoritiesByUsernameQuery("SELECT ROLE.EMAIL, ROLE.ROLEDESC, FROM ROLE WHERE ROLE.EMAIL=?");
	}

}
