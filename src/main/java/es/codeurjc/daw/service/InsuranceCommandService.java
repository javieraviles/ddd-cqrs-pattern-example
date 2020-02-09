package es.codeurjc.daw.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codeurjc.daw.controller.FullClaimDto;
import es.codeurjc.daw.controller.FullPolicyDto;
import es.codeurjc.daw.model.Claim;
import es.codeurjc.daw.model.Client;
import es.codeurjc.daw.model.Policy;
import es.codeurjc.daw.repository.ClaimRepository;
import es.codeurjc.daw.repository.ClientRepository;
import es.codeurjc.daw.repository.PolicyRepository;

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

	public void addPolicy(long clientId, FullPolicyDto policy) {
		Client client = clientRepository.findById(clientId).orElseThrow(EntityNotFoundException::new);
		policy.setPolicyHolder(client);
		policyRepository.save(convertFullPolicyDtoToEntity(policy));
	}

	public void addclaim(long policyId, FullClaimDto claim) {
		Policy policy = policyRepository.findById(policyId).orElseThrow(EntityNotFoundException::new);
		claim.setPolicy(policy);
		claim.setExpertLossAdjusterNeeded(isExpertLossAdjusterNeeded(policy.getPolicyHolder().getId()));
		claimRepository.save(convertFullClaimDtoToEntity(claim));
	}

	private Policy convertFullPolicyDtoToEntity(FullPolicyDto policy) {
		return modelMapper.map(policy, Policy.class);
	}

	private Claim convertFullClaimDtoToEntity(FullClaimDto claim) {
		return modelMapper.map(claim, Claim.class);
	}

	private boolean isExpertLossAdjusterNeeded(long policyHolderId) {
		final int minClaimsToBeFraudulent = 2;
		final int minCompensationToBeFraudulent = 1000;

		final List<Claim> claims = claimRepository.findAllByPolicyPolicyHolderId(policyHolderId);
		if (claims.size() >= minClaimsToBeFraudulent) {
			long totalCompensation = 0;
			for (Claim claim : claims) {
				totalCompensation += claim.getCompensation();
			}
			return totalCompensation > minCompensationToBeFraudulent;
		}
		return false;
	}
}
