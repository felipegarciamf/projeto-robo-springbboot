package br.com.microservice.robo.service.transacional.kafka.consumer;

import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;

public interface IRecebimentoLogTransacionalParaKafkaService {

	public void consome(@Payload String valor, Acknowledgment ack);
	
	
}
