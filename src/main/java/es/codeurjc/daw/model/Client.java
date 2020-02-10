package es.codeurjc.daw.model;

import java.time.LocalDate;

import javax.persistence.Embedded;
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
	@Embedded
	private ClientContact contact;
	private LocalDate birthDate;

	public Client() {
	}

	public Client(String name, ClientContact contact, LocalDate birthDate) {
		super();
		this.name = name;
		this.contact = contact;
		this.birthDate = birthDate;
	}

	public long getId() {
		return id;
	}

}
