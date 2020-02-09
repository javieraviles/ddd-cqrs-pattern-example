package es.codeurjc.daw.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.daw.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
