package es.codeurjc.daw.controller;

import es.codeurjc.daw.model.LossType;

public class FullClaimDto {

	private long id = -1;
	private String lossDescription;
	private LossType lossType;
	private long compensation;

	public FullClaimDto() {
		super();
	}

	public FullClaimDto(String lossDescription, LossType losstype, long compensation) {
		super();
		this.lossDescription = lossDescription;
		this.lossType = losstype;
		this.compensation = compensation;
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
