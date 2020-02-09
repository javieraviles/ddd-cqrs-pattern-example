package es.codeurjc.daw.controller;

import java.time.LocalDateTime;

import es.codeurjc.daw.model.Client;

public class FullPolicyDto {

	private long id = -1;
	private String address;
	private int risk;
	private boolean electricalAppliancesCover;
	private boolean windowsCover;
	private boolean facadeCover;
	private LocalDateTime startingDate;
	private long yearlyPrice;
	private Client policyHolder;

	public FullPolicyDto() {
		super();
	}

	public FullPolicyDto(String address, int risk, boolean electricalAppliancesCover, boolean windowsCover,
			boolean facadeCover, LocalDateTime startingDate, long yearlyPrice, Client policyHolder) {
		super();
		this.address = address;
		this.risk = risk;
		this.electricalAppliancesCover = electricalAppliancesCover;
		this.windowsCover = windowsCover;
		this.facadeCover = facadeCover;
		this.startingDate = startingDate;
		this.yearlyPrice = yearlyPrice;
		this.policyHolder = policyHolder;
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

	public LocalDateTime getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(LocalDateTime startingDate) {
		this.startingDate = startingDate;
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