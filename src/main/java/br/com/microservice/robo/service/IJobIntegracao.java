package br.com.microservice.robo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.microservice.robo.dto.LogTransacionalDto;
import br.com.microservice.robo.form.LogTransacionalForm;
import br.com.microservice.robo.model.LogTransacional;
import br.com.microservice.robo.repository.LogTransacionalRepository;


public interface IJobIntegracao {

	public void executaJob();	
	
}
