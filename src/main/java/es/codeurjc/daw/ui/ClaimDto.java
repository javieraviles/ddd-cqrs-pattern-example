package es.codeurjc.daw.ui;

import es.codeurjc.daw.model.LossType;
import es.codeurjc.daw.model.Status;

public class ClaimDto {

	private String lossDescription;
	private LossType lossType;
	private Status status;
	private long compensation;

	public ClaimDto() {
		super();
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public long getCompensation() {
		return compensation;
	}

	public void setCompensation(long compensation) {
		this.compensation = compensation;
	}

}
