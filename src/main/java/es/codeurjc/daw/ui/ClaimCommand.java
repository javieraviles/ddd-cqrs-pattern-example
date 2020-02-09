package es.codeurjc.daw.ui;

import org.modelmapper.ModelMapper;

import es.codeurjc.daw.model.Claim;
import es.codeurjc.daw.model.LossType;

public class ClaimCommand {

	private long id = -1;
	private String lossDescription;
	private LossType lossType;
	private long compensation;

	public ClaimCommand() {
		super();
	}

	public Claim convertToClaimEntity(ModelMapper modelMapper) {
		return modelMapper.map(this, Claim.class);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLossDescription() {
		return lossDescription;
	}

	public void setLossDescription(String lossDescription) {
		this.lossDescription = lossDescription;
	}

	public LossType getLossType() {
		return lossType;
	}

	public void setLossType(LossType lossType) {
		this.lossType = lossType;
	}

	public long getCompensation() {
		return compensation;
	}

	public void setCompensation(long compensation) {
		this.compensation = compensation;
	}

}
