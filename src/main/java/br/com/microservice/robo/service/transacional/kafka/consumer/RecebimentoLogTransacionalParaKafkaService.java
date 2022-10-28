package br.com.microservice.robo.service.transacional.kafka.consumer;

import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class RecebimentoLogTransacionalParaKafkaService {

	private final static String TOPIC = "";

	private final static String BOOTSTRAP_SERVERS = "";

	public Consumer<Long, String> criaConsumidor() {

		final Properties props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "Kafka");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

		final Consumer<Long, String> consumer = new KafkaConsumer<>(props);

		consumer.subscribe(Collections.singletonList(TOPIC));
		return consumer;

	}

}
