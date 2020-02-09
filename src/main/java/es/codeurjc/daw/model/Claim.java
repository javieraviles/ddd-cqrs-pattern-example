package es.codeurjc.daw.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Claim {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String lossDescription;
	private boolean expertLossAdjusterNeeded;
	private Status status;
	private LocalDateTime creationDate;
	private long compensation;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "policy_id")
	private Policy policy;

	public Claim() {
		super();
	}

	public Claim(String lossDescription, boolean expertLossAdjusterNeeded, Status status, boolean liable,
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
