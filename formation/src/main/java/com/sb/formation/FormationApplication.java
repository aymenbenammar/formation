package com.sb.formation;

import com.sb.formation.entities.Authority;
import com.sb.formation.entities.Role;
import com.sb.formation.entities.Utilisateur;
import com.sb.formation.repository.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class FormationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormationApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UtilisateurRepository userRepository, PasswordEncoder passwordEncoder) {
		return (String... args) -> {
			userRepository.deleteAll();
			userRepository.saveAndFlush(Utilisateur.builder()
					.username("aymen")
					.password(passwordEncoder.encode("aymen"))
					.role(Role.builder().name("admin").authority(Authority.builder().permission("read.all").build()).build())
					.build());
		};
	}


}
