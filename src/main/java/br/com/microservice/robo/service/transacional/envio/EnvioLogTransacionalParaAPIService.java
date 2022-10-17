package br.com.microservice.robo.service.transacional.envio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservice.robo.client.ILogTransacionalAPIClient;
import br.com.microservice.robo.dto.LogTransacionalDto;
import br.com.microservice.robo.form.LogTransacionalForm;

@Service
public class EnvioLogTransacionalParaAPIService implements ILogTransacionalService {

	// Envio via api
	@Autowired
	private ILogTransacionalAPIClient logTransacionalAWSClient;

	@Override
	public void enviaLogs(List<LogTransacionalDto> log) {
		LogTransacionalForm logTransacionalForm = new LogTransacionalForm();

		log.stream().forEach(e -> {
			logTransacionalForm.setNome(e.getNome());
			logTransacionalForm.setTransacao(e.getTransacao());
			logTransacionalAWSClient.cadastroLog(logTransacionalForm);
		});

	}

}
