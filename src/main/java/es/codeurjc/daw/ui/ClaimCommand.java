package es.codeurjc.daw.ui;

import org.modelmapper.ModelMapper;

import es.codeurjc.daw.model.Claim;
import es.codeurjc.daw.model.LossType;

public class ClaimCommand {

	private String lossDescription;
	private LossType lossType;
	private long compensation;

	public ClaimCommand() {
		super();
	}

	public Claim convertToEntity(ModelMapper modelMapper) {
		return modelMapper.map(this, Claim.class);
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
