package com.trackfic.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.trackfic.exception.AccidentTypeNotFoundException;
import com.trackfic.exception.ForeignKeyDeletionException;
import com.trackfic.mapper.AccidentTypeMapper;
import com.trackfic.model.AccidentType;

@Component
public class AccidentTypeDaoImpl implements AccidentTypeDaoInterface {

	private final JdbcTemplate jdbcTemplate;
	private AccidentType returnedAccidentType;

	public AccidentTypeDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		returnedAccidentType = new AccidentType();
	}

	@Override
	public AccidentType createNewAccidentType(AccidentType accidentType) {

		jdbcTemplate.update("ALTER TABLE accidenttype AUTO_INCREMENT =1;");

		String sql = "insert into accidenttype (accident_type) values (?)";

		jdbcTemplate.update(sql, accidentType.getAccidentType());

		sql = "select max(accident_type_id) from accidenttype";
		int max = jdbcTemplate.queryForObject(sql, Integer.class);

		accidentType.setTypeId(max);

		return accidentType;
	}

	@Override
	public List<AccidentType> getAllAccidentTypes() {

		String sql = "select * from accidenttype";

		return jdbcTemplate.query(sql, new AccidentTypeMapper());
	}

	@Override
	public AccidentType findAccidentTypeById(int id) {

		String sql = "select * from accidenttype where accident_type_id=?";

		try {
			returnedAccidentType = jdbcTemplate.queryForObject(sql, new Object[] { id }, new AccidentTypeMapper());
		} catch (Exception e) {
			throw new AccidentTypeNotFoundException("Accident Type with ID: " + id + " not found");
		}
		return returnedAccidentType;
	}

	@Override
	public void updateAccidentType(AccidentType accidentType) {

		String sql = "update accidenttype set accident_type=? where accident_type_id=?";
		jdbcTemplate.update(sql, accidentType.getAccidentType(), accidentType.getTypeId());

	}

	@Override
	public void deleteAccidentType(int id) {
		try {
			String sql = "delete from accidenttype where accident_type_id=?";
			jdbcTemplate.update(sql, new Object[] { id });
		} catch (Exception e) {
			throw new ForeignKeyDeletionException(
					"Foreign key references object to be deleted ensure correct delete order is followed");
		}

	}

}
