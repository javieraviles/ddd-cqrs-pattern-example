package es.codeurjc.daw.controller;

public class BasicPolicyDto {

	private long id = -1;
	private String address;
	private boolean electricalAppliancesCover;
	private boolean windowsCover;
	private boolean facadeCover;

	public BasicPolicyDto() {
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

}
