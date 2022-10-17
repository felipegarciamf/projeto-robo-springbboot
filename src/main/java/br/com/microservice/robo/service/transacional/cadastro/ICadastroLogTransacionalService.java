package br.com.microservice.robo.service.transacional.cadastro;

import java.util.List;

import br.com.microservice.robo.dto.LogTransacionalDto;

public interface ICadastroLogTransacionalService {

	
	/**
	 * Método para cadastro de log transacional no banco de dados
	 * 
	 * @return 
	 * Lista de Logs transacionais
	 */
	public List<LogTransacionalDto> cadastro();
	
}
