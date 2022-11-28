package br.com.microservice.robo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.microservice.robo.modelo.TipoLog;

public interface ITipoLogRepository extends JpaRepository<TipoLog, Long> {

}
