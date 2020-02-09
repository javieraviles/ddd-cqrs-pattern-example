package es.codeurjc.daw.controller;

import java.time.LocalDateTime;

public class FullPolicyDto {

	private long id = -1;
	private String address;
	private int risk;
	private boolean electricalAppliancesCoverage;
	private boolean windowsCoverage;
	private boolean facadeCoverage;
	private LocalDateTime startingDate;
	private long yearlyPrice;

	public FullPolicyDto() {
		super();
	}

	public FullPolicyDto(String address, int risk, boolean electricalAppliancesCoverage, boolean windowsCoverage,
			boolean facadeCoverage, LocalDateTime startingDate, long yearlyPrice) {
		super();
		this.address = address;
		this.risk = risk;
		this.electricalAppliancesCoverage = electricalAppliancesCoverage;
		this.windowsCoverage = windowsCoverage;
		this.facadeCoverage = facadeCoverage;
		this.startingDate = startingDate;
		this.yearlyPrice = yearlyPrice;
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

	public boolean isElectricalAppliancesCoverage() {
		return electricalAppliancesCoverage;
	}

	public void setElectricalAppliancesCoverage(boolean electricalAppliancesCoverage) {
		this.electricalAppliancesCoverage = electricalAppliancesCoverage;
	}

	public boolean isWindowsCoverage() {
		return windowsCoverage;
	}

	public void setWindowsCoverage(boolean windowsCoverage) {
		this.windowsCoverage = windowsCoverage;
	}

	public boolean isFacadeCoverage() {
		return facadeCoverage;
	}

	public void setFacadeCoverage(boolean facadeCoverage) {
		this.facadeCoverage = facadeCoverage;
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
}
