package br.com.microservice.robo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.microservice.robo.dto.LogTransacionalDto;
import br.com.microservice.robo.service.transacional.EnvioLogTransacionalParaKafkaService;
import br.com.microservice.robo.service.transacional.ILogTransacionalService;

@Component
public class JobIntegracaoService implements IJobIntegracaoService {

	@Autowired
	EnvioLogTransacionalParaKafkaService logTransacionalService;

	@Autowired
	CadastroLogTransacionalService cadastraLogTransacionalService;

	@Scheduled(cron = "* * * ? * *")
	public void executaJob() {
		List<LogTransacionalDto> list = cadastraLogTransacionalService.cadastro();
		//logTransacionalService.enviaLogs(list);
		System.out.println("entrou no job");
	}

}
