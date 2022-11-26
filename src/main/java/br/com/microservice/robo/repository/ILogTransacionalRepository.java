package br.com.microservice.robo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.microservice.robo.modelo.LogTransacional;

public interface ILogTransacionalRepository extends JpaRepository<LogTransacional, Long> {

	List<LogTransacional> findByTipoLogNome(String nome);
	
	List<LogTransacional> findByTipoLogIdAndTipoLogNome(Long id, String nome);

	
	
}
