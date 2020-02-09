package es.codeurjc.daw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.daw.model.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Long> {

}
