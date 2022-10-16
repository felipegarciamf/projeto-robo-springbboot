package br.com.alura.microservice.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.microservice.auth.model.LogTransacional;

public interface LogTransacionalRepository extends JpaRepository<LogTransacional, Long> {

}
