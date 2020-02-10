package es.codeurjc.daw.model;

import javax.persistence.Embeddable;

@Embeddable
public class ClientContact {
	public String email;
	public String phone;

	public ClientContact() {
	}

	public ClientContact(String email, String phone) {
		super();
		if (!isPhoneValid(phone) || !isEmailValid(email)) {
			throw new IllegalArgumentException();
		}
		this.email = email;
		this.phone = phone;
	}

	private boolean isPhoneValid(String phone) {
		// some logic here to validate a phone based on client contact business logic
		return true;
	}

	private boolean isEmailValid(String email) {
		// some logic here to validate an email based on client contact business logic
		return true;
	}

}