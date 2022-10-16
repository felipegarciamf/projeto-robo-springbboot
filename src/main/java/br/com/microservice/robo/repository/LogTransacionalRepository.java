package br.com.microservice.robo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.microservice.robo.model.LogTransacional;

public interface LogTransacionalRepository extends JpaRepository<LogTransacional, Long> {

}
