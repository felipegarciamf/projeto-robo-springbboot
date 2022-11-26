package br.com.microservice.robo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.robo.dto.LogTransacionalDto;
import br.com.microservice.robo.modelo.LogTransacional;
import br.com.microservice.robo.repository.ILogTransacionalRepository;

@RestController
@RequestMapping("/transacoes/")
public class LogTransacionalController {

	@Autowired
	private ILogTransacionalRepository logTransacionalRepository;

	@GetMapping
	public List<LogTransacionalDto> lista() {
		List<LogTransacional> findAll = logTransacionalRepository.findAll();
		return LogTransacionalDto.converter(findAll);
	}

	@GetMapping("tipo")
	public List<LogTransacionalDto> listaPorData(Long id, @RequestParam String nome) {
		List<LogTransacional> findAll = logTransacionalRepository.findByTipoLogIdAndTipoLogNome(id, nome);
		return LogTransacionalDto.converter(findAll);

	}

}
