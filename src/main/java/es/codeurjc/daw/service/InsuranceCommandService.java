package es.codeurjc.daw.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codeurjc.daw.controller.FullClaimDto;
import es.codeurjc.daw.controller.FullPolicyDto;
import es.codeurjc.daw.model.Claim;
import es.codeurjc.daw.model.Client;
import es.codeurjc.daw.model.LossType;
import es.codeurjc.daw.model.Policy;
import es.codeurjc.daw.model.Status;
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
		Policy policyEntity = convertFullPolicyDtoToEntity(policy);
		policyEntity.setPolicyHolder(client);
		policyRepository.save(policyEntity);
	}

	public void addclaim(long policyId, FullClaimDto claim) {
		Policy policy = policyRepository.findById(policyId).orElseThrow(EntityNotFoundException::new);
		Claim claimEntity = convertFullClaimDtoToEntity(claim);
		claimEntity.setPolicy(policy);
		claimEntity.setStatus(isLossTypeCovered(policy, claim.getLossType()) ? Status.OPENED : Status.REJECTED);
		claimEntity.setCreationDate(LocalDateTime.now());
		claimEntity.setExpertLossAdjusterNeeded(isExpertLossAdjusterNeeded(policy.getPolicyHolder().getId()));
		claimRepository.save(claimEntity);
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

	private boolean isLossTypeCovered(Policy policy, LossType lossType) {
		switch (lossType) {
			case ELECTRICAL_APPLIANCES:
				return policy.isElectricalAppliancesCoverage();
			case WINDOWS:
				return policy.isWindowsCoverage();
			case FACADE:
				return policy.isFacadeCoverage();
			default:
				return false;

		}
	}

	private Policy convertFullPolicyDtoToEntity(FullPolicyDto policy) {
		return modelMapper.map(policy, Policy.class);
	}

	private Claim convertFullClaimDtoToEntity(FullClaimDto claim) {
		return modelMapper.map(claim, Claim.class);
	}

}
