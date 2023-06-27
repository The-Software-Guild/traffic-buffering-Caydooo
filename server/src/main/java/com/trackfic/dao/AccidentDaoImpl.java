package com.trackfic.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.trackfic.exception.AccidentNotFoundException;
import com.trackfic.exception.ForeignKeyDeletionException;
import com.trackfic.exception.IntegrityConstraintUnsatisfiedException;
import com.trackfic.exception.WitnessNotFoundException;
import com.trackfic.mapper.AccidentMapper;
import com.trackfic.model.Accident;

@Component
public class AccidentDaoImpl implements AccidentDaoInterface {

	private final JdbcTemplate jdbcTemplate;
	private Accident returnedAccident;

	public AccidentDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		returnedAccident = new Accident();
	}

	@Override
	public Accident createNewAccident(Accident accident) {

		// used to reset auto_increment if there is any fail on insert prior
		jdbcTemplate.update("ALTER TABLE accident AUTO_INCREMENT =1;");

		// Insert new record into DB
		String sql = "insert into accident (vehicle_count,accident_date,accident_time,accident_desc,location_id,accident_type_id,witness_email,severity) values(?,?,?,?,?,?,?,?)";
		try {
			jdbcTemplate.update(sql, accident.getVehicleCount(), accident.getAccidentDate(), accident.getAccidentTime(),
					accident.getAccidentDesc(), accident.getLocationId(), accident.getAccidentTypeId(),
					accident.getWitnessEmail(), accident.getAccidentSeverity().toString());

			sql = "select max(accident_id) from accident";
			int max = jdbcTemplate.queryForObject(sql, Integer.class);

			accident.setAccidentId(max);
			return accident;
		} catch (DataAccessException e) {
			throw new IntegrityConstraintUnsatisfiedException("Witness email does not match an existing record");
		}

	}

	@Override
	public List<Accident> getAllAccidents() {
		// Get all records from DB
		String sql = "select * from accident";
		return jdbcTemplate.query(sql, new AccidentMapper());
	}

	@Override
	public Accident findAccidentById(int id) {

		// Get a specific record from DB
		String sql = "select * from accident where accident_id=?";

		try {
			returnedAccident = jdbcTemplate.queryForObject(sql, new Object[] { id }, new AccidentMapper());
		} catch (Exception ex) {
			// If not found throw accident not found exception
			throw new AccidentNotFoundException("Accident with ID: " + id + " not found");
		}
		return returnedAccident;
	}

	@Override
	public void updateAccident(Accident accident) {
		// Update an existing record in DB
		String sql = "update accident set vehicle_count=?, accident_date=?, accident_time=?, accident_desc=?, location_id=?, accident_type_id=?, witness_email=?, severity=? where accident_id=? ";
		jdbcTemplate.update(sql, accident.getVehicleCount(), accident.getAccidentDate(), accident.getAccidentTime(),
				accident.getAccidentDesc(), accident.getLocationId(), accident.getAccidentTypeId(),
				accident.getWitnessEmail(), accident.getAccidentSeverity().toString(), accident.getAccidentId());
	}

	@Override
	public void deleteAccident(int id) {
		// Delete specific record in DB
		try {
			String sql = "delete from accident where accident_id=?";
			jdbcTemplate.update(sql, new Object[] { id });
		} catch (Exception e) {
			// Should only enter when record references this record
			throw new ForeignKeyDeletionException(
					"Foreign key references object to be deleted ensure correct delete order is followed");
		}

	}

	@Override
	public List<Accident> findAccidentsByWitnessEmail(String email) {

		String sql = "select * from accident where witness_email=?";

		List<Accident> accidents = jdbcTemplate.query(sql, new Object[] { email }, new AccidentMapper());

		if (accidents == null) {
			throw new WitnessNotFoundException("Witness with email: " + email + " has not reported any accidents");
		}

		return accidents;
	}

}
