package br.com.microservice.robo.dto;

import br.com.microservice.robo.modelo.TipoLog;

public class TipoLogDto {

	public TipoLogDto(TipoLog tipoLog) {
		this.id = tipoLog.getId();
		this.nome = tipoLog.getNome();
	}

	private Long id;

	private String nome;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
