package br.com.microservice.robo.service;

public interface ILogTransacionalService {

	
	public LogTransacionalService envioDeLogsParaKafkaProducer();
	
	public LogTransacionalService cadastraLogsViaAPI();
	
	public LogTransacionalService cadastraLogTransacional();
	
}
