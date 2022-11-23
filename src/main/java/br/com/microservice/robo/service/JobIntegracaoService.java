package br.com.microservice.robo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.microservice.robo.dto.LogTransacionalDto;
import br.com.microservice.robo.service.transacional.cadastro.CadastroLogTransacionalService;
import br.com.microservice.robo.service.transacional.kafka.consumer.IRecebimentoLogTransacionalParaKafkaService;
import br.com.microservice.robo.service.transacional.kafka.producer.EnvioLogTransacionalParaKafkaService;
import br.com.microservice.robo.service.transacional.kafka.producer.IEnvioLogTransacionalParaKafkaService;

@Component
public class JobIntegracaoService implements IJobIntegracaoService {
	
	

	@Autowired
	IEnvioLogTransacionalParaKafkaService logTransacionalService;

	@Autowired
	CadastroLogTransacionalService cadastraLogTransacionalService;

	
	@Scheduled(cron = "* * * ? * *")
	public void executaJob() {
		List<LogTransacionalDto> list = cadastraLogTransacionalService.cadastro();
		logTransacionalService.enviaLogs(list);
		
		
		System.out.println("entrou no job");
	}

}
