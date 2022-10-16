package br.com.microservice.robo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.microservice.robo.service.logtransacional.LogTransacionalService;

@Component
public class JobIntegracaoService implements IJobIntegracaoService {

	
	@Autowired
	LogTransacionalService logTransacionalService;

	
	@Scheduled(cron = "* * * ? * *")
	public void executaJob() {
		
		
		
		logTransacionalService.cadastraLogTransacional();
		
		System.out.println("entrou no job");
		
	}
	


	
	
}
