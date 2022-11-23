package br.com.microservice.robo.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.microservice.robo.modelo.LogTransacional;

public class LogTransacionalDto {

	
	public LogTransacionalDto(LogTransacional logTransacional) {
		this.id = logTransacional.getId();
		this.nome = logTransacional.getNome();
		this.transacao = logTransacional.getTransacao();
	}
	
	private Long id;

	private String nome;

	private String transacao;

	

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getTransacao() {
		return transacao;
	}

	public static List<LogTransacionalDto> converter(List<LogTransacional> logTransacional) {
		return logTransacional.stream().map(LogTransacionalDto::new).collect(Collectors.toList());
		
	}

}
