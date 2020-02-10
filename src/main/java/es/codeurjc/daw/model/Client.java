package es.codeurjc.daw.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id = -1;
	private String name;
	private String email;
	private String phone;
	private LocalDate birthDate;

	public Client() {
	}

	public Client(String name, String email, String phone, LocalDate birthDate) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.birthDate = birthDate;
	}

	public long getId() {
		return id;
	}

}
