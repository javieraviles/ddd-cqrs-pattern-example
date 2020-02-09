package es.codeurjc.daw.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.codeurjc.daw.application.InsuranceQueryService;

@RestController
@RequestMapping("/api")
public class InsuranceQueryController {

	@Autowired
	private InsuranceQueryService insuranceService;

	@GetMapping("/claim")
	public List<ClaimDto> listOpenedClaims() {
		return insuranceService.getOpenedClaims();
	}

}
