package es.codeurjc.daw.ui;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;

import es.codeurjc.daw.model.Policy;

public class PolicyCommand {

	private String address;
	private int risk;
	private boolean electricalAppliancesCoverage;
	private boolean windowsCoverage;
	private boolean facadeCoverage;
	private LocalDateTime startDate;
	private long yearlyPrice;

	public PolicyCommand() {
		super();
	}

	public Policy convertToEntity(ModelMapper modelMapper) {
		return modelMapper.map(this, Policy.class);
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
}
