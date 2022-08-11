package com.sang.school.schoolManagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.sang.school.schoolManagement.service.IUtilisateurService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private	IUtilisateurService utilisateurService;
	 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		
		auth.authenticationProvider(authenticationProvider());
		
		/*
		 * auth.inMemoryAuthentication()
		 * .withUser("sang").password(passwordEncoder().encode("sang12")).roles("ADMIN")
		 * .and()
		 * .withUser("ib").password(passwordEncoder().encode("ib12")).roles("USER")
		 * .and()
		 * .withUser("cheik").password(passwordEncoder().encode("c12")).roles("GERANT");
		 */
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub 
		
		   http.authorizeRequests() 
		  .antMatchers("/index.html").permitAll()
		  .antMatchers(
				  		"/js/**",
				  		"/css/**", 
				  		"/admin/assets/css/**",
				  		"/admin/assets/img/**",
				  		"/admin/assets/js/**",
				  		"/admin/assets/plugins/**",
				  		"/fontawesome/**"

				  		).permitAll()
				   .antMatchers("/admin/user/**").permitAll()
		  .antMatchers("/management/**").hasAnyRole("ELEVE","ADMIN")
		  .antMatchers("/admin/**").permitAll()
		  .antMatchers("/enseignant/**").hasRole("ENSEIGNANT")
		  
		  .anyRequest().authenticated()
		  
		  .and()
		  .formLogin().loginPage("/login").permitAll()
	
		  .and()
		  .logout().invalidateHttpSession(true).clearAuthentication(true)
		  .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		  .logoutSuccessUrl("/login?logout").permitAll();
		   
			/*
			 * .antMatchers("/profile/index").authenticated()
			 * .antMatchers("/admin/index").hasRole("ADMIN")
			 * .antMatchers("/management/index").hasAnyRole("ADMIN","GERANT")
			 * .antMatchers("api/public/test1").hasAnyRole("ADMIN")
			 * .antMatchers("api/public/test2").hasAnyRole("ADMIN") .and() .httpBasic();
			 */
		 
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider authent= new DaoAuthenticationProvider();
		 authent.setUserDetailsService(utilisateurService);
		 authent.setPasswordEncoder(bCryptPasswordEncoder());
		 
		return authent;
		 
	}
	
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
 
