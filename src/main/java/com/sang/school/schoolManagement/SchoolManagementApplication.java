package com.sang.school.schoolManagement;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.sang.school.schoolManagement.domain.Role;
import com.sang.school.schoolManagement.service.IRoleService;
import com.sang.school.schoolManagement.service.IUtilisateurService;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sang.school.schoolManagement.controller"})
public class SchoolManagementApplication {
	
	@Autowired
	IUtilisateurService iUtilisateurService;
	
	@Autowired
	 private IRoleService iRoleService;
	
	 MultipartFile file;

	
	public static void main(String[] args) {
		
		
		 
		SpringApplication.run(SchoolManagementApplication.class, args);
		
	} 
	
	
	
	/*
	 * @Bean public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	 * return args -> {
	 * 
	 * 
	 * if(iUtilisateurService.listeUtilisateur()!=null) {
	 * 
	 * iRoleService.enregistrerRole("_ADMIN");
	 * 
	 * Role role = iRoleService.rechercherRoleParLibelle("ROLE_ADMIN");
	 * 
	 * iUtilisateurService.enregistrerUtilisateurAvecPhoto("SANG", "ADAM" ,
	 * "sang00@gmail.com", "sang", file,Arrays.asList(role)); }
	 * 
	 * System.out.
	 * println("//////////////Let's inspect the beans provided by Spring Boot:");
	 * 
	 * 
	 * }; }
	 * 
	 */
	 
	
	 
	/*
	 * @Bean public ServletWebServerFactory servletContainer() { // Enable SSL
	 * Trafic TomcatServletWebServerFactory tomcat = new
	 * TomcatServletWebServerFactory() { protected void postProcessContext(Context
	 * context) { SecurityConstraint securityConstraint = new SecurityConstraint();
	 * securityConstraint.setUserConstraint("CONFIDENTIAL"); SecurityCollection
	 * collection = new SecurityCollection(); collection.addPattern("/*");
	 * securityConstraint.addCollection(collection);
	 * 
	 * } };
	 * 
	 * // Add HTTP to HTTPS redirect
	 * tomcat.addAdditionalTomcatConnectors(httpToHttpsRedirectConnector());
	 * 
	 * return tomcat; }
	 * 
	 * 
	 * We need to redirect from HTTP to HTTPS. Without SSL, this application used
	 * port 8082. With SSL it will use port 8443. So, any request for 8082 needs to
	 * be redirected to HTTPS on 8443.
	 * 
	 * private Connector httpToHttpsRedirectConnector() { Connector connector = new
	 * Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
	 * connector.setScheme("http"); connector.setPort(8081);
	 * connector.setSecure(false); connector.setRedirectPort(8443); return
	 * connector; }
	 */

}
