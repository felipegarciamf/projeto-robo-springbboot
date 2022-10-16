package br.com.microservice.robo.configuration.kafka;

import java.util.HashMap;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;

import br.com.microservice.robo.dto.LogTransacionalDto;

@Configuration
public class LogTransacionalKafkaProducerConfig {

	@Bean
	public ProducerFactory<String, LogTransacionalDto> producerFactory() {

		HashMap<String, Object> config = new HashMap<String, Object>();

		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializable.class);

		return new DefaultKafkaProducerFactory<>(config);

	}

	@Bean
	public KafkaTemplate<String, LogTransacionalDto> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

}
