package br.com.microservice.robo.form;

import br.com.microservice.robo.modelo.LogTransacional;

public class LogTransacionalForm {

	private String nome;

	private String transacao;
	
	private TipoLogForm tipoLog;

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
	
	public void setTipoLog(TipoLogForm tipoLogForm) {
		this.tipoLog = tipoLogForm;		
	}

	public LogTransacional converter() {
		return new LogTransacional(nome, transacao, tipoLog.converter());
	}

	
}
