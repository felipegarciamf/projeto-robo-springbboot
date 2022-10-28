package br.com.microservice.robo.service.transacional.kafka.producer;

import java.util.List;

import br.com.microservice.robo.dto.LogTransacionalDto;

public interface IEnvioLogTransacionalParaKafkaService {

	public void enviaLogs(List<LogTransacionalDto> log);
	
}
