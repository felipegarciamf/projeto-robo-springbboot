package br.com.microservice.robo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.microservice.robo.modelo.LogTransacional;

public interface ILogTransacionalRepository extends JpaRepository<LogTransacional, Long> {

}
