package br.com.microservice.robo.service.transacional.kafka.consumer;

import org.apache.kafka.clients.consumer.Consumer;

public interface IRecebimentoLogTransacionalParaKafkaService {

	
	public Consumer<Long, String> criaConsumidor();
	
	public void listaConsumidor();
	
}
