package com.trackfic.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.trackfic.enums.AccidentSeverity;
import com.trackfic.exception.SeverityNotFoundException;
import com.trackfic.mapper.SeverityMapper;

@Component
public class SeverityDaoImpl implements SeverityDaoInterface {

	private final JdbcTemplate jdbcTemplate;

	public SeverityDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public AccidentSeverity findSeverityByValue(String value) {

		String sql = "select * from severity where severity=?";
		AccidentSeverity severity;
		try {
			severity = jdbcTemplate.queryForObject(sql, new Object[] { value }, new SeverityMapper());
		} catch (Exception ex) {
			throw new SeverityNotFoundException("Severity with value: " + value + " not found");
		}
		return severity;

	}

	@Override
	public List<AccidentSeverity> getAllSeverities() {

		String sql = "select * from severity";

		return jdbcTemplate.query(sql, new SeverityMapper());
	}

}
