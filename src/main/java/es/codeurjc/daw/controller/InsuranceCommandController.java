package es.codeurjc.daw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.codeurjc.daw.service.InsuranceCommandService;

@RestController
@RequestMapping("/api")
public class InsuranceCommandController {

	@Autowired
	private InsuranceCommandService insuranceService;

	@PostMapping("/client/{clientId}/policy")
	public void newPolicy(@PathVariable long clientId, @RequestBody FullPolicyDto policy) {
		this.insuranceService.addPolicy(clientId, policy);
	}

	@PostMapping("/policy/{policyId}/claim")
	public void newClaim(@PathVariable long policyId, @RequestBody FullClaimDto claim) {
		this.insuranceService.addclaim(policyId, claim);
	}

}
