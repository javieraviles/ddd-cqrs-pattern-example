package es.codeurjc.daw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.daw.model.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long> {

}
