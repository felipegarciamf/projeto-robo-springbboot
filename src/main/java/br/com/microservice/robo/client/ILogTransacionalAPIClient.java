package br.com.microservice.robo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.microservice.robo.form.LogTransacionalForm;

@FeignClient(value= "teste",url = "http://teste/")
public interface ILogTransacionalAPIClient {
	
	
	@PostMapping("/log_transacoes")
	public void cadastroLog(@RequestBody LogTransacionalForm log);
	

}
