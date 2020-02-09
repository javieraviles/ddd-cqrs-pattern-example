package es.codeurjc.daw.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import es.codeurjc.daw.model.Status;
import es.codeurjc.daw.ui.ClaimDto;

@Service
public class InsuranceQueryService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<ClaimDto> getOpenedClaims() {
		return jdbcTemplate.query("SELECT * FROM CLAIM WHERE STATUS = ?", new Object[] { Status.OPENED.toString() },
				new BeanPropertyRowMapper<>(ClaimDto.class));
	}

}
