package br.com.microservice.robo.service.logtransacional;

public interface ILogTransacionalService {

	
	public LogTransacionalService enviaLogsParaOKafkaProducer();
	
	public LogTransacionalService cadastraLogsViaAPI();
	
	public LogTransacionalService cadastraLogTransacional();
	
}
