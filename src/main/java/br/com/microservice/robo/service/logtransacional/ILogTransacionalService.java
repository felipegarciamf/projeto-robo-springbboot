package br.com.microservice.robo.service.logtransacional;

import java.util.List;

import br.com.microservice.robo.dto.LogTransacionalDto;

public interface ILogTransacionalService {

	
	public void enviaLogs(List<LogTransacionalDto> log);
	
	
	
}
