package es.codeurjc.daw.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.daw.model.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Long> {

}
