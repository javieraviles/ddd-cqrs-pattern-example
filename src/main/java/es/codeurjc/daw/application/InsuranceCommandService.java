package es.codeurjc.daw.application;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codeurjc.daw.model.Claim;
import es.codeurjc.daw.model.Client;
import es.codeurjc.daw.model.Policy;
import es.codeurjc.daw.persistence.ClaimRepository;
import es.codeurjc.daw.persistence.ClientRepository;
import es.codeurjc.daw.persistence.PolicyRepository;
import es.codeurjc.daw.ui.ClaimCommand;
import es.codeurjc.daw.ui.PolicyCommand;

@Service
public class InsuranceCommandService {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ClaimRepository claimRepository;

	@Autowired
	private PolicyRepository policyRepository;

	@Autowired
	private ModelMapper modelMapper;

	public void newPolicy(long clientId, PolicyCommand policy) {
		Client client = clientRepository.findById(clientId).orElseThrow(EntityNotFoundException::new);
		Policy policyEntity = policy.convertToPolicyEntity(modelMapper);
		policyEntity.setPolicyHolder(client);
		policyRepository.save(policyEntity);
	}

	public void newClaim(long policyId, ClaimCommand claim) {
		Policy policy = policyRepository.findById(policyId).orElseThrow(EntityNotFoundException::new);
		Claim claimEntity = claim.convertToClaimEntity(modelMapper);
		claimEntity.setPolicy(policy);
		List<Claim> previousClaims = claimRepository.findAllByPolicyPolicyHolderId(policy.getPolicyHolder().getId());
		claimEntity.determineWhetherExpertLossAdjusterNeeded(previousClaims);
		claimRepository.save(claimEntity);
	}

}
