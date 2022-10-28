package br.com.microservice.robo.service.transacional.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;


@Service
public class RecebimentoLogTransacionalParaKafkaService implements IRecebimentoLogTransacionalParaKafkaService {

	@Override
	@KafkaListener(topics = "logTransacionalExample")
	public void consome(@Payload String valor, Acknowledgment ack) {

		System.out.println(valor);
		
		 ack.acknowledge();
		
	}



	
	

}
