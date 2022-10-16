package br.com.alura.microservice.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProjetoRoboApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoRoboApplication.class, args);
	}

}
