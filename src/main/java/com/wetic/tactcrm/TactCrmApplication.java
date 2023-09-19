package com.wetic.tactcrm;

import com.wetic.tactcrm.config.YAMLConfig;
import com.wetic.tactcrm.domain.Utilisateur;
import com.wetic.tactcrm.service.UtilisateurService;
import com.wetic.tactcrm.service.dto.UtilisateurDTO;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.core.env.Environment;

import java.io.PrintStream;
import java.util.Optional;

@SpringBootApplication
@EnableConfigurationProperties({ LiquibaseProperties.class })
public class TactCrmApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	private YAMLConfig yamlConfig;

	@Autowired
	private UtilisateurService utilisateurService;

	public static void main(String[] args) {
//		SpringApplication.run(TactCrmApplication.class, args);
		SpringApplication application = new SpringApplication(TactCrmApplication.class);
		application.run();
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("using environment: " + yamlConfig.getEnvironment());
		System.out.println("name: " + yamlConfig.getName());
		System.out.println("servers: " + yamlConfig.getServers());
		
		Optional<Utilisateur> user = utilisateurService.findByLogin("admin");
		
		if (!user.isPresent()) {
			System.out.println("creating test user");
			UtilisateurDTO userDto = new UtilisateurDTO();
			userDto.setNom("admin");
			userDto.setPrenom("admin");
			userDto.setLogin("admin");
			userDto.setPassword("123aze");
			userDto.setEmail("admin@gmail.com");
			userDto.setTelephone("+336631546542");
			userDto.setAdmin(true);
			//save
			UtilisateurDTO output =  utilisateurService.save(userDto);
		}
	}
}
