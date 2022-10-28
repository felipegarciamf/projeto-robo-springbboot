package br.com.microservice.robo.service.transacional.kafka.consumer;

import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;

import br.com.microservice.robo.dto.LogTransacionalDto;

public interface IRecebimentoLogTransacionalParaKafkaService {

	public void consome(@Payload LogTransacionalDto valor, Acknowledgment ack);
	
	
}
