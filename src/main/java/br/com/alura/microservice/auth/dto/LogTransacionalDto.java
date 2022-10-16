package br.com.alura.microservice.auth.dto;

public class LogTransacionalDto {

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

}
