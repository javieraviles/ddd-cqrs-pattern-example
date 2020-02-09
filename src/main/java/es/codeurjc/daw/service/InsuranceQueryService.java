package es.codeurjc.daw.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codeurjc.daw.controller.BasicClaimDto;
import es.codeurjc.daw.model.Claim;
import es.codeurjc.daw.model.Status;
import es.codeurjc.daw.repository.ClaimRepository;

@Service
public class InsuranceQueryService {

	@Autowired
	private ClaimRepository claimRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<BasicClaimDto> getOpenedClaimsList() {
		return claimRepository.findByStatus(Status.OPENED).stream().map((claim) -> convertClaimEntityToBasicDto(claim))
				.collect(Collectors.toList());
	}

	private BasicClaimDto convertClaimEntityToBasicDto(Claim claim) {
		return modelMapper.map(claim, BasicClaimDto.class);
	}

}
