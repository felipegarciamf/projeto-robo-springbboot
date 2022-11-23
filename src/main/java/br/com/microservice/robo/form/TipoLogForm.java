package br.com.microservice.robo.form;

import org.springframework.lang.NonNull;

import br.com.microservice.robo.modelo.TipoLog;

public class TipoLogForm {

	@NonNull
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public TipoLog converter() {
		return new TipoLog(nome);
	}

}
