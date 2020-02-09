package es.codeurjc.daw.controller;

import es.codeurjc.daw.model.Status;

public class BasicClaimDto {

	private long id = -1;
	private String lossDescription;
	private Status status;
	private long compensation;

	public BasicClaimDto() {
		super();
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
