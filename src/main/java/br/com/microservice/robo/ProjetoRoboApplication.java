package br.com.microservice.robo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

import br.com.microservice.robo.config.swagger.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients
@EnableWebMvc
@EnableSwagger2
public class ProjetoRoboApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoRoboApplication.class, args);
	}

}
