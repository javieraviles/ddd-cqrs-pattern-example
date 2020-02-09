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
	private boolean electricalAppliancesCover;
	private boolean windowsCover;
	private boolean facadeCover;
	private LocalDateTime startDate;
	private long yearlyPrice;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id")
	private Client policyHolder;

	public Policy(String address, int risk, boolean electricalAppliancesCover, boolean windowsCover,
			boolean facadeCover, LocalDateTime startDate, long yearlyPrice, Client policyHolder) {
		super();
		this.address = address;
		this.risk = risk;
		this.electricalAppliancesCover = electricalAppliancesCover;
		this.windowsCover = windowsCover;
		this.facadeCover = facadeCover;
		this.startDate = startDate;
		this.yearlyPrice = yearlyPrice;
		this.policyHolder = policyHolder;
	}

	public Policy() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRisk() {
		return risk;
	}

	public void setRisk(int risk) {
		this.risk = risk;
	}

	public boolean isElectricalAppliancesCover() {
		return electricalAppliancesCover;
	}

	public void setElectricalAppliancesCover(boolean electricalAppliancesCover) {
		this.electricalAppliancesCover = electricalAppliancesCover;
	}

	public boolean isWindowsCover() {
		return windowsCover;
	}

	public void setWindowsCover(boolean windowsCover) {
		this.windowsCover = windowsCover;
	}

	public boolean isFacadeCover() {
		return facadeCover;
	}

	public void setFacadeCover(boolean facadeCover) {
		this.facadeCover = facadeCover;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public long getYearlyPrice() {
		return yearlyPrice;
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
