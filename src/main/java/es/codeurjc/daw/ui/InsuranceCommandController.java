package es.codeurjc.daw.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.codeurjc.daw.application.InsuranceCommandService;

@RestController
@RequestMapping("/api")
public class InsuranceCommandController {

	@Autowired
	private InsuranceCommandService insuranceService;

	@PostMapping("/client/{clientId}/policy")
	public void newPolicy(@PathVariable long clientId, @RequestBody PolicyCommand policy) {
		this.insuranceService.newPolicy(clientId, policy);
	}

	@PostMapping("/policy/{policyId}/claim")
	public void newClaim(@PathVariable long policyId, @RequestBody ClaimCommand claim) {
		this.insuranceService.newClaim(policyId, claim);
	}

}
