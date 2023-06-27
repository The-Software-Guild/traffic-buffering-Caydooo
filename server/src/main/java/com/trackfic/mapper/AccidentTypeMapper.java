package com.trackfic.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.trackfic.model.AccidentType;

public class AccidentTypeMapper implements RowMapper<AccidentType> {

	@Override
	public AccidentType mapRow(ResultSet rs, int rowNum) throws SQLException {

		int typeId = rs.getInt("accident_type_id");
		String accidentType = rs.getString("accident_type");

		AccidentType accType = new AccidentType(typeId, accidentType);
		return accType;
	}

}
