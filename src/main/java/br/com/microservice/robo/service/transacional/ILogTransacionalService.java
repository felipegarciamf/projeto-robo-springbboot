package br.com.microservice.robo.service.transacional;

import java.util.List;

import br.com.microservice.robo.dto.LogTransacionalDto;

public interface ILogTransacionalService {

	/**
	 * Método que envia log transacional
	 * @param log
	 * Parametro de log transacional para cadastro
	 */
	public void enviaLogs(List<LogTransacionalDto> log);
	
	
	
}
