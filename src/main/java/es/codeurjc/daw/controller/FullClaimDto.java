package es.codeurjc.daw.controller;

import java.time.LocalDateTime;

import es.codeurjc.daw.model.Policy;
import es.codeurjc.daw.model.Status;

public class FullClaimDto {

	private long id = -1;
	private String lossDescription;
	private boolean expertLossAdjusterNeeded;
	private Status status;
	private LocalDateTime creationDate;
	private long compensation;
	private Policy policy;

	public FullClaimDto() {
		super();
	}

	public FullClaimDto(String lossDescription, boolean expertLossAdjusterNeeded, Status status,
			LocalDateTime creationDate, long compensation, Policy policy) {
		super();
		this.lossDescription = lossDescription;
		this.expertLossAdjusterNeeded = expertLossAdjusterNeeded;
		this.status = status;
		this.creationDate = creationDate;
		this.compensation = compensation;
		this.policy = policy;
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

	public boolean isExpertLossAdjusterNeeded() {
		return expertLossAdjusterNeeded;
	}

	public void setExpertLossAdjusterNeeded(boolean expertLossAdjusterNeeded) {
		this.expertLossAdjusterNeeded = expertLossAdjusterNeeded;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public long getCompensation() {
		return compensation;
	}

	public void setCompensation(long compensation) {
		this.compensation = compensation;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

}
