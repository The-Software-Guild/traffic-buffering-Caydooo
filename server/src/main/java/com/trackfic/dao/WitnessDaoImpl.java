package com.trackfic.dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.trackfic.exception.ForeignKeyDeletionException;
import com.trackfic.exception.WitnessNotFoundException;
import com.trackfic.mapper.WitnessMapper;
import com.trackfic.model.Witness;

@Component
public class WitnessDaoImpl implements WitnessDaoInterface {

	private final JdbcTemplate jdbcTemplate;
	private Witness returnedWitness;

	public WitnessDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		returnedWitness = new Witness();
	}

	@Override
	public Witness createNewWitness(Witness witness) {

		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			byte[] hashedPassword = md.digest(witness.getPassword().getBytes(StandardCharsets.UTF_8));

			String password = Base64.getEncoder().encodeToString(hashedPassword);
			String sql = "insert into witness values (?,?,?,?,?)";
			jdbcTemplate.update(sql, witness.getEmail(), witness.getFirstName(), witness.getLastName(),
					witness.getMobile(), password);

			return witness;

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Witness> getAllWitnesss() {

		String sql = "select * from witness";

		return jdbcTemplate.query(sql, new WitnessMapper());

	}

	@Override
	public Witness findWitnessByEmail(String email) {

		String sql = "select * from witness where witness_email=?";

		try {
			returnedWitness = jdbcTemplate.queryForObject(sql, new Object[] { email }, new WitnessMapper());
		} catch (Exception ex) {
			throw new WitnessNotFoundException("Witness with email: " + email + " not found");
		}

		return returnedWitness;
	}

	@Override
	public void updateWitness(Witness witness) {

		String sql = "update witness set first_name =?, last_name =?, mobile=?, password=? where witness_email=?";

		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");

			byte[] hashedPassword = md.digest(witness.getPassword().getBytes(StandardCharsets.UTF_8));

			String pword = Base64.getEncoder().encodeToString(hashedPassword);

			jdbcTemplate.update(sql, witness.getFirstName(), witness.getLastName(), witness.getMobile(), pword,
					witness.getEmail());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteWitness(String email) {
		try {
			String sql = "delete from witness where witness_email =?";
			jdbcTemplate.update(sql, new Object[] { email });
		} catch (Exception e) {
			throw new ForeignKeyDeletionException(
					"Foreign key references object to be deleted ensure correct delete order is followed");
		}
	}

	@Override
	public Witness login(String email, String password) {
		String sql = "select * from witness where witness_email=?";

		try {
			returnedWitness = jdbcTemplate.queryForObject(sql, new Object[] { email }, new WitnessMapper());

			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

			String pword = Base64.getEncoder().encodeToString(hashedPassword);

			if (returnedWitness.getPassword().equals(pword)) {
				returnedWitness.setPassword(password);
				return returnedWitness;
			} else {
				throw new Exception();
			}
		} catch (Exception ex) {
			throw new WitnessNotFoundException("Cannot find a witness matching those credentials");
		}

	}

}
