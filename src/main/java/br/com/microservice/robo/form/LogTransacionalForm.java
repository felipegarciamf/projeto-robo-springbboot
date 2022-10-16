package br.com.microservice.robo.form;

import br.com.microservice.robo.model.LogTransacional;

public class LogTransacionalForm {

	private String nome;

	private String transacao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTransacao() {
		return transacao;
	}

	public void setTransacao(String transacao) {
		this.transacao = transacao;
	}

	public LogTransacional converter() {
		return new LogTransacional(nome, transacao);
	}
}
