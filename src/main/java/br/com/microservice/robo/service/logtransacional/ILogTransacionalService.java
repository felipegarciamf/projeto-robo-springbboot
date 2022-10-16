package br.com.microservice.robo.service.logtransacional;

public interface ILogTransacionalService {

	
	public LogTransacionalService envioDeLogsParaKafkaProducer();
	
	public LogTransacionalService cadastraLogsViaAPI();
	
	public LogTransacionalService cadastraLogTransacional();
	
}
