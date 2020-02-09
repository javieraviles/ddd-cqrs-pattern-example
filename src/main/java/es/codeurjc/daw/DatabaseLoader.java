package es.codeurjc.daw;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import es.codeurjc.daw.model.Client;
import es.codeurjc.daw.persistence.ClientRepository;

@Controller
public class DatabaseLoader implements CommandLineRunner {

	@Autowired
	ClientRepository clientRepository;

	@Override
	public void run(String... args) {

		final Client client = new Client("Maria Frutos", "mfrutos@gmail.com", "(+34)679-434-111",
				LocalDate.of(1984, 10, 10));
		clientRepository.save(client);
	}
}
