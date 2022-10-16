package br.com.microservice.robo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.microservice.robo.dto.LogTransacionalDto;
import br.com.microservice.robo.service.logtransacional.EnviaLogTransacionalParaKafkaService;
import br.com.microservice.robo.service.logtransacional.ILogTransacionalService;

@Component
public class JobIntegracaoService implements IJobIntegracaoService {

	@Autowired
	EnviaLogTransacionalParaKafkaService logTransacionalService;

	@Autowired
	CadastraLogTransacionalService cadastraLogTransacionalService;

	@Scheduled(cron = "* * * ? * *")
	public void executaJob() {
		List<LogTransacionalDto> list = cadastraLogTransacionalService.cadastro();
		//logTransacionalService.enviaLogs(list);
		System.out.println("entrou no job");
	}

}
