package es.codeurjc.daw.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.daw.model.Claim;
import es.codeurjc.daw.model.Status;

public interface ClaimRepository extends JpaRepository<Claim, Long> {

	public List<Claim> findByStatus(Status status);
	
	public List<Claim> findAllByPolicyPolicyHolderId(long id);
}
