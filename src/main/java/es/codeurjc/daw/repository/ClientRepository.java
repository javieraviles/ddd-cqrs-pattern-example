package es.codeurjc.daw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.daw.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
