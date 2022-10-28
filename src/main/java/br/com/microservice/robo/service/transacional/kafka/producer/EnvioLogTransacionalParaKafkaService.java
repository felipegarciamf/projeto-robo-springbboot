package br.com.microservice.robo.service.transacional.kafka.producer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.com.microservice.robo.dto.LogTransacionalDto;

@Service
public class EnvioLogTransacionalParaKafkaService implements IEnvioLogTransacionalParaKafkaService {

	private static final String TOPIC = "logTransacionalExample";

	@Autowired
	private KafkaTemplate<String, LogTransacionalDto> kafkaTemplate;

	
	@Override
	public void enviaLogs(List<LogTransacionalDto> log) {
		log.stream().forEach(e -> kafkaTemplate.send(TOPIC, e));
		System.out.println("Published successfully");
	}

}
