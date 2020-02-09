package es.codeurjc.daw.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

@Entity
public class Claim {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String lossDescription;
	private LossType lossType;
	private boolean expertLossAdjusterNeeded;
	@Enumerated(EnumType.STRING)
	private Status status;
	private LocalDateTime creationDate;
	private long compensation;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "policy_id")
	private Policy policy;

	public Claim() {
		super();
	}

	public Claim(String lossDescription, LossType lossType, long compensation) {
		super();
		this.lossDescription = lossDescription;
		this.lossType = lossType;
		this.compensation = compensation;
	}

	public void determineWhetherExpertLossAdjusterNeeded(final List<Claim> previousClaims) {
		final int minClaimsToBeFraudulent = 2;
		final int minCompensationToBeFraudulent = 1000;

		if (previousClaims.size() >= minClaimsToBeFraudulent) {
			long totalCompensation = 0;
			for (Claim claim : previousClaims) {
				totalCompensation += claim.getCompensation();
			}
			this.expertLossAdjusterNeeded = totalCompensation > minCompensationToBeFraudulent;
		}
		this.expertLossAdjusterNeeded = false;
	}

	@PrePersist
	public void onPrePersist() {
		determineStatus();
		this.creationDate = LocalDateTime.now();
	}

	private void determineStatus() {
		this.status = policy.isLossTypeCovered(this.lossType) ? Status.OPENED : Status.REJECTED;
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

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

}
