package br.com.microservice.robo.service.transacional.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservice.robo.dto.LogTransacionalDto;
import br.com.microservice.robo.form.LogTransacionalForm;
import br.com.microservice.robo.modelo.LogTransacional;
import br.com.microservice.robo.repository.ILogTransacionalRepository;


@Service
public class CadastroLogTransacionalService implements ICadastroLogTransacionalService {

	private Long valor = 0L;

	@Autowired
	private ILogTransacionalRepository logTransacionalRepository;

	public List<LogTransacionalDto> cadastro() {
		LogTransacionalForm logTransacionalForm = new LogTransacionalForm();

		valor++;
		logTransacionalForm.setNome("novo" + valor);
		logTransacionalForm.setTransacao("Loco" + valor);
		LogTransacional logTransacional = logTransacionalForm.converter();
		logTransacionalRepository.save(logTransacional);
		return recuperaLogTransacional();

	}

	private List<LogTransacionalDto> recuperaLogTransacional() {
		List<LogTransacional> all = logTransacionalRepository.findAll();

		List<LogTransacionalDto> listaLogs = LogTransacionalDto.converter(all);

		for (LogTransacionalDto logTransacional3 : listaLogs) {
			System.out.println(logTransacional3.getId());
			System.out.println(logTransacional3.getNome());
			System.out.println(logTransacional3.getTransacao());
			System.out.println("<<<<<<<<<<<< PROXIMO >>>>>>>>>>>>>>");
		}

		return listaLogs;
	}

}
