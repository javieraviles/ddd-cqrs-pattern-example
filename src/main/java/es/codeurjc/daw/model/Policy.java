package es.codeurjc.daw.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String address;
	private int risk;
	private boolean electricalAppliancesCoverage;
	private boolean windowsCoverage;
	private boolean facadeCoverage;
	private LocalDateTime startDate;
	private long yearlyPrice;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id")
	private Client policyHolder;

	public Policy() {
		super();
	}

	public boolean isLossTypeCovered(LossType lossType) {
		switch (lossType) {
		case ELECTRICAL_APPLIANCES:
			return this.electricalAppliancesCoverage;
		case WINDOWS:
			return this.windowsCoverage;
		case FACADE:
			return this.facadeCoverage;
		default:
			return false;
		}
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setRisk(int risk) {
		this.risk = risk;
	}

	public void setElectricalAppliancesCoverage(boolean electricalAppliancesCoverage) {
		this.electricalAppliancesCoverage = electricalAppliancesCoverage;
	}

	public void setWindowsCoverage(boolean windowsCoverage) {
		this.windowsCoverage = windowsCoverage;
	}

	public void setFacadeCoverage(boolean facadeCoverage) {
		this.facadeCoverage = facadeCoverage;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public void setYearlyPrice(long yearlyPrice) {
		this.yearlyPrice = yearlyPrice;
	}

	public Client getPolicyHolder() {
		return policyHolder;
	}

	public void setPolicyHolder(Client policyHolder) {
		this.policyHolder = policyHolder;
	}

}
