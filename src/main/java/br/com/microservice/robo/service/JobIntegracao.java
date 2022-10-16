package br.com.microservice.robo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.microservice.robo.dto.LogTransacionalDto;
import br.com.microservice.robo.form.LogTransacionalForm;
import br.com.microservice.robo.model.LogTransacional;
import br.com.microservice.robo.repository.LogTransacionalRepository;

@Component
public class JobIntegracao implements IJobIntegracao {

	
	@Autowired
	private LogTransacionalRepository logTransacionalRepository;
	
	private Long valor = 0L;
	
	@Scheduled(cron = "* * * ? * *")
	public void executaJob() {
		
		valor++;
				
		LogTransacionalForm logTransacionalForm = new LogTransacionalForm();
		
		logTransacionalForm.setNome("novo" + valor);
		logTransacionalForm.setTransacao("Loco" + valor);
		
		LogTransacional logTransacional = logTransacionalForm.converter();
		logTransacionalRepository.save(logTransacional);
		
		List<LogTransacional> all = logTransacionalRepository.findAll();
		
		 List<LogTransacionalDto> listaLogs = LogTransacionalDto.converter(all);
		
		for (LogTransacionalDto logTransacional3 : listaLogs) {
			System.out.println(logTransacional3.getId());
			System.out.println(logTransacional3.getNome());
			System.out.println(logTransacional3.getTransacao());
			System.out.println("<<<<<<<<<<<< PROXIMO >>>>>>>>>>>>>>");
		}
		
		
		System.out.println("entrou no job");
		
	}
	
	
}
