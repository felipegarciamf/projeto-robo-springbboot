package br.com.microservice.robo.configuration.kafka;

import java.util.HashMap;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties.AckMode;

import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;

import br.com.microservice.robo.dto.LogTransacionalDto;

@Configuration
public class KafkaConsumerConfig {

	@Autowired
	KafkaProperties properties;
	
	@Bean
	public DefaultKafkaConsumerFactory<String, LogTransacionalDto> consumerFactory() {
		HashMap<String, Object> config = new HashMap<String, Object>();

		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializable.class);
		
		return new DefaultKafkaConsumerFactory<>(config);
	}
	

	@Bean
	public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, LogTransacionalDto>> kafkaListenerContainerFactory() {

		ConcurrentKafkaListenerContainerFactory<String, LogTransacionalDto> listener = new ConcurrentKafkaListenerContainerFactory<>();

		listener.setConsumerFactory(consumerFactory());

		listener.getContainerProperties().setMissingTopicsFatal(false);

		listener.getContainerProperties().setAckMode(AckMode.MANUAL);

		listener.getContainerProperties().setSyncCommits(Boolean.TRUE);

		return listener;
	}

}
