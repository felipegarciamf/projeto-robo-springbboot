package br.com.microservice.robo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.com.microservice.robo.client.ILogTransacionalAWSClient;
import br.com.microservice.robo.dto.LogTransacionalDto;
import br.com.microservice.robo.form.LogTransacionalForm;
import br.com.microservice.robo.model.LogTransacional;
import br.com.microservice.robo.repository.LogTransacionalRepository;

@Service
public class LogTransacionalService implements ILogTransacionalService {

	private static final String TOPIC = "logTransacionalExample";

	// envio via kafka
	@Autowired
	private KafkaTemplate<String, LogTransacionalDto> kafkaTemplate;

	@Autowired
	private LogTransacionalRepository logTransacionalRepository;

	// Envio via api
	@Autowired
	private ILogTransacionalAWSClient logTransacionalAWSClient;

	private LogTransacionalForm logTransacionalForm = new LogTransacionalForm();

	private Long valor = 0L;

	public LogTransacionalService() {

	}

	public LogTransacionalService cadastraLogTransacional() {
		valor++;
		logTransacionalForm.setNome("novo" + valor);
		logTransacionalForm.setTransacao("Loco" + valor);
		LogTransacional logTransacional = logTransacionalForm.converter();
		logTransacionalRepository.save(logTransacional);

		List<LogTransacional> all = logTransacionalRepository.findAll();

		List<LogTransacionalDto> listaLogs = LogTransacionalDto.converter(all);

		for (LogTransacionalDto logTransacional3 : listaLogs) {
			System.out.println(logTransacional3.getId());
			System.out.println(logTransacional3.getNome());
			System.out.println(logTransacional3.getTransacao());
			System.out.println("<<<<<<<<<<<< PROXIMO >>>>>>>>>>>>>>");
		}

		return this;
	}

	public LogTransacionalService envioDeLogsParaKafkaProducer() {
		List<LogTransacional> all = logTransacionalRepository.findAll();

		List<LogTransacionalDto> listaLogs = LogTransacionalDto.converter(all);

		for (LogTransacionalDto logTransacional3 : listaLogs) {
			System.out.println(logTransacional3.getId());
			System.out.println(logTransacional3.getNome());
			System.out.println(logTransacional3.getTransacao());

			// envio de lista para o topico kafka
			kafkaTemplate.send(TOPIC, logTransacional3);
			System.out.println("Published successfully");
			System.out.println("<<<<<<<<<<<< PROXIMO >>>>>>>>>>>>>>");
		}
		return this;
	}

	public LogTransacionalService cadastraLogsViaAPI() {
		logTransacionalAWSClient.cadastroLog(logTransacionalForm);
		return this;
	}

}
